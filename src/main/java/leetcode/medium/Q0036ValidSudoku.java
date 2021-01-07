package leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/valid-sudoku/
public class Q0036ValidSudoku {
  public boolean isValidSudoku(char[][] board) {
    List<Set<Integer>> rows = new ArrayList<>();
    List<Set<Integer>> columns = new ArrayList<>();
    List<Set<Integer>> squares = new ArrayList<>();
    int n = board.length;
    for (int i = 0; i < n; i++) {
      rows.add(new HashSet<>());
      columns.add(new HashSet<>());
      squares.add(new HashSet<>());
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (board[i][j] < '1' || board[i][j] > '9') continue;
        int number = board[i][j] - '0';
        if (rows.get(i).contains(number)) return false;
        if (columns.get(j).contains(number)) return false;
        if (squares.get(3 * (i / 3) + j / 3).contains(number)) return false;
        rows.get(i).add(number);
        columns.get(j).add(number);
        squares.get(3 * (i / 3) + j / 3).add(number);
      }
    }
    return true;
  }
}
