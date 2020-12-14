package cracking.moderate;

import java.util.ArrayList;
import java.util.List;

public class PondSizes {
  List<Integer> computePondSizes1(int[][] land) {
    List<Integer> pondSizes = new ArrayList<Integer>();
    for (int r = 0; r < land.length; r++)
      for (int c = 0; c < land[r].length; c++)
        if (land[r][c] == 0) { // Optional. Would return anyway.
          int size = computeSize1(land, r, c);
          pondSizes.add(size);
        }
    return pondSizes;
  }

  int computeSize1(int[][] land, int row, int col) {
    /* If out of bounds or already visited. */
    if (row < 0 || col < 0 || row >= land.length || col >= land[row].length || land[row][col] != 0)
      return 0; // visited or not water
    int size = 1;
    land[row][col] = -1; // Mark visited
    for (int dr = -1; dr <= 1; dr++)
      for (int de = -1; de <= 1; de++) size += computeSize1(land, row + dr, col + de);
    return size;
  }

  List<Integer> computePondSizes2(int[][] land) {
    boolean[][] visited = new boolean[land.length][land[0].length];
    List<Integer> pondSizes = new ArrayList<Integer>();
    for (int r = 0; r < land.length; r++)
      for (int c = 0; c < land[r].length; c++) {
        int size = computeSize2(land, visited, r, c);
        if (size > 0) pondSizes.add(size);
      }
    return pondSizes;
  }

  int computeSize2(int[][] land, boolean[][] visited, int row, int col) {
    /* If out of bounds or already visited. */
    if (row < 0
        || col < 0
        || row >= land.length
        || col >= land[row].length
        || visited[row][col]
        || land[row][col] != 0) return 0;
    int size = 1;
    visited[row][col] = true;
    for (int dr = -1; dr <= 1; dr++)
      for (int de = -1; de <= 1; de++) size += computeSize2(land, visited, row + dr, col + de);
    return size;
  }
}
