package testVertx;

import java.util.concurrent.atomic.AtomicReference;

public class LauncherExtensibilityTest extends CommandTestBase {
	static AtomicReference<Boolean> spy = new AtomicReference<>();

	//@Test
	public void testThatALauncherCanAddACommand() {
		/*
		Launcher myLauncher = new Launcher() {

			@Override
			protected void load() {
				super.load();
				register(FooCommand.class);
			}
		};

		myLauncher.dispatch(new String[]{"foo"});
		assertThat(myLauncher.getCommandNames()).contains("foo");
		*/
		waitUntil(spy::get);
	}
}
