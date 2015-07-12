package com.insigmaus.datastructure;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIterator<T> implements Iterator<T> {

	private int head;
	private int tail;
	private T[] ary;
	public ArrayIterator(int head, int tail, T[] ary) {
		this.head = head;
		this.tail = tail;
		this.ary = ary;
	}
	public boolean hasNext() {
		return head < tail;
	}

	public T next() {
		if (head == tail) {
			throw new NoSuchElementException();
		}
		T toRet = null;
		toRet = ary[head++];
		if (head >= tail && head == ary.length) {
				head = 0;
		}
		return toRet;
	}

	public void remove() {
		throw new UnsupportedOperationException();
	}
}
