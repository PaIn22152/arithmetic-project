package com.payne.leetCode;

import java.util.regex.Pattern;

/**
 * Created by payne on 2017-12-20.
 * About 类描述：
 * Implement atoi to convert a string to an integer.
 * Hint: Carefully consider all possible input cases. If you want a challenge, please do not
 * see below and ask yourself what are the possible input cases.
 * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs).
 * You are responsible to gather all the input requirements up front.
 * Update (2015-02-10):
 * The signature of the C++ function had been updated. If you still see your
 * function signature accepts a const char * argument, please click the reload button
 * to reset your code definition.
 */
public class P_8_StringToInteger {

  public static int myAtoi(String str) {
    try {
      str = str.trim();
      char[] chars = str.toCharArray();
      String result = "";
      boolean haveNum = false;
      boolean haveOp = false;
      for (char c : chars) {
        if (isNumber(c)) {
          result += c;
          haveNum = true;
        } else {
          if (haveNum) {
            return Integer.parseInt(result);
          }
        }
        if (!haveOp) {
          if (isOperator(c)) {
            result += c;
            haveOp = true;
          }
        }

      }
      System.out.println(" result = " + result);
      return Integer.parseInt(result);
    } catch (Exception e) {
      return 0;
    }
  }


  public static boolean isMatch(final String regex, final CharSequence input) {
    return input != null && input.length() > 0 && Pattern.matches(regex, input);
  }

  public static boolean isOperator(char c) {
    String regex = "\\+|\\-|\\*|\\/";
    char[] cs = new char[1];
    cs[0] = c;
    return isMatch(regex, new String(cs));

  }

  public static boolean isNumber(char c) {
    String regex = "[0-9]";
    char[] cs = new char[1];
    cs[0] = c;
    return isMatch(regex, new String(cs));
  }

}
