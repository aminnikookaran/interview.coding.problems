package cracking.moderate;

import java.util.HashSet;
import java.util.Set;

public class DivingBoard {
  Set<Integer> alllengths1(int k, int shorter, int longer) {
    Set<Integer> lengths = new HashSet<Integer>();
    Set<String> visited = new HashSet<String>();
    getAllLengths(k, 0, shorter, longer, lengths, visited);
    return lengths;
  }

  void getAllLengths(
      int k, int total, int shorter, int longer, Set<Integer> lengths, Set<String> visited) {
    if (k == 0) {
      lengths.add(total);
      return;
    }
    String key = k + " " + total;
    if (visited.contains(key)) return;
    getAllLengths(k - 1, total + shorter, shorter, longer, lengths, visited);
    getAllLengths(k - 1, total + longer, shorter, longer, lengths, visited);
    visited.add(key);
  }

  Set<Integer> alllengths2(int k, int shorter, int longer) {
    Set<Integer> lengths = new HashSet<Integer>();
    for (int nShorter = 0; nShorter <= k; nShorter++) {
      int nlonger = k - nShorter;
      int length = nShorter * shorter + nlonger * longer;
      lengths.add(length);
    }
    return lengths;
  }
}
