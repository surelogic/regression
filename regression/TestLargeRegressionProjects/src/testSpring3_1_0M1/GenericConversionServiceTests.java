package testSpring3_1_0M1;

public class GenericConversionServiceTests {
	private GenericConversionService conversionService;
	
	public void convertAssignableSource() {
		assertEquals(Boolean.FALSE, conversionService.convert(false, boolean.class));
		assertEquals(Boolean.FALSE, conversionService.convert(false, Boolean.class));
	}

	private void assertEquals(Boolean false1, Boolean convert) {
		// TODO Auto-generated method stub
		
	}
}
