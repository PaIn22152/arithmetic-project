package com.payne.leetCode.p;

import java.util.ArrayList;
import java.util.List;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode
 * Date       2018/08/21 - 17:46
 * Author     Payne.
 * About      类描述：
 */

public class P_130_SurroundedRegions {

    /**
     * https://leetcode.com/problems/surrounded-regions/description/
     * <p>
     * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
     * <p>
     * A region is captured by flipping all 'O's into 'X's in that surrounded region.
     * <p>
     * Example:
     * <p>
     * X X X X
     * X O O X
     * X X O X
     * X O X X
     * After running your function, the board should be:
     * <p>
     * X X X X
     * X X X X
     * X X X X
     * X O X X
     * Explanation:
     * <p>
     * Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of
     * the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected
     * to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent
     * cells connected horizontally or vertically.
     */

    public void solve(char[][] board) {
        my(board);
    }


//    String[][] board = {
//            {"O", "X", "O", "O", "X", "X"},
//            {"O", "X", "X", "X", "O", "X"},
//            {"X", "O", "O", "X", "O", "O"},
//            {"X", "O", "X", "X", "X", "X"},
//            {"O", "O", "X", "O", "X", "X"},
//            {"X", "X", "O", "O", "O", "O"}
//    };

    String[][] out = {
            {"O", "X", "X", "O", "X"},
            {"X", "X", "X", "X", "O"},
            {"X", "X", "X", "X", "X"},
            {"O", "X", "O", "O", "O"},
            {"X", "X", "O", "X", "O"}
    };

    String[][] expected = {
            {"O", "X", "X", "O", "X"},
            {"X", "X", "X", "X", "O"},
            {"X", "X", "X", "O", "X"},
            {"O", "X", "O", "O", "O"},
            {"X", "X", "O", "X", "O"}
    };


    private boolean isAllSurrounded(char[][] board, List<Point> chunk) {
        for (Point point : chunk) {
            if (isMargin(board, point)) {
                return false;
            }
        }
        return true;
    }

    private boolean isMargin(char[][] board, Point point) {
        int horizontalMax;
        int verticalMax;
        horizontalMax = board.length - 1;
        verticalMax = board[horizontalMax].length - 1;
        if (point.horizontal == 0 || point.vertical == 0) {
            return true;
        }
        if (point.horizontal == horizontalMax || point.vertical == verticalMax) {
            return true;
        }
        return false;
    }

    private boolean isBorder(Point p1, Point p2) {
        if (p1.vertical == p2.vertical) {
            if (p1.horizontal - p2.horizontal == 1 || p1.horizontal - p2.horizontal == -1) {
                return true;
            }
        }
        if (p1.horizontal == p2.horizontal) {
            if (p1.vertical - p2.vertical == 1 || p1.vertical - p2.vertical == -1) {
                return true;
            }
        }
        return false;
    }

    private boolean isBorderChunk(List<Point> chunk, Point p2) {
        for (Point point : chunk) {
            if (isBorder(point, p2)) {
                return true;
            }
        }
        return false;
    }


    private List<Point> allPointList = new ArrayList<>();
    private List<Point> surroundedPointList = new ArrayList<>();
    private List<List<Point>> pointChunkList = new ArrayList<>();

