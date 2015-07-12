package com.insigmaus.datastructure;

import java.util.Iterator;

import com.insigmaus.common.exception.InvalidOperationException;

public class ListStack<T> implements Stackable<T>, Iterable<T> {
	private ListNode<T> top;
	private ListNode<T> buttom;
	private int N;
	
	public Iterator<T> iterator() {
		return new ListIterator<T>(top);
	}
	public boolean isEmpty() {
		return N == 0;
	}
	public int size() {
		return N;
	}
	public void push(T t) throws InvalidOperationException {
		ListNode<T> nd = new ListNode<T>(t, top);
		nd.next = top;
		if (N == 0) {
			top = nd;
		}
		top = nd.next;
		N++;
	}
	public T pop() throws EmptyStackException {	
		if (top == null) {
			throw new EmptyStackException();
		}
		T t = top.t;
		if (top == buttom) {
			buttom = null;
		}
		top = top.next;
		N--;
		return t;
	}
}
