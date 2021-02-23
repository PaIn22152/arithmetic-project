package com.payne.leetCode.daily;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode.daily
 * Date       2020/10/30 - 18:23
 * Author     Payne.
 * About      类描述：
 */

class D_463 {

    /*
    * 463. 岛屿的周长
给定一个包含 0 和 1 的二维网格地图，其中 1 表示陆地 0 表示水域。
网格中的格子水平和垂直方向相连（对角线方向不相连）。
整个网格被水完全包围，但其中恰好有一个岛屿（或者说，一个或多个表示陆地的格子相连组成的岛屿）。
岛屿中没有“湖”（“湖” 指水域在岛屿内部且不和岛屿周围的水相连）。
格子是边长为 1 的正方形。网格为长方形，且宽度和高度均不超过 100 。计算这个岛屿的周长。

示例 :
输入:
[[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]
输出: 16
解释: 它的周长是下面图片中的 16 个黄色的边：
    * */
    public int islandPerimeter(int[][] grid) {
        int num = 0;
        int row = 0;
        int column = 0;
        for (int i = 0; i < grid.length; i++) {
            int last = 0;
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    num++;
                    if (last == 1) {
                        row++;
                    }
                }
                last = grid[i][j];
            }
        }

        for (int j = 0; j < grid[0].length; j++) {
            int last = 0;
            for (int i = 0; i < grid.length; i++) {
                if (grid[i][j] == 1) {
                    if (last == 1) {
                        row++;
                    }
                }
                last = grid[i][j];
            }
        }
        return num * 4 - (row + column) * 2;
    }
}
