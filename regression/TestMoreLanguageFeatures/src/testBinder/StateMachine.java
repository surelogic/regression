package testBinder;

public interface StateMachine<STATE, EVENTTYPE, EVENT> {
	STATE getCurrentState();
	STATE doTransition(EVENTTYPE eventType, EVENT event);
}
