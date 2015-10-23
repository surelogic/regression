package testHadoop;

import java.util.*;

public abstract class Param<T, D extends Param.Domain<T>> {
	static final Comparator<Param<?,?>> NAME_CMP = new Comparator<Param<?,?>>() {
		@Override
		public int compare(Param<?, ?> left, Param<?, ?> right) {
			return left.getName().compareTo(right.getName());
		}
	};	

	public static String toSortedString(final String separator,
			final Param<?, ?>... parameters) {
		Arrays.sort(parameters, NAME_CMP);		
		final StringBuilder b = new StringBuilder();
		/*
		try {
			for(Param<?, ?> p : parameters) {
				if (p.getValue() != null) {
					b.append(separator).append(
							URLEncoder.encode(p.getName(), "UTF-8")
							+ "="
									+ URLEncoder.encode(p.getValueString(), "UTF-8"));
				}
			}
		} catch (UnsupportedEncodingException e) {
			// Sane systems know about UTF-8, so this should never happen.
			throw new RuntimeException(e);
		}
		 */
		return b.toString();
	}

	/** @return the parameter name. */
	public abstract String getName();	
	
	/** Base class of parameter domains. */
	static abstract class Domain<T> {
	}
}
