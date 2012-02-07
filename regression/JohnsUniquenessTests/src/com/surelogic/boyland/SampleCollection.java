package com.surelogic.boyland;

import java.util.Iterator;

import com.surelogic.Assume;
import com.surelogic.Borrowed;
import com.surelogic.Immutable;
import com.surelogic.ReadOnly;
import com.surelogic.RegionEffects;
import com.surelogic.Unique;

public class SampleCollection implements Iterable<String> {
	@Unique private String[] contents;
	
	@Borrowed("this")
	public SampleCollection() {
		contents = new String[]{"hickory","dickery","dock"};
	}
	
	private static final boolean USE_NESTED = true;
	
	/*
	 * Example 1:
	 * We have a write effect and we borrow it to create a
	 * Unique return value. 
	 */
	@Override
    @Borrowed(value="this",allowReturn=true)
	@RegionEffects("writes this:Instance")
	@Unique("return")
	public Iterator<String> iterator() {
		return USE_NESTED ? new MyIterator() : new MyStaticIterator(this);
	}
	
	/*
	 * Example 2:
	 * We have a read effect and we borrow it to create a
	 * Unique return value.
	 */
	@Borrowed(value="this",allowReturn=true)
	@RegionEffects("reads this:Instance")
	@Unique("return")
	public Iterator<String> readonlyIterator() {
		MyRemovelessIterator it = new MyRemovelessIterator(this);
		// The following code is now illegal
		/*if (this == it.readonlyOuter) {
			// uniqueness analysis won't realize this is true
			// we could do something nasty here.
			return null;
		}*/
		return it;
	}
	
	/*
	 * Example 3:
	 * We have a write effect and use it to create a 
	 * Unique return value (as in Example 1), but this is an explicit
	 * field reference, not created externally.
	 * We need a write effect because the return is using the unique field.
	 */
	@Borrowed(value="this",allowReturn=true)
	@RegionEffects("writes this:Instance")
	@Unique("return")
	public String[] toArray() {
		return contents;
	}
	
	/*
	 * Example 4:
	 * We have a read effect and use it to create an
	 * Immutable return value (unlike Example 2).
	 * Unlike 3, we don't need a write effect.
	 */
	@Borrowed(value="this",allowReturn=true)
	@RegionEffects("reads this:Instance")
	@Immutable("return")
	public String[] toReadonlyArray() {
		return contents;
	}
	
	/*
	 * Example 5:
	 * Testing immutability allows us to return the array.
	 */
	@Immutable(value="this, return")
	@RegionEffects("none")
	public String[] toImmutableArray() {
		return contents;
	}
	
	
	
	/**
	 * @annotate Borrowed("SampleCollection.this")
	 */
	@Borrowed("SampleCollection.this")
	private class MyIterator implements Iterator<String> {
	    @SuppressWarnings("unused")
        @Unique("return")
		@Borrowed(value="SampleCollection.this", allowReturn=true)
		@RegionEffects("writes SampleCollection.this:Instance")
		public MyIterator() {
			/*
			 * We implicitly borrow our outer this.
			 */
			String test = "Unique CON";
		}
		
		private int i = -1;
		
		@Override
		@Borrowed("this")
		@RegionEffects("reads this:Instance")
		public boolean hasNext() {
			return (i+1) < contents.length;
		}

		@Override
        @Borrowed("this")
		@RegionEffects("writes this:Instance")
		public String next() {
			++i;
			return contents[i];
		}

		@Override
        @Borrowed("this")
		@RegionEffects("writes this:Instance")
		public void remove() {
			if (i < 0) throw new IllegalStateException("iteration not started");
			SampleCollection o = SampleCollection.this;
			// Hack: permits multiple removes at other times.
			String[] newcontents = new String[o.contents.length - 1];
			for (int j=0; j < i; ++j) newcontents[j] = o.contents[j];
			for (int j=i; j < newcontents.length; ++j) newcontents[j] = o.contents[i+1];
			o.contents = newcontents;
		}
		
	}
	
