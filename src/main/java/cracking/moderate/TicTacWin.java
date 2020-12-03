package cracking.moderate;

public class TicTacWin {
  enum Piece {
    Empty,
    Red,
    Blue
  };

  Piece hasWon1(Piece[][] board, int row, int column) {
    if (board.length != board[0].length) return Piece.Empty;
    Piece piece = board[row][column];
    if (piece == Piece.Empty) return Piece.Empty;
    if (hasWonRow(board, row) || hasWonColumn(board, column)) return piece;
    if (row == column && hasWonDiagonal(board, 1)) return piece;
    if (row == (board.length - column - 1) && hasWonDiagonal(board, -1)) return piece;
    return Piece.Empty;
  }

  boolean hasWonRow(Piece[][] board, int row) {
    for (int c = 1; c < board[row].length; c++) if (board[row][c] != board[row][0]) return false;
    return true;
  }

  boolean hasWonColumn(Piece[][] board, int column) {
    for (int r = 1; r < board.length; r++) if (board[r][column] != board[0][column]) return false;
    return true;
  }

  boolean hasWonDiagonal(Piece[][] board, int direction) {
    int row = 0;
    int column = direction == 1 ? 0 : board.length - 1;
    Piece first = board[0][column];
    for (int i = 0; i < board.length; i++) {
      if (board[row][column] != first) return false;
      row += 1;
      column += direction;
    }
    return true;
  }

  Piece hasWon2(Piece[][] board) {
    for (int i = 0; i < board.length; i++) {
      /* Check Rows */
      if (hasWinner(board[i][0], board[i][1], board[i][2])) return board[i][0];
      /* Check Columns */
      if (hasWinner(board[0][i], board[1][i], board[2][i])) return board[0][i];
    }
    /* Check Diagonal */
    if (hasWinner(board[0][0], board[1][1], board[2][2])) return board[0][0];
    if (hasWinner(board[0][2], board[1][1], board[2][0])) return board[0][2];
    return Piece.Empty;
  }

  boolean hasWinner(Piece pl, Piece p2, Piece p3) {
    if (pl == Piece.Empty) return false;
    return pl == p2 && p2 == p3;
  }
}
