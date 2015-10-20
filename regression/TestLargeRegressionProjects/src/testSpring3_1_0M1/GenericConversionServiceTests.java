package testSpring3_1_0M1;

import java.util.*;

public class GenericConversionServiceTests {
	private GenericConversionService conversionService;
	
	public void convertAssignableSource() {
		assertEquals(Boolean.FALSE, conversionService.convert(false, boolean.class));
		assertEquals(Boolean.FALSE, conversionService.convert(false, Boolean.class));
	}

	private void assertEquals(Boolean false1, Boolean convert) {
		// TODO Auto-generated method stub
		
	}
	
	//@Test
	public void testListOfList() {
		//GenericConversionService service = new DefaultConversionService();
		List<List<String>> list = Collections.singletonList(Collections.singletonList("Foo"));
		//assertNotNull(service.convert(list, String.class));
	}
}
