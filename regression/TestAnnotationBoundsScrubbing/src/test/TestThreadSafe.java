package test;

import com.surelogic.ThreadSafe;

@ThreadSafe(
    whenImmutable={"B", "E" },
    whenThreadSafe={"C", "F"},
    whenContainable={"A", "D"})
public class TestThreadSafe<A, B, C> {

}
