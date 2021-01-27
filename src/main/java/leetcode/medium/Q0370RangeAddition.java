package leetcode.medium;

// https://leetcode.com/problems/range-addition/
public class Q0370RangeAddition {
  public int[] getModifiedArray(int length, int[][] updates) {
    int[] result = new int[length];
    if (updates == null || updates.length == 0) return result;
    for (int i = 0; i < updates.length; i++) {
      result[updates[i][0]] += updates[i][2];
      if (updates[i][1] < length - 1) result[updates[i][1] + 1] -= updates[i][2];
    }
    for (int i = 1; i < length; i++) result[i] += result[i - 1];
    return result;
  }
}
