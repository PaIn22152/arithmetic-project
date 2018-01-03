package com.payne.leetCode;

/**
 * Created by payne on 2018-01-03.
 * About 类描述：
 * Implement wildcard pattern matching with support for '?' and '*'.
 '?' Matches any single character.
 '*' Matches any sequence of characters (including the empty sequence).
 The matching should cover the entire input string (not partial).
 The function prototype should be:
 bool isMatch(const char *s, const char *p)
 Some examples:
 isMatch("aa","a") → false
 isMatch("aa","aa") → true
 isMatch("aaa","aa") → false
 isMatch("aa", "*") → true
 isMatch("aa", "a*") → true
 isMatch("ab", "?*") → true
 isMatch("aab", "c*a*b") → false
 */
public class P_44_WildcardMatching {

	public boolean isMatch(String s, String p) {
		return my(s, p);
	}

	public boolean my(String s, String p) {
		if (s == null || p == null) {
			return false;
		}
		if (s.equals(p)) {
			return true;
		}
		if (!containWildcard(s) && !containWildcard(p)) {
			return s.equals(p);
		}
		return true;
	}

	public boolean containWildcard(String s) {
		return s.contains("*") || s.contains("?");
	}
}
