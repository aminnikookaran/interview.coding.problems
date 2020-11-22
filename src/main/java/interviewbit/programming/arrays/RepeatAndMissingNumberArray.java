package interviewbit.programming.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RepeatAndMissingNumberArray {
  public static List<Integer> repeatedNumber1(final List<Integer> A) {
    Set<Integer> numbers = new HashSet<>();
    for (int i = 1; i <= A.size(); i++) numbers.add(i);
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < A.size(); i++)
      if (numbers.contains(A.get(i))) numbers.remove(A.get(i));
      else result.add(A.get(i));
    for (Integer integer : numbers) result.add(integer);
    return result;
  }

  public static List<Integer> repeatedNumber2(final List<Integer> A) {
    int n = A.size();
    long x = 0;
    for (int i = 1; i <= n; i++) x ^= i;
    for (int i = 0; i < n; i++) x ^= A.get(i);
    long a = 0;
    long b = 0;
    int set_bit = (int) (x & ~(x - 1));
    for (int i = 0; i < n; i++) {
      if ((A.get(i) & set_bit) > 0) a ^= A.get(i);
      else b ^= A.get(i);
    }
    for (int i = 1; i <= n; i++) {
      if ((i & set_bit) > 0) a ^= i;
      else b ^= i;
    }
    long p = 0, q = 0;
    for (int i = 0; i < n; i++) {
      if (A.get(i) == a) {
        p = a;
        q = b;
        break;
      }
      if (A.get(i) == b) {
        p = b;
        q = a;
        break;
      }
    }
    List<Integer> ans = new ArrayList<>();
    ans.add((int) p);
    ans.add((int) q);
    return ans;
  }

  public static List<Integer> repeatedNumber3(final List<Integer> A) {
    long n = A.size();
    long square = 0;
    long linear = 0;
    for (int i = 0; i < n; i++) {
      linear += A.get(i);
      square += A.get(i) * A.get(i);
    }
    long expected_square = (n * (n + 1) * (2 * n + 1)) / 6;
    long linear_expected = (n * (n + 1)) / 2;
    long linear_difference = linear - linear_expected;
    long square_difference = square - expected_square;
    long sum = square_difference / linear_difference;
    long a = (sum + linear_difference) / 2;
    long b = sum - a;
    List<Integer> ans = new ArrayList<>();
    ans.add((int) a);
    ans.add((int) b);
    return ans;
  }

  public static void main(String[] args) {
    System.out.println(repeatedNumber1(Arrays.asList(new Integer[] {1, 2, 3, 3, 5})));
  }
}
