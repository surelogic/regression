package testSpring3_1_0M1;

//import java.io.ByteArrayOutputStream;
//import java.io.StringWriter;
//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;
//import javax.xml.stream.XMLEventWriter;
//import javax.xml.stream.XMLOutputFactory;
//import javax.xml.stream.XMLStreamWriter;
//import javax.xml.transform.Result;
import javax.xml.transform.dom.DOMResult;
//import javax.xml.transform.stax.StAXResult;
//import javax.xml.transform.stream.StreamResult;

import static org.custommonkey.xmlunit.XMLAssert.*;
//import org.custommonkey.xmlunit.XMLUnit;
import static org.junit.Assert.assertTrue;
//import org.junit.Before;
//import org.junit.Test;
//import org.w3c.dom.Attr;
import org.w3c.dom.Document;
//import org.w3c.dom.Element;
//import org.w3c.dom.Text;

//import org.springframework.util.xml.StaxUtils;

public class AbstractMarshallerTests {
	public void marshalEmptyDOMResult() throws Exception {
		DOMResult domResult = new DOMResult();
		assertTrue("DOMResult does not contain a Document", domResult.getNode() instanceof Document);
	}
}
