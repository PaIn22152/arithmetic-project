package com.payne;

import com.payne.leetCode.P_12_Integer2Roman;
import com.payne.leetCode.P_13_Roman2Integer;

public class Main {

	public static void main(String[] args) {
		// write your code here
		/*P_13_Roman2Integer p = new P_13_Roman2Integer();
		int v = p.romanToInt("V");
		System.out.println(" v = " + v);*/

		P_12_Integer2Roman p12 = new P_12_Integer2Roman();
		String s = p12.intToRoman(1900);
		System.out.println(" s = " + s);

		P_13_Roman2Integer p13 = new P_13_Roman2Integer();
		int i = p13.romanToInt(s);
		System.out.println(" i = " + i);
	}
}
