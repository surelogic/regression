package org.easymock;

public interface IExpectationSetters<T> {
    IExpectationSetters<T> andReturn(T value);
    IExpectationSetters<T> andThrow(Throwable throwable);    
}
