package com.payne.leetCode.p_old;

/**
 * Created by payne on 2018-01-02.
 * About 类描述：
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */
public class P_28_ImplementStrStr {
	public int strStr(String haystack, String needle) {
		return my(haystack, needle);
	}

	public int my(String haystack, String needle) {
		if (haystack.contains(needle)) {
			return haystack.indexOf(needle);
		}
		return -1;
	}
}
