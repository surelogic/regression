package testSpring3_1_0M1;

public class GenericConversionService {
	public <T> T convert(Object source, Class<T> targetType) {
		return null;
	}
	
	@SuppressWarnings("unchecked")
	private final class ConverterFactoryAdapter implements GenericConverter {

		//private final ConvertiblePair typeInfo;

		private final ConverterFactory converterFactory;

		public ConverterFactoryAdapter(/*ConvertiblePair typeInfo, */ConverterFactory<?, ?> converterFactory) {
			this.converterFactory = converterFactory;
			//this.typeInfo = typeInfo;
		}
		/*
		public Set<ConvertiblePair> getConvertibleTypes() {
			return Collections.singleton(this.typeInfo);
		}
		*/
		public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
			/*		
			if (source == null) {
				return convertNullSource(sourceType, targetType);
			}
			*/
			return this.converterFactory.getConverter(targetType.getObjectType()).convert(source);
		}	
	}
}
