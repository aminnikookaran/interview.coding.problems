package hackerrank.algorithms.recursionbacktracking;

// https://www.hackerrank.com/challenges/crossword-puzzle/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=recursion-backtracking
public class CrosswordPuzzle {
  //  // ways are to calculate the number of
  //  // possible ways to fill the grid
  //  int ways = 0;
  //
  //  // this function checks for the current word
  //  // if it can be placed horizontally or not
  //  // x -> it represent index of row
  //  // y -> it represent index of column
  //  // currentWord -> it represent the
  //  // current word in word array
  //  List<String> checkHorizontal(int x, int y, List<String> matrix, String currentWord) {
  //    int n = currentWord.length();
  //
  //    for (int i = 0; i < n; i++) {
  //      if (matrix.get(x).charAt(y + i) == '#' || matrix.get(x).charAt(y + i) == currentWord[i]) {
  //        matrix.get(x).charAt(y + i) = currentWord[i];
  //      } else {
  //
  //        // this shows that word cannot
  //        // be placed horizontally
  //        matrix[0][0] = '@';
  //        return matrix;
  //      }
  //    }
  //
  //    return matrix;
  //  }
  //
  //  // this function checks for the current word
  //  // if it can be placed vertically or not
  //  // x -> it represent index of row
  //  // y -> it represent index of column
  //  // currentWord -> it represent the
  //  // current word in word array
  //  List<String> checkVertical(int x, int y, List<String> matrix, String currentWord) {
  //    int n = currentWord.length();
  //
  //    for (int i = 0; i < n; i++) {
  //      if (matrix[x + i][y] == '#' || matrix[x + i][y] == currentWord[i]) {
  //        matrix[x + i][y] = currentWord[i];
  //      } else {
  //
  //        // this shows that word
  //        // cannot be placed vertically
  //        matrix[0][0] = '@';
  //        return matrix;
  //      }
  //    }
  //    return matrix;
  //  }
  //
  //  // this function recursively checks for every
  //  // word that can align vertically in one loop
  //  // and in another loop it checks for those words
  //  // that can align horizontally words -> it
  //  // contains all the words to fill in a crossword
  //  // puzzle matrix -> it contain the current
  //  // state of crossword index -> it represent
  //  // the index of current word n -> it represent
  //  // the length of row or column of the square matrix
  //  void solvePuzzle(List<String> words, List<String> matrix, int index, int n) {
  //    if (index < words.size()) {
  //      String currentWord = words[index];
  //      int maxLen = n - currentWord.length();
  //
  //      // loop to check the words that can align vertically.
  //      for (int i = 0; i < n; i++) {
  //        for (int j = 0; j <= maxLen; j++) {
  //          List<String> temp = checkVertical(j, i, matrix, currentWord);
  //
  //          if (temp[0][0] != '@') {
  //            solvePuzzle(words, temp, index + 1, n);
  //          }
  //        }
  //      }
  //
  //      // loop to check the words that can align horizontally.
  //      for (int i = 0; i < n; i++) {
  //        for (int j = 0; j <= maxLen; j++) {
  //          List<String> temp = checkHorizontal(i, j, matrix, currentWord);
  //
  //          if (temp[0][0] != '@') {
  //            solvePuzzle(words, temp, index + 1, n);
  //          }
  //        }
  //      }
  //    } else {
  //      // increase the ways
  //      ways++;
  //      return;
  //    }
  //  }
  //
  //  static String[] crosswordPuzzle(String[] crossword, String words) {}
}
