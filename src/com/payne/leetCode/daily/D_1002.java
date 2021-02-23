package com.payne.leetCode.daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.daily
 * Date       2020/10/14 - 09:55
 * Author     Payne.
 * About      类描述：
 */

class D_1002 {

    /*https://leetcode-cn.com/problems/find-common-characters/
    * 1002. 查找常用字符
给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。
例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
你可以按任意顺序返回答案。

示例 1：
输入：["bella","label","roller"]
输出：["e","l","l"]

示例 2：
输入：["cool","lock","cook"]
输出：["c","o"]

提示：
1 <= A.length <= 100
1 <= A[i].length <= 100
A[i][j] 是小写字母
    * */

    /*
    执行用时：37 ms, 在所有 Java 提交中击败了5.42%的用户
    内存消耗：39.1 MB, 在所有 Java 提交中击败了49.20%的用户
    * */
    public List<String> commonChars(String[] A) {
        int min = Integer.MAX_VALUE;
        int p = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i].length() < min) {
                p = i;
                min = A[i].length();
            }
        }
        String s = A[p];
        List<String> ans = new ArrayList<>();
        boolean b1;
        boolean b2;
        for (char c : s.toCharArray()) {
            b1 = true;
            for (int i = 0; i < A.length; i++) {
                String t = A[i];
                if (!t.contains(c + "")) {
                    b1 = false;
                    break;
                }
                StringBuilder sb = new StringBuilder();
                b2 = false;
                for (char tc : t.toCharArray()) {
                    if (tc != c || b2) {
                        sb.append(tc);
                    } else {
                        b2 = true;
                    }
                }
                A[i] = sb.toString();
            }
            if (b1) {
                ans.add(c + "");
            }
        }
        return ans;
    }

  //官方代码
    /*
    执行用时：3 ms, 在所有 Java 提交中击败了98.36%的用户
    内存消耗：38.4 MB, 在所有 Java 提交中击败了99.73%的用户
    * */
  public List<String> commonChars2(String[] A) {
      int[] minfreq = new int[26];
      Arrays.fill(minfreq, Integer.MAX_VALUE);
      for (String word: A) {
          int[] freq = new int[26];
          int length = word.length();
          for (int i = 0; i < length; ++i) {
              char ch = word.charAt(i);
              ++freq[ch - 'a'];
          }
          for (int i = 0; i < 26; ++i) {
              minfreq[i] = Math.min(minfreq[i], freq[i]);
          }
      }

      List<String> ans = new ArrayList<String>();
      for (int i = 0; i < 26; ++i) {
          for (int j = 0; j < minfreq[i]; ++j) {
              ans.add(String.valueOf((char) (i + 'a')));
          }
      }
      return ans;
  }

}
