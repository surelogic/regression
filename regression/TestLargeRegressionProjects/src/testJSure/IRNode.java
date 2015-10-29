package testJSure;

public interface IRNode {

	<T> T getSlotValue(SlotInfo<T> slotInfo);
	<T> boolean valueExists(SlotInfo<T> hashsi);

}
