package leetcode.medium;

// https://leetcode.com/problems/word-search/
public class Q0079WordSearch {
  // Space O(L) time O(M * N * 4^L), branches to 4 adjacent squares
  public boolean exist1(char[][] board, String word) {
    if (board == null || word == null || word.length() == 0) return false;
    for (int i = 0; i < board.length; i++)
      for (int j = 0; j < board[0].length; j++) if (exist1(board, word, 0, i, j)) return true;
    return false;
  }

  public boolean exist1(char[][] board, String word, int index, int i, int j) {
    if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return false;
    if (board[i][j] != word.charAt(index)) return false;
    if (index == word.length() - 1) return true;
    char temp = board[i][j];
    board[i][j] = '#';
    boolean found =
        exist1(board, word, index + 1, i, j - 1)
            || exist1(board, word, index + 1, i, j + 1)
            || exist1(board, word, index + 1, i - 1, j)
            || exist1(board, word, index + 1, i + 1, j);
    board[i][j] = temp;
    return found;
  }
}
