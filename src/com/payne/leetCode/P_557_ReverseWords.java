package com.payne.leetCode;

/**
 * Created by payne on 2018-01-09.
 * About 类描述：
 * Given a string, you need to reverse the order of characters
 * in each word within a sentence while still preserving whitespace and initial word order.
 Example 1:
 Input: "Let's take LeetCode contest"
 Output: "s'teL ekat edoCteeL tsetnoc"
 Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 */
public class P_557_ReverseWords {

	public String reverseWords(String s) {
		return my(s);
	}

	/**
	 * 完成时间，6min19sec
	 * */
	public String my(String s) {
		String[] split = s.split(" ");
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < split.length; i++) {
			sb.append(reverseWord(split[i]));
			if (i != split.length - 1) {
				sb.append(" ");
			}
		}
		return sb.toString();
	}

	private String reverseWord(String s) {
		if (s == null || s.length() == 0 || s.length() == 1) {
			return s;
		}
		StringBuilder sb = new StringBuilder();
		char[] chars = s.toCharArray();
		for (int i = chars.length - 1; i >= 0; i--) {
			sb.append(chars[i]);
		}
		return sb.toString();
	}

}
