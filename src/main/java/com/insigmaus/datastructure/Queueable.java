package com.insigmaus.datastructure;

import com.insigmaus.common.exception.InvalidOperationException;

public interface Queueable<T>{
	public boolean isEmpty();
	public boolean isFull();
	public int size();
	public void enqueue(T t) throws InvalidOperationException;
	public T dequeue() throws EmptyQueueException;
}
