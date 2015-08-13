package testJSure;

public class ResultsBuilder {
	private final PromiseDrop<?> promiseDrop = null;
	  
	public final ResultFolderDrop createRootAndFolder(
			final IRNode node, final int trueMsg, final int falseMsg, 
			final Object... args) {
		final ResultFolderDrop folder = null;//ResultFolderDrop.newAndFolder(node);
		folder.addChecked(promiseDrop);
		//folder.setMessagesByJudgement(trueMsg, falseMsg, args);
		return folder;

	}
}
