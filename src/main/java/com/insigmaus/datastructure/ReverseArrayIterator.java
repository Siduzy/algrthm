package com.insigmaus.datastructure;

import java.util.Iterator;
import java.util.NoSuchElementException;
class ReverseArrayIterator<T> implements Iterator<T>{

	private int pos;
	private T[] ary;
	
	ReverseArrayIterator(int pos, T[] ary) {
		this.pos = pos;
		this.ary = ary;
	}

	public boolean hasNext() {
		return pos > 0;
	}

	public T next() {
		if (pos <= 0) {
			throw new NoSuchElementException();
		}
		return ary[--pos];
	}

	public void remove() {
		throw new UnsupportedOperationException();
	}
}