    public void my(char[][] board) {

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char c = board[i][j];
                if (c == 'O') {
                    allPointList.add(new Point(i, j));
                }
            }
        }

        String[][] f = {
                {"O", "X", "O", "O", "X", "X"},
                {"O", "X", "X", "X", "O", "X"},
                {"X", "O.", "O.", "X", "O", "O"},
                {"X", "O.", "X", "X", "X", "X"},
                {"O", "O.", "X", "O", "X", "X"},
                {"X", "X", "O", "O", "O", "O"}
        };

        List<Point> chunk;
        boolean border = false;
        for (Point point : allPointList) {
            if (pointChunkList.size() == 0) {
                chunk = new ArrayList<>();
                chunk.add(point);
                pointChunkList.add(chunk);
            } else {
                border = false;
                for (List<Point> temp : pointChunkList) {
                    if (isBorderChunk(temp, point)) {
                        border = true;
                        temp.add(point);
                    }
                }
                if (!border) {
                    chunk = new ArrayList<>();
                    chunk.add(point);
                    pointChunkList.add(chunk);
                }
            }
        }

        System.out.println(pointChunkList.size());
        for (List<Point> temp : pointChunkList) {
            if (isAllSurrounded(board, temp)) {
                surroundedPointList.addAll(temp);
            }
        }

        System.out.println(surroundedPointList.size());
        for (Point point : surroundedPointList) {
            board[point.horizontal][point.vertical] = 'X';
        }

    }


    public static class Point {
        int horizontal;
        int vertical;

        Point(int horizontal, int vertical) {
            this.horizontal = horizontal;
            this.vertical = vertical;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Point)) {
                return false;
            }
            return this.horizontal == ((Point) obj).horizontal &&
                    this.vertical == ((Point) obj).vertical;

        }
    }


    private boolean allIsSurrounded(char[][] board, int i, int j) {
        return upIsSurrounded(board, i, j) && downIsSurrounded(board, i, j)
                && leftIsSurrounded(board, i, j) && rightIsSurrounded(board, i, j);
    }

    private boolean allIsSurroundedExceptUp(char[][] board, int i, int j) {
        return downIsSurrounded(board, i, j)
                && leftIsSurrounded(board, i, j) && rightIsSurrounded(board, i, j);
    }

    private boolean allIsSurroundedExceptDown(char[][] board, int i, int j) {
        return upIsSurrounded(board, i, j)
                && leftIsSurrounded(board, i, j) && rightIsSurrounded(board, i, j);
    }

    private boolean allIsSurroundedExceptLeft(char[][] board, int i, int j) {
        return upIsSurrounded(board, i, j) && downIsSurrounded(board, i, j)
                && rightIsSurrounded(board, i, j);
    }

    private boolean allIsSurroundedExceptRight(char[][] board, int i, int j) {
        return upIsSurrounded(board, i, j) && downIsSurrounded(board, i, j)
                && leftIsSurrounded(board, i, j);
    }

    private boolean upIsSurrounded(char[][] board, int horizontal, int vertical) {
        if (horizontal - 1 < 0) {
            return false;
        }
        if (board[horizontal - 1][vertical] == 'O') {
            return allIsSurroundedExceptDown(board, horizontal - 1, vertical);
        }
        if (board[horizontal - 1][vertical] == 'X') {
            return true;
        }
        return false;
    }

    private boolean leftIsSurrounded(char[][] board, int horizontal, int vertical) {
        if (vertical - 1 < 0) {
            return false;
        } else if (board[horizontal][vertical - 1] == 'O') {
            return allIsSurroundedExceptRight(board, horizontal, vertical - 1);
        } else if (board[horizontal][vertical - 1] == 'X') {
            return true;
        }
        return false;
    }

    private boolean downIsSurrounded(char[][] board, int horizontal, int vertical) {
        if (horizontal + 1 >= board.length) {
            return false;
        } else if (board[horizontal + 1][vertical] == 'O') {
            return allIsSurroundedExceptUp(board, horizontal + 1, vertical);
        } else if (board[horizontal + 1][vertical] == 'X') {
            return true;
        }
        return false;
    }

    private boolean rightIsSurrounded(char[][] board, int horizontal, int vertical) {
        if (vertical + 1 >= board[horizontal].length) {
            return false;
        } else if (board[horizontal][vertical + 1] == 'O') {
            return allIsSurroundedExceptLeft(board, horizontal, vertical + 1);
        } else if (board[horizontal][vertical + 1] == 'X') {
            return true;
        }
        return false;
    }

}
