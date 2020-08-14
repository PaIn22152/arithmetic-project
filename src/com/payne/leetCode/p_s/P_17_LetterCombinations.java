package com.payne.leetCode.p_s;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by payne on 2017-12-28.
 * About 类描述：
 * Given a digit string, return all possible letter combinations that the number could represent.
 A mapping of digit to letters (just like on the telephone buttons) is given below.
 */
public class P_17_LetterCombinations {
	public List<String> letterCombinations(String digits) {
		return my(digits);
		//return f1(digits);
		//return f2(digits);
	}

	public List<String> my(String digits) {
		List<String> result = new ArrayList<>();
		List<String> list = new ArrayList<>();
		for (char c : digits.toCharArray()) {
			list.add(getLettersByNumber(c));
		}
		for (String s : list) {
			result = add2List(result, s);
		}
		return result;
	}


	public List<String> add2List(List<String> list, String s) {
		List<String> result = new ArrayList<>();
		if (list == null || list.size() == 0) {
			for (char c : s.toCharArray()) {
				StringBuffer sb = new StringBuffer();
				sb.append(c);
				result.add(sb.toString());
			}
		}
		else {
			for (String temp : list) {
				for (char c : s.toCharArray()) {
					StringBuffer sb = new StringBuffer();
					sb.append(temp);
					sb.append(c);
					result.add(sb.toString());
				}
			}
		}
		return result;
	}

	public String getLettersByNumber(char n) {
		switch (n) {
			case '2':
				return "abc";
			case '3':
				return "def";
			case '4':
				return "ghi";
			case '5':
				return "jkl";
			case '6':
				return "mno";
			case '7':
				return "pqrs";
			case '8':
				return "tuv";
			case '9':
				return "wxyz";
			case '1':
			default:
				return "";
		}
	}


	String[][] refer = {{}, {}, {"a", "c", "b"}, {"d", "e", "f"}, {"g", "h", "i"}, {"j", "k", "l"}, {"m", "n", "o"}, {"p_old", "q", "r", "s"}, {"t", "u", "v"}, {"w", "x", "y", "z"}};

	public List<String> f1(String digits) {
		List<String> list = new ArrayList<String>();
		if (!digits.equals("")) {helper(list, digits, ""); return list;}
		return list;
	}

	private void helper(List<String> list, String digits, String s) {
		if (digits.length() == 0) { list.add(s); return;}
		int idx = Integer.parseInt(digits.substring(0, 1));
		for (String k : refer[idx]) {
			helper(list, digits.substring(1, digits.length()), s + k);
		}
		return;
	}


	public List<String> f2(String digits) {
		LinkedList<String> ans = new LinkedList<String>();
		String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		ans.add("");
		for (int i = 0; i < digits.length(); i++) {
			int x = Character.getNumericValue(digits.charAt(i));
			while (ans.peek().length() == i) {
				String t = ans.remove();
				for (char s : mapping[x].toCharArray())
					ans.add(t + s);
			}
		}
		return ans;
	}

}
