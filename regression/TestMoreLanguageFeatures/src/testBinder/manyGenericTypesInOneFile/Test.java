package testBinder.manyGenericTypesInOneFile;

public class Test<T1, T2 extends Enum<T2>, T3 extends Enum<T3>, T4> {
	private Test
	(Test<T1, T2, T3, T4> that,	ApplicableSingleOrMultipleTransition t) {
	}
	
	public Test<T1,T2,T3,T4>
	addTransition(T2 preState, T2 postState, T3 eventType,
			SingleArcTransition<T1, T4> hook){
		return new Test
		(this, new ApplicableSingleOrMultipleTransition
				(preState, eventType, new SingleInternalArc(postState, hook)));
	}
	
	private class SingleInternalArc
	implements Transition<T1, T2, T3, T4> {
		SingleInternalArc(T2 postState,
				SingleArcTransition<T1, T4> hook) {
		}
	}
	
	static private class ApplicableSingleOrMultipleTransition
    <OPERAND, STATE extends Enum<STATE>,
     EVENTTYPE extends Enum<EVENTTYPE>, EVENT>
	{
		ApplicableSingleOrMultipleTransition
        (STATE preState, EVENTTYPE eventType,
         Transition<OPERAND, STATE, EVENTTYPE, EVENT> transition) {			
		}
	}
	
	
}

interface Transition<T1, T2, T3, T4> {
}
	
class SingleArcTransition<OPERAND, EVENT> {
}