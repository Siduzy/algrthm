package com.insigmaus.datastructure;

import java.util.Iterator;

import com.insigmaus.common.exception.InvalidOperationException;

public class FixedCapacityQueue<T> implements Queueable<T>, Iterable<T>{
	
	private T[] ary;
	private int head;
	private int tail;
	private int N;
	
	@SuppressWarnings("unchecked")
	public FixedCapacityQueue(int capacity) {
		ary  = (T[])new Object[capacity];
	}
	
	public boolean isEmpty() {
		return head == tail;
	}

	public boolean isFull() {
		return N == ary.length;
	}

	public void enqueue(T t) throws InvalidOperationException {
		if (isFull()) {
			throw new InvalidOperationException();
		}
		ary[tail++] = t;
		if (tail == ary.length) {
			tail = 0;
		}
		N++;
	}

	public T dequeue() throws EmptyQueueException {
		if (isEmpty()) {
			throw new EmptyQueueException();
		}
		T toRet = ary[head++];
		if (head == ary.length) {
			head = 0;
		}
		--N;
		return toRet;
	}

	public int size() {
		return N;
	}
	
	public Iterator<T> iterator() {
		return new ArrayIterator<T>(head, tail, ary);
	}
}
