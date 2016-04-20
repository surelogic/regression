package vertx.launcher.commands;

import java.io.File;
import java.util.List;

public abstract class DefaultCommand implements Command {

	  private File cwd;
	  protected List<String> systemProperties;

}
