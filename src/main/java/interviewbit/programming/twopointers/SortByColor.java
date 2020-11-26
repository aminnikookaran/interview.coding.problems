package interviewbit.programming.twopointers;

import java.util.Arrays;
import java.util.List;

public class SortByColor {
  public static void sortColors1(List<Integer> a) {
    int i = 0;
    int j = 0;
    while (j < a.size() && a.get(j) == 0) j++;
    while (i < a.size() && j < a.size()) {
      if (a.get(i) != 0 && a.get(j) == 0) {
        a.set(j, a.get(i));
        a.set(i, 0);
      }
      if (a.get(j) != 0) j++;
      if (a.get(i) == 0) i++;
    }
    i = 0;
    j = 0;
    while (j < a.size() && a.get(a.size() - 1 - j) == 2) j++;
    while (i < a.size() && j < a.size()) {
      if (a.get(a.size() - 1 - i) != 2 && a.get(a.size() - 1 - j) == 2) {
        a.set(a.size() - 1 - j, a.get(a.size() - 1 - i));
        a.set(a.size() - 1 - i, 2);
      }
      if (a.get(a.size() - 1 - j) != 2) j++;
      if (a.get(a.size() - 1 - i) == 2) i++;
    }
  }

  public void sortColors2(List<Integer> a) {
    int zero = 0, one = 0, index = 0;
    while (index < a.size()) {
      if (a.get(index) == 0) zero++;
      if (a.get(index) == 1) one++;
      index++;
    }
    index = 0;
    while (zero != 0) {
      a.set(index, 0);
      index++;
      zero--;
    }
    while (one != 0) {
      a.set(index, 1);
      index++;
      one--;
    }
    while (index < a.size()) {
      a.set(index, 2);
      index++;
    }
  }

  public static void sortColors3(List<Integer> a) {
    if (a == null || a.size() == 0) return;
    int n = a.size();
    int i = 0;
    int j = n - 1;
    int k = 0;
    while (k <= j) {
      if (a.get(k) == 0) {
        a.set(k, a.get(i));
        a.set(i, 0);
        i++;
        k++;
      } else if (a.get(k) == 2) {
        a.set(k, a.get(j));
        a.set(j, 2);
        j--;
      } else k++;
    }
  }

  public static void sortColors4(List<Integer> a) {
    int n = a.size();
    int i = 0;
    int j = n - 1;
    while (i < j) {
      if (a.get(j) == 0) {
        a.set(j, a.get(i));
        a.set(i, 0);
        i++;
      } else j--;
    }

    i = 0;
    j = n - 1;
    while (i < j) {
      if (a.get(i) == 2) {
        a.set(i, a.get(j));
        a.set(j, 2);
        j--;
      } else i++;
    }
  }

  public static void main(String[] args) {
    List<Integer> a = Arrays.asList(new Integer[] {2, 2, 2, 1, 1, 1, 0, 0, 0});
    sortColors4(a);
    System.out.println(a);
  }
}
