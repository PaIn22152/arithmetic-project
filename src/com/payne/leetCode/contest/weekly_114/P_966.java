package com.payne.leetCode.contest.weekly_114;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.contest.weekly_114
 * Date       2019/01/03 - 15:12
 * Author     Payne.
 * About      类描述：
 */

public class P_966 {

    /**
     * https://leetcode.com/contest/weekly-contest-117/problems/vowel-spellchecker/
     */

    Pattern pat = Pattern.compile("[aeiou]");

    public String[] spellchecker(String[] wordlist, String[] queries) {
        int n = wordlist.length;
        Map<String, String> original = new HashMap(n);
        Map<String, String> lowercase = new HashMap(n);
        Map<String, String> replaced = new HashMap(n);

        for (int i = n - 1; i >= 0; i--) {
            original.put(wordlist[i], wordlist[i]);
            String low = wordlist[i].toLowerCase();
            lowercase.put(low, wordlist[i]);
            String replace = pat.matcher(low).replaceAll("_");
            replaced.put(replace, wordlist[i]);
        }

        int m = queries.length;
        String[] ans = new String[m];

        for (int i = 0; i < m; i++) {
            String q = queries[i];
            String a = null;
            if (a == null) {
                a = original.get(q);
            }
            if (a == null) {
                q = q.toLowerCase();
                a = lowercase.get(q);
            }
            if (a == null) {
                q = pat.matcher(q).replaceAll("_");
                a = replaced.get(q);
            }
            if (a == null) {
                a = "";
            }
            ans[i] = a;
        }

        return ans;
    }
}
