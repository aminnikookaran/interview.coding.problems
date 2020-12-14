package leetcode.medium;

// https://leetcode.com/problems/game-of-life/
public class Q289GameOfLife {
  public void gameOfLife1(int[][] board) {
    for (int i = 0; i < board.length; i++)
      for (int j = 0; j < board[0].length; j++) {
        int count = countNeighbours(board, i, j);
        if (board[i][j] == 0 && count == 3) board[i][j] = 2;
        if (board[i][j] == 1 && (count < 2 || count > 3)) board[i][j] = 3;
      }
    for (int i = 0; i < board.length; i++)
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == 2) board[i][j] = 1;
        if (board[i][j] == 3) board[i][j] = 0;
      }
  }

  public int countNeighbours(int[][] board, int i, int j) {
    int count = 0;
    int[] ci = new int[] {-1, -1, -1, 0, 0, 1, 1, 1};
    int[] cj = new int[] {-1, 0, 1, -1, 1, -1, 0, 1};
    for (int k = 0; k < 8; k++) {
      int ni = i + ci[k];
      int nj = j + cj[k];
      if (ni >= 0
          && ni < board.length
          && nj >= 0
          && nj < board[0].length
          && (board[ni][nj] == 1 || board[ni][nj] == 3)) count++;
    }
    return count;
  }

  public void gameOfLife2(int[][] board) {
    int[] neighbors = {0, 1, -1};
    int rows = board.length;
    int cols = board[0].length;
    for (int row = 0; row < rows; row++) {
      for (int col = 0; col < cols; col++) {
        int liveNeighbors = 0;
        for (int i = 0; i < 3; i++)
          for (int j = 0; j < 3; j++)
            if (!(neighbors[i] == 0 && neighbors[j] == 0)) {
              int r = (row + neighbors[i]);
              int c = (col + neighbors[j]);
              if ((r < rows && r >= 0) && (c < cols && c >= 0) && (Math.abs(board[r][c]) == 1))
                liveNeighbors += 1;
            }
        if ((board[row][col] == 1) && (liveNeighbors < 2 || liveNeighbors > 3))
          board[row][col] = -1;
        if (board[row][col] == 0 && liveNeighbors == 3) board[row][col] = 2;
      }
    }
    for (int row = 0; row < rows; row++)
      for (int col = 0; col < cols; col++)
        if (board[row][col] > 0) board[row][col] = 1;
        else board[row][col] = 0;
  }
}
