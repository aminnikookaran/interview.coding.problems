package leetcode.medium;

// https://leetcode.com/problems/word-search/
public class Q0079WordSearch {
  public boolean exist1(char[][] board, String word) {
    if (board == null || word == null || word.length() == 0) return false;
    for (int i = 0; i < board.length; i++)
      for (int j = 0; j < board[0].length; j++)
        if (board[i][j] == word.charAt(0)) if (findWord(board, word, 0, i, j)) return true;
    return false;
  }

  public boolean findWord(char[][] board, String word, int index, int i, int j) {
    if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return false;
    if (board[i][j] != word.charAt(index)) return false;
    if (index == word.length() - 1) return true;
    char temp = board[i][j];
    board[i][j] = '#';
    boolean found =
        findWord(board, word, index + 1, i, j - 1)
            || findWord(board, word, index + 1, i, j + 1)
            || findWord(board, word, index + 1, i - 1, j)
            || findWord(board, word, index + 1, i + 1, j);
    board[i][j] = temp;
    return found;
  }

  public boolean exist(char[][] board, String word) {
    int m = board.length;
    int n = board[0].length;
    boolean result = false;
    for (int i = 0; i < m; i++)
      for (int j = 0; j < n; j++) if (dfs(board, word, i, j, 0)) return true;
    return result;
  }

  public boolean dfs(char[][] board, String word, int i, int j, int k) {
    int m = board.length;
    int n = board[0].length;
    if (i < 0 || j < 0 || i >= m || j >= n) return false;
    if (board[i][j] == word.charAt(k)) {
      char temp = board[i][j];
      board[i][j] = '#';
      if (k == word.length() - 1) {
        return true;
      } else if (dfs(board, word, i - 1, j, k + 1)
          || dfs(board, word, i + 1, j, k + 1)
          || dfs(board, word, i, j - 1, k + 1)
          || dfs(board, word, i, j + 1, k + 1)) {
        return true;
      }
      board[i][j] = temp;
    }
    return false;
  }
}
