package com.payne.leetCode.daily;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.daily
 * Date       2020/08/20 - 09:45
 * Author     Payne.
 * About      类描述：
 */

public class D_529 {

    /**
     * https://leetcode-cn.com/problems/minesweeper/
     * <p>
     * 给定一个代表游戏板的二维字符矩阵。 
     * 'M' 代表一个未挖出的地雷，
     * 'E' 代表一个未挖出的空方块，
     * 'B' 代表没有相邻（上，下，左，右，和所有4个对角线）地雷的已挖出的空白方块，
     * 数字（'1' 到 '8'）表示有多少地雷与这块已挖出的方块相邻，
     * 'X' 则表示一个已挖出的地雷。
     * <p>
     * 现在给出在所有未挖出的方块中（'M'或者'E'）的下一个点击位置（行和列索引），
     * 根据以下规则，返回相应位置被点击后对应的面板：
     * <p>
     * 如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X'。
     * 如果一个没有相邻地雷的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的未挖出方块都应该被递归地揭露。
     * 如果一个至少与一个地雷相邻的空方块（'E'）被挖出，修改它为数字（'1'到'8'），表示相邻地雷的数量。
     * 如果在此次点击中，若无更多方块可被揭露，则返回面板。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minesweeper
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    char unknownMineC = 'M';//未挖出的地雷
    char mineC = 'X';//挖出的地雷
    char unknownC = 'E';//未挖出的空方块
    char emptyC = 'B';//挖出的空白方块
    char[] numbersC = {'1', '2', '3', '4', '5', '6', '7', '8'};


    int[] dirX0 = {0, 1, 0, -1, 1, 1, -1, -1};
    int[] dirY0 = {1, 0, -1, 0, 1, -1, 1, -1};

    /*
  执行用时：26 ms, 在所有 Java 提交中击败了5.94%的用户
  内存消耗：40.1 MB, 在所有 Java 提交中击败了44.39%的用户
  * */
    public char[][] updateBoard1(char[][] board, int[] click) {
        int x = click[0];
        int y = click[1];

        //地雷被挖出
        if (board[x][y] == unknownMineC) {
            board[x][y] = mineC;
            return board;
        }

        //获取点击的位置，有相连地雷的数量
        List<int[]> list = getLinkedPosition(board, click);
        int num = getMineNum(board, list);

        //有1个以上地雷与点击位置相连，该位置值改为地雷数，返回
        if (num > 0) {
            board[x][y] = numbersC[num - 1];
            return board;
        }

        //没有地雷与点击位置相连，该位置值改为挖出的空白方块，并处理所有与该点相连的点
        board[x][y] = emptyC;
        handle(board, list);
        return board;

    }

    //输入n个位置，返回这些位置中有雷的个数
    private int getMineNum(char[][] board, List<int[]> list) {
        int num = 0;
        for (int[] p : list) {
            char c = board[p[0]][p[1]];
            if (unknownMineC == c || mineC == c) {
                num++;
            }
        }
        return num;
    }

    //输入与空白方块相连的点，判断这些点的其他相连点，是否与雷相连，
    // 如果相连，点的值修改为雷个数，如果不相连，点的值修改为空白方块，且递归处理与这个点相连的其他点
    private void handle(char[][] board, List<int[]> positions) {
        List<int[]> emptyList = new ArrayList<>();
        for (int[] p : positions) {

            //使用char的值来判断是否处理过，为’E‘时才是没有处理过的
            if (board[p[0]][p[1]] == unknownC) {

                List<int[]> list = getLinkedPosition(board, p);
                int num = getMineNum(board, list);
                if (num > 0) {
                    //有n个地雷相连，修改值为n
                    board[p[0]][p[1]] = numbersC[num - 1];
                } else {
                    //没有地雷与输入位置相连，所有相连点需要再次判断
                    board[p[0]][p[1]] = emptyC;
                    emptyList.addAll(list);
                }
            }
        }
        if (emptyList.size() > 0) {
            handle(board, emptyList);
        }
    }

