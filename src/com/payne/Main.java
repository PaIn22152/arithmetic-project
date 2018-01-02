package com.payne;

import com.payne.leetCode.P_12_Integer2Roman;
import com.payne.leetCode.P_13_Roman2Integer;
import com.payne.leetCode.P_5_LongestPalindromicSubstring;

public class Main {

	public static void main(String[] args) {
		/*P_12_Integer2Roman p12 = new P_12_Integer2Roman();
		String s = p12.intToRoman(1900);
		System.out.println(" s = " + s);

		P_13_Roman2Integer p13 = new P_13_Roman2Integer();
		int i = p13.romanToInt(s);
		System.out.println(" i = " + i);*/

		Long t1 = System.currentTimeMillis();
		P_5_LongestPalindromicSubstring p5 = new P_5_LongestPalindromicSubstring();
		String input = "cyyoacmjwjubfkzrrbvquqkwhsxvmytmjvbborrtoiyotobzjmohpadfrvmxuagbdczsjuekjrmcwyaovpiogspbslcppxojgbfxhtsxmecgqjfuvahzpgprscjwwutwoiksegfreortttdotgxbfkisyakejihfjnrdngkwjxeituomuhmeiesctywhryqtjimwjadhhymydlsmcpycfdzrjhstxddvoqprrjufvihjcsoseltpyuaywgiocfodtylluuikkqkbrdxgjhrqiselmwnpdzdmpsvbfimnoulayqgdiavdgeiilayrafxlgxxtoqskmtixhbyjikfmsmxwribfzeffccczwdwukubopsoxliagenzwkbiveiajfirzvngverrbcwqmryvckvhpiioccmaqoxgmbwenyeyhzhliusupmrgmrcvwmdnniipvztmtklihobbekkgeopgwipihadswbqhzyxqsdgekazdtnamwzbitwfwezhhqznipalmomanbyezapgpxtjhudlcsfqondoiojkqadacnhcgwkhaxmttfebqelkjfigglxjfqegxpcawhpihrxydprdgavxjygfhgpcylpvsfcizkfbqzdnmxdgsjcekvrhesykldgptbeasktkasyuevtxrcrxmiylrlclocldmiwhuizhuaiophykxskufgjbmcmzpogpmyerzovzhqusxzrjcwgsdpcienkizutedcwrmowwolekockvyukyvmeidhjvbkoortjbemevrsquwnjoaikhbkycvvcscyamffbjyvkqkyeavtlkxyrrnsmqohyyqxzgtjdavgwpsgpjhqzttukynonbnnkuqfxgaatpilrrxhcqhfyyextrvqzktcrtrsbimuokxqtsbfkrgoiznhiysfhzspkpvrhtewthpbafmzgchqpgfsuiddjkhnwchpleibavgmuivfiorpteflholmnxdwewj";
		//String input = "aaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaa";
		//String input = "abba";
		String s = p5.longestPalindrome(input + input + input + input);
		Long t2 = System.currentTimeMillis();
		System.out.println("input length = " + input.length() + "; s = " + s + ";  time = " + (t2 - t1));
	}
}
