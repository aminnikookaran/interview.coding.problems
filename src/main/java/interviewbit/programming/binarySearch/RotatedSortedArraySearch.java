package interviewbit.programming.binarySearch;

import java.util.Arrays;
import java.util.List;

// https://www.interviewbit.com/problems/rotated-sorted-array-search/
public class RotatedSortedArraySearch {
  public static int search1(final List<Integer> A, int B) {
    int higher = A.size() - 1;
    int lower = 0;
    int mid = 0;
    while (lower <= higher) {
      mid = (lower + higher) / 2;
      if (A.get(mid) == B) return mid;
      if (A.get(lower) < A.get(mid)) {
        if (B >= A.get(lower) && B <= A.get(mid)) higher = mid - 1;
        else lower = mid + 1;
      } else {
        if (B >= A.get(mid) && B <= A.get(higher)) lower = mid + 1;
        else higher = mid - 1;
      }
    }
    return -1;
  }

  public static int search(final List<Integer> a, int b) {
    return findRec(a, b, 0, a.size() - 1);
  }

  public static int findRec(final List<Integer> a, int n, int low, int high) {
    if (low > high) return -1;
    int mid = low + (high - low) / 2;
    if (a.get(mid) == n) return mid;
    else if ((a.get(low) < a.get(mid) && (a.get(mid) > n && a.get(low) <= n))
        || (a.get(low) > a.get(mid) && (n < a.get(mid) || n >= a.get(low))))
      return findRec(a, n, low, mid - 1);
    else if (((a.get(mid) < n && n <= a.get(high)) && a.get(high) > a.get(mid))
        || (a.get(high) < a.get(mid) && (n > a.get(mid) || n <= a.get(high))))
      return findRec(a, n, mid + 1, high);
    else return -1;
  }

  public static void main(String[] args) {
    System.out.println(
        search(
            Arrays.asList(
                new Integer[] {
                  180, 181, 182, 183, 184, 187, 188, 189, 191, 192, 193, 194, 195, 196, 201, 202,
                  203, 204, 3, 4, 5, 6, 7, 8, 9, 10, 14, 16, 17, 18, 19, 23, 26, 27, 28, 29, 32, 33,
                  36, 37, 38, 39, 41, 42, 43, 45, 48, 51, 52, 53, 54, 56, 62, 63, 64, 67, 69, 72,
                  73, 75, 77, 78, 79, 83, 85, 87, 90, 91, 92, 93, 96, 98, 99, 101, 102, 104, 105,
                  106, 107, 108, 109, 111, 113, 115, 116, 118, 119, 120, 122, 123, 124, 126, 127,
                  129, 130, 135, 137, 138, 139, 143, 144, 145, 147, 149, 152, 155, 156, 160, 162,
                  163, 164, 166, 168, 169, 170, 171, 172, 173, 174, 175, 176, 177
                }),
            42));
  }
}
