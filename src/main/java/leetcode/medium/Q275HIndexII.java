package leetcode.medium;

// https://leetcode.com/problems/h-index-ii/
public class Q275HIndexII {
  public int hIndex(int[] citations) {
    int len = citations.length;
    int left = 0, right = len - 1;
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (citations[mid] == len - mid) return citations[mid];
      else if (citations[mid] < len - mid) left = mid + 1;
      else right = mid - 1;
    }
    return len - left;
  }
}
