package com.insigmaus.datastructure;


class ListNode<T> {
	T t;
	ListNode<T> next;
	
	ListNode() {}
	
	ListNode(T t, ListNode<T> next) {
		this.t = t;
		this.next = next;
	}
}
