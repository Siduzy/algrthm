package com.insigmaus.datastructure;

import java.util.Iterator;

import com.insigmaus.common.exception.InvalidOperationException;

public class FixedCapacityStack<T> implements Iterable<T>, Stackable<T>{
	private T[] ary = null;
	private int N = 0;
	
	@SuppressWarnings("unchecked")
	public FixedCapacityStack(int capacity) {
		ary = (T[]) new Object[capacity];
	}

	public boolean isFull() {
		return N == ary.length;
	}

	public boolean isEmpty() {
		return N == 0;
	}

	public void push(T t) throws InvalidOperationException {
		if (N == ary.length) {
			throw new InvalidOperationException();
		}
		ary[N++] = t;
	}

	public T pop() throws EmptyStackException {
		if (N == 0) {
			throw new EmptyStackException();
		}
		T toRet = ary[--N];
		ary[N] = null;
		return toRet;
	}

	public Iterator<T> iterator() {
		return new ReverseArrayIterator<T>(N, ary);
	}

	public int size() {
		return N;
	}
}
