package interviewbit.programming.binarySearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://www.interviewbit.com/problems/search-for-a-range/
public class SearchForARange {
  public static List<Integer> searchRange(final List<Integer> A, int B) {
    List<Integer> result = new ArrayList<Integer>();
    result.add(-1);
    result.add(-1);

    int start = 0;
    int end = A.size() - 1;
    while (start < end) {
      int mid = (start + end) / 2;
      if (A.get(mid) < B) start = mid + 1;
      else end = mid;
    }
    if (start == A.size() || A.get(start) != B) return result;
    int firstIndex = start;

    start = 0;
    end = A.size() - 1;
    while (start < end) {
      int mid = 1 + (start + end) / 2;
      if (A.get(mid) > B) end = mid - 1;
      else start = mid;
    }
    int secondIndex = end;

    result.set(0, firstIndex);
    result.set(1, secondIndex);
    return result;
  }

  public static ArrayList<Integer> searchRange1(final List<Integer> A, int B) {
    ArrayList<Integer> ans = new ArrayList<>();
    int size = A.size();
    int left = 0;
    int right = size - 1;
    int mid = -1;
    while (left <= right) {
      mid = (left + right) / 2;
      int curr = A.get(mid);
      if (curr > B) right = mid - 1;
      else if (curr < B) left = mid + 1;
      else break;
    }
    if (left > right) {
      ans.add(-1);
      ans.add(-1);
      return ans;
    }
    int i = mid;
    while (i >= 0) {
      if (A.get(i) != B) {
        ans.add(i + 1);
        break;
      }
      i--;
    }
    if (ans.size() == 0) ans.add(0);
    i = mid;
    while (i < size) {
      if (A.get(i) != B) {
        ans.add(i - 1);
        break;
      }
      i++;
    }
    if (ans.size() == 1) ans.add(size - 1);
    return ans;
  }

  public static ArrayList<Integer> searchRange2(final List<Integer> a, int b) {
    ArrayList<Integer> ans = new ArrayList<Integer>();
    ans.add(getFirstOccurrence(a, 0, a.size() - 1, b));
    ans.add(getLastOccurrence(a, 0, a.size() - 1, b));
    return ans;
  }

  public static int getFirstOccurrence(final List<Integer> a, int l, int r, int b) {
    if (l <= r) {
      int m = (l + r) / 2;
      if ((m == 0 || b > a.get(m - 1)) && a.get(m) == b) {

        return m;
      }
      if (b > a.get(m)) {
        return getFirstOccurrence(a, m + 1, r, b);
      } else {
        return getFirstOccurrence(a, l, m - 1, b);
      }
    }
    return -1;
  }

  public static int getLastOccurrence(final List<Integer> a, int l, int r, int b) {
    if (l <= r) {
      int m = (l + r) / 2;
      if ((m == a.size() - 1 || b < a.get(m + 1)) && a.get(m) == b) {
        return m;
      }
      if (b < a.get(m)) {
        return getLastOccurrence(a, l, m - 1, b);
      } else {
        return getLastOccurrence(a, m + 1, r, b);
      }
    }
    return -1;
  }

  public static ArrayList<Integer> searchRange3(final List<Integer> a, int b) {
    int first = Firstindex(a, b);
    int last = LastIndex(a, b);
    ArrayList<Integer> result = new ArrayList<Integer>();
    result.add(first);
    result.add(last);
    return result;
  }

  public static int LastIndex(List<Integer> a, int b) {
    int index = -1;
    int start = 0;
    int end = a.size() - 1;

    while (start <= end) {
      int mid = (start + end) / 2;
      if (a.get(mid) == b) {
        index = mid;
        start = mid + 1;
      } else if (a.get(mid) > b) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }

    return index;
  }

  public static int Firstindex(List<Integer> a, int b) {
    int index = -1;
    int start = 0;
    int end = a.size() - 1;

    while (start <= end) {
      int mid = (start + end) / 2;
      if (a.get(mid) == b) {
        index = mid;
        end = mid - 1;
      } else if (a.get(mid) > b) {
        end = mid - 1;
      } else {
        start = mid + 1;
      }
    }

    return index;
  }

  public static void main(String[] args) {
    System.out.println(searchRange(Arrays.asList(new Integer[] {5, 7, 7, 8, 8, 10}), 8));
  }
}