	private static class MyStaticIterator implements Iterator<String> {

		final @Borrowed SampleCollection outer;
		
		@Borrowed("this")
		@RegionEffects("writes o:Instance")
		public MyStaticIterator(final @Borrowed(allowReturn=true) SampleCollection o) {
			/*
			 * The following assignment is legal because:
			 * (1) o allows return (we are a constructor, we can borrow things for our lifetime)
			 * (2) outer is borrowed
			 * (3) we have write access to o:Instance
			 */
			outer = o;
		}
		
		private int i = -1;
		
		@Override
        @Borrowed("this")
		@RegionEffects("reads this:Instance")
		public boolean hasNext() {
			return (i+1) < outer.contents.length;
		}

		@Override
        @Borrowed("this")
		@RegionEffects("writes this:Instance")
		public String next() {
			++i;
			return outer.contents[i];
		}

		@Override
        @Borrowed("this")
		@RegionEffects("writes this:Instance")
		@Assume("@RegionEffects(none) for new(*) in IllegalStateException")
		public void remove() {
			if (i < 0) throw new IllegalStateException("iteration not started");
			SampleCollection o = outer;
			// Hack: permits multiple removes at other times.
			String[] newcontents = new String[o.contents.length - 1];
			for (int j=0; j < i; ++j) newcontents[j] = o.contents[j];
			for (int j=i; j < newcontents.length; ++j) newcontents[j] = o.contents[i+1];
			o.contents = newcontents;
		}
		
	}

	/**
	 * @annotate ReadOnly("SampleCollection.this")
	 * @annotate Borrowed("SampleCollection.this")
	 */
	private static class MyRemovelessIterator implements Iterator<String> {

		final @Borrowed @ReadOnly SampleCollection readonlyOuter;
		
		@Borrowed("this")
		@RegionEffects("reads o:Instance")
		public MyRemovelessIterator(@Borrowed(allowReturn=true) final SampleCollection o) {
			/*
			 * The following assignment is legal because:
			 * (1) o allows return (we are a constructor, we can borrow things for our lifetime)
			 * (2) outer is final borrowed read-only
			 * (3) we have read access to o:Instance
			 */
			readonlyOuter = o;
		}
		
		private int i = -1;
		
		@Override
        @Borrowed("this")
		@RegionEffects("reads this:Instance")
		public boolean hasNext() {
			return (i+1) < readonlyOuter.contents.length;
		}

		@Override
        @Borrowed("this")
		@RegionEffects("writes this:Instance")
		public String next() {
			++i;
			return readonlyOuter.contents[i];
		}

		@Override
        @Borrowed("this")
		@RegionEffects("none")
		@Assume("@RegionEffects(none) for new(*) in UnsupportedOperationException")
		public void remove() {
			throw new UnsupportedOperationException("iteration not started");
		}
		
	}

	public static class Test {
		@Unique SampleCollection col = new SampleCollection();
		
		@RegionEffects("none")
		@Borrowed("this")
		@Override
		public String toString() {
			return super.toString(); // won't assure because we don't have implementation-only for uniqueness+effects
		}
		
		@RegionEffects("reads this:Instance")
		// Go a SEVERE warning.  Irrelevant now that Iterator itself is decorated
		// @Assume("@RegionEffects(reads this:Instance) for hasNext() in Iterator")
		public String catAll() {
			String result = "";
			for (String s : col) {
				result += s + this; // testing implicit toString too
			}
			return result;
		}
		
		@RegionEffects("reads this:Instance")
		public String catAll2() {
			String result = "";
			Iterator<String> it = col.readonlyIterator();
			while (it.hasNext()) {
				result += it.next();
			}
			return result;
		}
		
		@RegionEffects("writes this:Instance")
		public void removeFirst() {
			Iterator<String> it = col.iterator();
			it.next();
			it.remove();
		}
	}
}
