package com.payne;

import java.util.List;

import com.payne.leetCode.P_12_Integer2Roman;
import com.payne.leetCode.P_13_Roman2Integer;
import com.payne.leetCode.P_500_KeyboardRow;
import com.payne.leetCode.P_557_ReverseWords;
import com.payne.leetCode.P_5_LongestPalindromicSubstring;
import com.payne.leetCode.P_728_SelfDividingNumbers;

public class Main {

	public static void main(String[] args) {
		/*P_12_Integer2Roman p12 = new P_12_Integer2Roman();
		String s = p12.intToRoman(1900);
		System.out.println(" s = " + s);

		P_13_Roman2Integer p13 = new P_13_Roman2Integer();
		int i = p13.romanToInt(s);
		System.out.println(" i = " + i);*/

		/*Long t1 = System.currentTimeMillis();
		P_5_LongestPalindromicSubstring p5 = new P_5_LongestPalindromicSubstring();
		//String input = "aaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaa";
		String input = "abba";
		String s = p5.longestPalindrome(input + input + input + input);
		Long t2 = System.currentTimeMillis();
		System.out.println("input length = " + input.length() + "; s = " + s + ";  time = " + (t2 - t1));*/

		/*P_728_SelfDividingNumbers p728=new P_728_SelfDividingNumbers();
		List<Integer> list = p728.selfDividingNumbers(1, 22);
		System.out.print("");*/

		/*P_557_ReverseWords p557 = new P_557_ReverseWords();
		String s = p557.reverseWords("Let's take LeetCode contest");
		System.out.println(" s = " + s);*/

		String[] strings = {"abdfs","cccd","a","qwwewm"};
		P_500_KeyboardRow p500 = new P_500_KeyboardRow();
		String[] words = p500.findWords(strings);
		System.out.println("words = " + words.toString());

	}
}
