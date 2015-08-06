package testJSure;

public class ExportDrop extends VisibilityDrop<ExportNode> {
  private ExportDrop(ExportNode a) {
    super(a);
  }
  
  public static ExportDrop buildExportDrop(ExportNode en) {
	/*
    if (en.getToModuleName() == null && LOG.isLoggable(Level.INFO)) {
      LOG.info("found an ExportDrop with null fromModName");
    }
    */
    ExportDrop res = new ExportDrop(en);
    res = buildVisDrop(res);
    return res;
  }
}
