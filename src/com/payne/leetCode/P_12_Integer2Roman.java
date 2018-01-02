package com.payne.leetCode;

/**
 * Created by payne on 2018-01-02.
 * About 类描述：
 * Given an integer, convert it to a roman numeral.
 Input is guaranteed to be within the range from 1 to 3999.
 Ⅰ（1）、Ⅴ（5）、Ⅹ（10）、Ⅼ（50）、Ⅽ（100）、Ⅾ（500）和Ⅿ（1000）
 */
public class P_12_Integer2Roman {


	public String intToRoman(int num) {
		//return my(num);
		return f1(num);
	}

	private int[] nums =
			{1000, 900, 500, 400, 100,
					90, 50, 40, 10, 9,
					5, 4, 1};

	private String[] strings =
			{"M", "CM", "D", "CD", "C",
					"XC", "L", "XL", "X", "IX",
					"V", "IV", "I"};

	public String my(int num) {
		for (int i = 0; i < nums.length; i++) {
			if (num >= nums[i]) {
				return strings[i] + my(num - nums[i]);
			}
		}
		return "";
	}

	public String f1(int num) {

		int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		String[] strs = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < values.length; i++) {
			while (num >= values[i]) {
				num -= values[i];
				sb.append(strs[i]);
			}
		}
		return sb.toString();
	}

}
