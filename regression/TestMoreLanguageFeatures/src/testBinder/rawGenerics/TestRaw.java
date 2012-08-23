package testBinder.rawGenerics;

import java.io.IOException;
import java.sql.*;

public class TestRaw {
	public SqlXmlValue newSqlXmlValue(final Class resultClass, final XmlResultProvider provider) {
		return new AbstractJdbc4SqlXmlValue() {
			@Override
			@SuppressWarnings("unchecked")
			protected void provideXml(SQLXML xmlObject) throws SQLException, IOException {
				provider.provideXml(xmlObject.setResult(resultClass));
			}
		};
	}
}
