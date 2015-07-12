package com.insigmaus.datastructure;

import java.util.Iterator;

import com.insigmaus.utils.ArrayUtils;

public class ArrayStack<T> implements Stackable<T>, Iterable<T>{

	@SuppressWarnings("unchecked")
	private T[] ary = (T[])new Object[1];
	private int N = 0;
	
	public boolean isFull() {
		return N == ary.length;
	}

	public boolean isEmpty() {
		return N == 0;
	}
	
	private void resize(int n) {
		@SuppressWarnings("unchecked")
		T[] newAry = (T[]) new Object[n];
		ArrayUtils.copyArray(ary, newAry);
		ary = newAry;
	}
	
	public void push(T t) {
		if (N == ary.length) {
			resize(2 * N);
		}
		ary[N++] = t;
	}

	public T pop() throws EmptyStackException {
		if (N == 0) {
			throw new EmptyStackException();
		}
		T toRet = ary[--N];
		ary[N] = null;
		if (N > 0 && N < ary.length/4) {
			resize(ary.length / 2);
		}
		return toRet;
	}
	
	public Iterator<T> iterator() {
		return new ReverseArrayIterator<T>(N, ary);
	}

	public int size() {
		return N;
	}
}
