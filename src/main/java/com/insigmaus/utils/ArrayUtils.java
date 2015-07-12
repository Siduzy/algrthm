package com.insigmaus.utils;

public class ArrayUtils {
	public static <T> void copyArray(T[] from, T[] to) {
		if (from == null || to == null) {
			return;
		}
		int szToCopy = Math.min(from.length, to.length);
		copyArray(from, to, szToCopy);
	}
	
	public static <T> void copyArray(T[] from, T[] to, int cpSize) {
		if (from == null || to == null) {
			return;
		}
		
		int szToCopy = Math.min(from.length, to.length);
		szToCopy = Math.min(szToCopy, cpSize);
		
		for (int i = 0; i < szToCopy; ++i) {
			to[i] = from[i];
		}
	}
}
