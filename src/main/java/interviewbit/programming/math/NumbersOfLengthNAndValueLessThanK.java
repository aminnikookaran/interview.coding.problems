package interviewbit.programming.math;

import java.util.Arrays;
import java.util.List;

public class NumbersOfLengthNAndValueLessThanK {
  public static int solve1(List<Integer> A, int B, int C) {
    if (A.size() < 1) return 0;

    String cString = String.valueOf(C);
    if (cString.length() < B) return 0;
    else if (cString.length() > B) {
      if (A.get(0) == 0 && B > 1) return (A.size() - 1) * (int) Math.pow(A.size(), B - 1);
      else return (int) Math.pow(A.size(), B);
    }

    int[] cArray = new int[cString.length()];
    for (int i = 0; i < cString.length(); i++)
      cArray[i] = Integer.valueOf(cString.substring(i, i + 1));

    int[] digitsLess = new int[B];
    int[] digitsEqual = new int[B];
    for (int i = 0; i < B; i++) {
      int j = 0;
      while (j < A.size() && A.get(j) < cArray[i]) j++;
      digitsLess[i] = j;
      if (j < A.size() && A.get(j) == cArray[i]) digitsEqual[i] = 1;
    }
    if (A.get(0) == 0 && B > 1) digitsLess[0]--;

    int sum = digitsLess[0] * (int) Math.pow(A.size(), B - 1);
    for (int i = 1; i < B; i++) {
      if (digitsEqual[i - 1] == 0) break;
      sum += digitsLess[i] * (int) Math.pow(A.size(), B - i - 1);
    }
    return sum;
  }

  public static int solve2(List<Integer> A, int B, int C) {
    int cSize = (int) Math.log10(C) + 1;
    int n = A.size();
    if (cSize < B || n == 0) return 0;
    boolean hasZero = A.get(0) == 0;
    if (cSize > B) return (B > 1 && hasZero ? n - 1 : n) * (int) Math.pow(n, B - 1);
    int pow10 = (int) Math.pow(10, B - 1), count = 0;
    for (int i = B; i > 0; i--) {
      int target = C / pow10, j;
      C %= pow10;
      pow10 /= 10;
      for (j = 0; j < n; j++) if (A.get(j) >= target) break;
      count += (B > 1 && i == B && hasZero ? j - 1 : j) * (int) Math.pow(n, i - 1);
      if (j == n || A.get(j) > target) break;
    }
    return count;
  }

  public static int solve3(List<Integer> A, int B, int C) {
    if (A.size() == 0) return 0;
    if (C == 0) return 0;

    int i = 0;
    while (i < A.size()) {
      if (i != A.size() - 1 && A.get(i) == A.get(i + 1)) A.remove(i);
      else i++;
    }

    boolean b = false;
    if (A.get(0) == 0) b = true;

    int t = C, co = 0;
    while (t > 0) {
      co++;
      t /= 10;
    }

    int s = 0;
    if (B < co) {
      s = (int) Math.pow(A.size(), B - 1);
      if (b && B != 1) s *= A.size() - 1;
      else s *= A.size();
      return s;
    } else if (B > co) return 0;

    t = C;
    int d, n, c;
    while (B > 0) {
      if (B == 1) {
        c = count(A, t);
        s += c;
      } else {
        d = (int) Math.pow(10, B - 1);
        n = t / d;
        c = count(A, n);
        if (b && t == C) c--;
        s += c * Math.pow(A.size(), B - 1);
        if (!A.contains(n)) break;
        t = t % d;
      }

      B--;
    }

    return s;
  }

  public static int count(List<Integer> A, int B) {
    int c = 0;
    for (Integer i : A) if (i < B) c++;
    return c;
  }

  public static void main(String[] args) {
    System.out.println(solve2(Arrays.asList(new Integer[] {0, 1, 2, 5}), 1, 123));
  }
}
