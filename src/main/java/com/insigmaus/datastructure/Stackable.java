package com.insigmaus.datastructure;

import com.insigmaus.common.exception.InvalidOperationException;


public interface Stackable<T> {
	public boolean isEmpty();
	public int size();
	public void push(T t) throws InvalidOperationException;
	public T pop() throws EmptyStackException;
}
