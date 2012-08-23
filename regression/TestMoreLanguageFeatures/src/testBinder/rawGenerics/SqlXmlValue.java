package testBinder.rawGenerics;

import java.io.IOException;
import java.sql.*;

public abstract class SqlXmlValue {
	protected abstract void provideXml(SQLXML xmlObject) throws SQLException, IOException;
}
