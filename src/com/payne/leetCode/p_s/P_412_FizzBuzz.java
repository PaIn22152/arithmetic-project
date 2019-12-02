package com.payne.leetCode.p_s;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by payne on 2018-01-10.
 * About 类描述：
 * Write a program that outputs the string representation of numbers from 1 to n.

 But for multiples of three it should output “Fizz” instead of the number
 and for the multiples of five output “Buzz”.
 For numbers which are multiples of both three and five output “FizzBuzz”.
 */
public class P_412_FizzBuzz {
	public List<String> fizzBuzz(int n) {
		return my(n);
	}

	public List<String> my(int n) {
		List<String> result = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			String s = "" + i;
			if (i % 3 == 0 && i % 5 == 0) {
				s = "FizzBuzz";
			}
			else if (i % 3 == 0) {
				s = "Fizz";
			}
			else if (i % 5 == 0) {
				s = "Buzz";
			}
			result.add(s);
		}
		return result;
	}
}
