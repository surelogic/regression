package testBinder.genericMethod;

import java.util.*;

public class InternalSpelExpressionParser {
	private SpelNodeImpl eatPrimaryExpression() {		
		List<SpelNodeImpl> nodes = new ArrayList<SpelNodeImpl>();		
		SpelNodeImpl start = eatStartNode(); // always a start node
		nodes.add(start);
		/*
		while (maybeEatNode()) {
			nodes.add(pop());
		}
		*/		
		if (nodes.size()==1) {
			return nodes.get(0);
		} else {		
			return new CompoundExpression(toPos(start.getStartPosition(),nodes.get(nodes.size()-1).getEndPosition()),nodes.toArray(new SpelNodeImpl[nodes.size()]));
		}
	}

	private SpelNodeImpl eatStartNode() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * Compress the start and end of a token into a single int
	 */
	private int toPos(Token t) {
		return (t.startpos<<16)+t.endpos;
	}

	private int toPos(int start,int end) {
		return (start<<16)+end;
	}
}
