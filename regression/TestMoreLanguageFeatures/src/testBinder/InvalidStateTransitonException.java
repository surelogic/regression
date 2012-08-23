package testBinder;

public class InvalidStateTransitonException extends RuntimeException {
	public <STATE extends Enum<STATE>,
    EVENTTYPE extends Enum<EVENTTYPE>> InvalidStateTransitonException(STATE oldState, EVENTTYPE eventType) {
		// TODO Auto-generated constructor stub
	}

}
