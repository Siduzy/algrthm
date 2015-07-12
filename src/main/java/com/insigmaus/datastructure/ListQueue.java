package com.insigmaus.datastructure;

import java.util.Iterator;

import com.insigmaus.common.exception.InvalidOperationException;

public class ListQueue<T> implements Queueable<T>, Iterable<T>{

	private ListNode<T> first;
	private ListNode<T> last;
	private int N;
	
	public boolean isEmpty() {		
		return N == 0;
	}

	public boolean isFull() {
		return false;
	}

	public void enqueue(T t) throws InvalidOperationException {
		ListNode<T> node = new ListNode<T>(t, null);
		if (N == 0) {
			first = node;
		} else {
			last.next = node;
		}
		last = node;
		N++;
	}

	public T dequeue() throws EmptyQueueException {
		if (N == 0) {
			throw new EmptyQueueException();
		}
		T toRet = first.t;
		if (first == last) {
			last = null;
		}
		first = first.next;
		N--;
		return toRet;
	}

	public int size() {
		return N;
	}

	public Iterator<T> iterator() {
		return new ListIterator<T>(first);
	}
}
