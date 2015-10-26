package org.mockito;

public interface OngoingStubbing<T> {
    OngoingStubbing<T> thenReturn(T value);
    OngoingStubbing<T> thenReturn(T value, T... values);
}
