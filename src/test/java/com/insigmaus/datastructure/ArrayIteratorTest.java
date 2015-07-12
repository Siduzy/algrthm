package com.insigmaus.datastructure;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArrayIteratorTest {
	
	
	
	@Test
	public void testHasNext() {
		ArrayIterator<Integer> iterI = new ArrayIterator<Integer>(0, 0, null);
		assertFalse(iterI.hasNext());
	}

}
