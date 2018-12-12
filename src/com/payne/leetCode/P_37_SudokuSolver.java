package com.payne.leetCode;

/**
 * Project    arithmetic-project-git
 * Path       com.payne.leetCode
 * Date       2018/10/08 - 10:57
 * Author     Payne.
 * About      类描述：
 */

public class P_37_SudokuSolver {
    /**
     * https://leetcode.com/problems/sudoku-solver/description/
     * <p>
     * Write a program to solve a Sudoku puzzle by filling the empty cells.
     * <p>
     * A sudoku solution must satisfy all of the following rules:
     * <p>
     * Each of the digits 1-9 must occur exactly once in each row.
     * Each of the digits 1-9 must occur exactly once in each column.
     * Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
     * Empty cells are indicated by the character '.'.
     * <p>
     * Note:
     * <p>
     * The given board contain only digits 1-9 and the character '.'.
     * You may assume that the given Sudoku puzzle will have a single unique solution.
     * The given board size is always 9x9.
     */

    String[][] strings =
            {{"5", "3", ".", ".", "7", ".", ".", ".", "."},
                    {"6", ".", ".", "1", "9", "5", ".", ".", "."},
                    {".", "9", "8", ".", ".", ".", ".", "6", "."},
                    {"8", ".", ".", ".", "6", ".", ".", ".", "3"},
                    {"4", ".", ".", "8", ".", "3", ".", ".", "1"},
                    {"7", ".", ".", ".", "2", ".", ".", ".", "6"},
                    {".", "6", ".", ".", ".", ".", "2", "8", "."},
                    {".", ".", ".", "4", "1", "9", ".", ".", "5"},
                    {".", ".", ".", ".", "8", ".", ".", "7", "9"}};

    public void solveSudoku(char[][] board) {
        my(s2c(strings));
    }

    public void my(char[][] board) {

    }

    private char[][] s2c(String[][] s) {
        char[][] result = new char[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                result[i][j] = s[i][j].toCharArray()[0];
            }
        }
        return result;
    }


}
