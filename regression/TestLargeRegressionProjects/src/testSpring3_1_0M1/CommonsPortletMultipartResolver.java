package testSpring3_1_0M1;

import java.util.List;

public class CommonsPortletMultipartResolver extends CommonsFileUploadSupport {
	MultipartParsingResult test() {
		String encoding = null;
		List<FileItem> fileItems = null;
		return parseFileItems(fileItems, encoding); 
		// TODO needs FileItem to be on the classpath of two different projects (A <- B)
	}
	/*
	protected MultipartParsingResult parseRequest(ActionRequest request) throws MultipartException {
		String encoding = determineEncoding(request);
		FileUpload fileUpload = prepareFileUpload(encoding);
		try {
			List<FileItem> fileItems = ((PortletFileUpload) fileUpload).parseRequest(request);
			return parseFileItems(fileItems, encoding);
		}
		catch (FileUploadBase.SizeLimitExceededException ex) {
			throw new MaxUploadSizeExceededException(fileUpload.getSizeMax(), ex);
		}
		catch (FileUploadException ex) {
			throw new MultipartException("Could not parse multipart portlet request", ex);
		}
	}
	*/
}
