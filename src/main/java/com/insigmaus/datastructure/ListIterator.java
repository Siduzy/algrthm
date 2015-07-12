package com.insigmaus.datastructure;

import java.util.Iterator;

class ListIterator<T> implements Iterator<T> {

	private ListNode<T> first;
	ListIterator(ListNode<T> first) {
		this.first = first;
	}
	public boolean hasNext() {
		
		return first != null;
	}

	public T next() {
		T toRet = first.t;
		first = first.next;
		return toRet;
	}

	public void remove() {
		throw new UnsupportedOperationException();
	}
	
}