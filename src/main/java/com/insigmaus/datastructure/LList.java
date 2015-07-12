package com.insigmaus.datastructure;

import java.util.Iterator;

import com.insigmaus.common.exception.InvalidOperationException;

public class LList<T> implements Iterable<T>{
	private ListNode<T> head;
	private ListNode<T> tail;
	private int N = 0;
	
	public void addToHead(T t) {
		ListNode<T> newFirst = new ListNode<T>(t, head);
		if (head == null) {
			tail = newFirst;
		}
		head = newFirst;
		N++;
	}
	
	public void addToTail(T t) {
		ListNode<T> newTail = new ListNode<T>(t, null);
		if (tail == null) {
			head = newTail;
		} else {
			tail.next = newTail;
		}
		tail = newTail;
		N++;
	}
	
	public T removeFromHead() throws InvalidOperationException {
		if (head == null) {
			throw new InvalidOperationException();
		}
		T toRet = head.t;
		if (head == tail) {
			tail = null;
		} 
		head = head.next;
		N--;
		return toRet;
	}
	
	public T removeFromTail() throws InvalidOperationException {
		if (tail == null) {
			throw new InvalidOperationException();
		}
		T toRet = tail.t;
		if (head == tail) {
			head = tail = null;
		} else {
			ListNode<T> nd = head;
			while( nd.next != tail) {
				nd=nd.next;
			}
			nd.next = null;
			tail = nd;
		}
		return toRet;
	}

	public Iterator<T> iterator() {
		return new ListIterator<T>(head);
	}
}
