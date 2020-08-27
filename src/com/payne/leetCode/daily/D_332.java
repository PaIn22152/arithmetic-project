package com.payne.leetCode.daily;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
        List<List<String>> result = new ArrayList<>();
        List<List<String>> ans = new ArrayList<>();
        List<String> list = new ArrayList<>();
        list.add(start);
        ans.add(list);
        bfs(tickets, ans,result);
        return result.get(0);
    }

    private void bfs(List<List<String>> tickets, List<List<String>> ans, List<List<String>> result) {

        List<List<String>> newAns = new ArrayList<>();
        List<List<String>> newTic = new ArrayList<>();
        for (int i = 0; i < ans.size(); i++) {
            List<String> list = ans.get(i);
            String lastTo = list.get(list.size() - 1);
            for (List<String> route : tickets) {
                String from = route.get(0);
                String to = route.get(1);
                if(lastTo.equals(from)){
                    List<String> tem=new ArrayList<>(list);
                    tem.add(to);
                    newAns.add(tem);
                }
            }
        }
    }


}
