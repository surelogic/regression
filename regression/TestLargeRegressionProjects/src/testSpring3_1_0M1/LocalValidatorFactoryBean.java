package testSpring3_1_0M1;

import javax.validation.Configuration;
import javax.validation.Validation;

public class LocalValidatorFactoryBean {
	private Class providerClass;	
	
	public void afterPropertiesSet() {
		Configuration configuration = (this.providerClass != null ?
				Validation.byProvider(this.providerClass).configure() :
				Validation.byDefaultProvider().configure());
	}
}
