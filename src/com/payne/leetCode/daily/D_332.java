package com.payne.leetCode.daily;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.daily
 * Date       2020/08/27 - 09:37
 * Author     Payne.
 * About      类描述：
 */

public class D_332 {

    /**
     * 给定一个机票的字符串二维数组 [from, to]，
     * 子数组中的两个成员分别表示飞机出发和降落的机场地点，
     * 对该行程进行重新规划排序。
     * 所有这些机票都属于一个从 JFK（肯尼迪国际机场）出发的先生，
     * 所以该行程必须从 JFK 开始。
     * <p>
     * 说明:
     * 如果存在多种有效的行程，你可以按字符自然排序返回最小的行程组合。
     * 例如，行程 ["JFK", "LGA"] 与 ["JFK", "LGB"] 相比就更小，排序更靠前
     * 所有的机场都用三个大写字母表示（机场代码）。
     * 假定所有机票至少存在一种合理的行程。
     * <p>
     * 示例 1:
     * 输入: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
     * 输出: ["JFK", "MUC", "LHR", "SFO", "SJC"]
     * <p>
     * 示例 2:
     * 输入: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
     * 输出: ["JFK","ATL","JFK","SFO","ATL","SFO"]
     * 解释: 另一种有效的行程是 ["JFK","SFO","ATL","JFK","ATL","SFO"]。但是它自然排序更大更靠后。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reconstruct-itinerary
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    //[["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
    public List<String> findItinerary(List<List<String>> tickets) {

        if (tickets.size() < 1) {
            return new ArrayList<>();
        }
        String start = "JFK";
        List<String> result = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        ans.add(start);
        Set<String> history = new HashSet<>();
        dfs(tickets, ans, result, history, tickets.size() + 1);
        return result;
    }

    private void dfs(List<List<String>> tickets, List<String> ans,
                     List<String> result, Set<String> history, int len) {
        if (tickets.size() == 0 && ans.size() == len) {
            if (result.size() == 0) {
                result.addAll(ans);
            } else {
                boolean replace = false;
                for (int i = 0; i < ans.size(); i++) {
                    int com = result.get(i).compareTo(ans.get(i));
                    if (com > 0) {
                        replace = true;
                        break;
                    } else if (com < 0) {
                        break;
                    }
                }
                if (replace) {
                    result.clear();
                    result.addAll(ans);
                }
            }
            return;
        }

        StringBuilder ansStr = new StringBuilder();
        for (String s : ans) {
            ansStr.append(s);
        }
        if (history.contains(ansStr.toString())) {
            return;
        }
        history.add(ansStr.toString());

        String lastTo = ans.get(ans.size() - 1);
        for (int j = 0; j < tickets.size(); j++) {
            List<String> route = tickets.get(j);
            String from = route.get(0);
            String to = route.get(1);
            if (lastTo.equals(from)) {
                List<String> newAns = new ArrayList<>(ans);
                newAns.add(to);

                List<List<String>> newTic = new ArrayList<>(tickets);
                newTic.remove(j);

                dfs(newTic, newAns, result, history, len);
            }
        }
    }


}
