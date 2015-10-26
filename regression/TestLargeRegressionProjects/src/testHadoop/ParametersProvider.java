package testHadoop;

import java.util.*;

public class ParametersProvider
//extends AbstractHttpContextInjectable<Parameters>
//implements InjectableProvider<Context, Type> {
{
	private String driverParam;
	private Class<? extends Enum> enumClass;
	private Map<Enum, Class<Param<?>>[]> paramsDef;

	public ParametersProvider(String driverParam, Class<? extends Enum> enumClass,
			Map<Enum, Class<Param<?>>[]> paramsDef) {

	}
	
	public abstract class Param<T> {
		
	}
}