    //输入位置，返回与此位置相连的所有位置（3-8个）
    private List<int[]> getLinkedPosition(char[][] board, int[] p) {
        int x = p[0];
        int y = p[1];
        int maxX = board.length;
        int maxY = board[0].length;
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < 8; ++i) {
            int tx = x + dirX0[i];
            int ty = y + dirY0[i];
            if (tx < 0 || tx >= maxX || ty < 0 || ty >= maxY) {
                continue;
            }
            list.add(new int[]{tx, ty});
        }
        return list;
    }


    //官方代码1，深度优先
    /*
    执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
    内存消耗：40 MB, 在所有 Java 提交中击败了67.81%的用户
    * */
    int[] dirX = {0, 1, 0, -1, 1, 1, -1, -1};
    int[] dirY = {1, 0, -1, 0, 1, -1, 1, -1};

    public char[][] updateBoard(char[][] board, int[] click) {
        int x = click[0], y = click[1];
        if (board[x][y] == 'M') {
            // 规则 1
            board[x][y] = 'X';
        } else {
            dfs(board, x, y);
        }
        return board;
    }

    public void dfs(char[][] board, int x, int y) {

        //找到与输入点相连的8个点（可能小于8）
        int cnt = 0;
        for (int i = 0; i < 8; ++i) {
            int tx = x + dirX[i];
            int ty = y + dirY[i];
            if (tx < 0 || tx >= board.length || ty < 0 || ty >= board[0].length) {
                continue;
            }
            // 不用判断 X，因为如果有 X 的话游戏已经结束了
            if (board[tx][ty] == 'M') {
                ++cnt;
            }
        }
        //判断这8个点中雷的数量，如果有雷，执行规则3，结束
        if (cnt > 0) {
            // 规则 3
            board[x][y] = (char) (cnt + '0');
        } else {

            //如果没有雷，递归处理每一个点
            // 规则 2
            board[x][y] = 'B';
            for (int i = 0; i < 8; ++i) {
                int tx = x + dirX[i];
                int ty = y + dirY[i];
                // 这里不需要在存在 B 的时候继续扩展，因为 B 之前被点击的时候已经被扩展过了
                if (tx < 0 || tx >= board.length || ty < 0 || ty >= board[0].length || board[tx][ty] != 'E') {
                    continue;
                }
                dfs(board, tx, ty);
            }
        }
    }


    //官方代码2，广度优先
    int[] dirX2 = {0, 1, 0, -1, 1, 1, -1, -1};
    int[] dirY2 = {1, 0, -1, 0, 1, -1, 1, -1};

    public char[][] updateBoard2(char[][] board, int[] click) {
        int x = click[0], y = click[1];
        if (board[x][y] == 'M') {
            // 规则 1
            board[x][y] = 'X';
        } else {
            bfs(board, x, y);
        }
        return board;
    }

    public void bfs(char[][] board, int sx, int sy) {
        Queue<int[]> queue = new LinkedList<int[]>();
        boolean[][] vis = new boolean[board.length][board[0].length];
        queue.offer(new int[]{sx, sy});
        vis[sx][sy] = true;
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int cnt = 0, x = pos[0], y = pos[1];
            for (int i = 0; i < 8; ++i) {
                int tx = x + dirX2[i];
                int ty = y + dirY2[i];
                if (tx < 0 || tx >= board.length || ty < 0 || ty >= board[0].length) {
                    continue;
                }
                // 不用判断 M，因为如果有 M 的话游戏已经结束了
                if (board[tx][ty] == 'M') {
                    ++cnt;
                }
            }
            if (cnt > 0) {
                // 规则 3
                board[x][y] = (char) (cnt + '0');
            } else {
                // 规则 2
                board[x][y] = 'B';
                for (int i = 0; i < 8; ++i) {
                    int tx = x + dirX2[i];
                    int ty = y + dirY2[i];
                    // 这里不需要在存在 B 的时候继续扩展，因为 B 之前被点击的时候已经被扩展过了
                    if (tx < 0 || tx >= board.length || ty < 0 || ty >= board[0].length || board[tx][ty] != 'E' || vis[tx][ty]) {
                        continue;
                    }
                    queue.offer(new int[]{tx, ty});
                    vis[tx][ty] = true;
                }
            }
        }
    }
}
