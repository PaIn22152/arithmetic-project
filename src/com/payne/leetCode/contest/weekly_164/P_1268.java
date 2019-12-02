package com.payne.leetCode.contest.weekly_164;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.contest.weekly_164
 * Date       2019/11/26 - 15:39
 * Author     Payne.
 * About      类描述：
 */

public class P_1268 {
    /**
     * https://leetcode.com/contest/weekly-contest-164/problems/search-suggestions-system/
     */

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<String> strings = Arrays.asList(products);
        Collections.sort(strings);
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < searchWord.length(); i++) {
            String sub = searchWord.substring(0, i + 1);
            List<String> tem = suggestedProduct(strings, sub);
            res.add(tem);
        }
        return res;
    }

    private List<String> suggestedProduct(List<String> products, String searchWord) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).startsWith(searchWord)) {
                res.add(products.get(i));
                if (res.size() >= 3) {
                    return res;
                }
            }
        }
        return res;
    }
}
