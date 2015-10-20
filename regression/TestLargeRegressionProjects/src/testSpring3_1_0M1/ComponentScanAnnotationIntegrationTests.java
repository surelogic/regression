package testSpring3_1_0M1;

import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.assertThat;

public class ComponentScanAnnotationIntegrationTests {
	//@Test
	public void invalidComponentScanDeclaration_noPackagesSpecified() {
		//AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		//ctx.register(ComponentScanWithNoPackagesConfig.class);
		try {
			//ctx.refresh();
			//fail("Expected exception when parsing @ComponentScan definition that declares no packages");
			throw new BeanDefinitionParsingException();
		} catch (BeanDefinitionParsingException ex) {
			assertThat(ex.getMessage(), containsString("At least one base package must be specified"));
		}
	}
}
