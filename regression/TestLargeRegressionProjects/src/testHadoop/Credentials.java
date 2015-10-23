package testHadoop;

import java.util.*;

public class Credentials implements Writable {
	private  Map<Text, byte[]> secretKeysMap = new HashMap<Text, byte[]>();	
	private  Map<Text, Token<? extends TokenIdentifier>> tokenMap = 
			new HashMap<Text, Token<? extends TokenIdentifier>>(); 

	private void addAll(Credentials other, boolean overwrite) {
		/*
		for(Map.Entry<Text, byte[]> secret: other.secretKeysMap.entrySet()) {
			Text key = secret.getKey();
			if (!secretKeysMap.containsKey(key) || overwrite) {
				secretKeysMap.put(key, secret.getValue());
			}
		}
		*/
		for(Map.Entry<Text, Token<?>> token: other.tokenMap.entrySet()){
			Text key = token.getKey();
			if (!tokenMap.containsKey(key) || overwrite) {
				tokenMap.put(key, token.getValue());
			}
		}
	}
	
	public void addToken(Text alias, Token<? extends TokenIdentifier> t) {		
	}

	public Collection<Token<? extends TokenIdentifier>> getAllTokens() {
		// TODO Auto-generated method stub
		return null;
	}
}
