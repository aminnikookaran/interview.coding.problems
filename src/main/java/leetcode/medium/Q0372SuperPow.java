package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/super-pow/
public class Q0372SuperPow {
  public int superPow1(int a, int[] b) {
    a %= 1337;
    int result = 1;
    for (int i = b.length - 1; i >= 0; i--) {
      result = result * superPow1(a, b[i]) % 1337;
      a = superPow1(a, 10);
    }
    return result;
  }

  public int superPow1(int a, int b) {
    int result = 1;
    while (b != 0) {
      if (b % 2 != 0) result = result * a % 1337;
      a = a * a % 1337;
      b /= 2;
    }
    return result;
  }

  public int superPow2(int a, int[] b) {
    a %= 1337;
    if (a == 0 || b == null || b.length == 0) return 0;
    if (a == 1) return 1;
    List<Integer> index = findLoop(a);
    int loopsize = index.size();
    int rem = modBy(b, loopsize);
    rem = rem == 0 ? loopsize : rem;
    return index.get(rem - 1);
  }

  List<Integer> findLoop(int a) {
    List<Integer> index = new ArrayList<>();
    boolean[] set = new boolean[1337];
    int rem = a % 1337;
    while (!set[rem]) {
      set[rem] = true;
      index.add(rem);
      rem = (rem * a) % 1337;
    }
    return index;
  }

  int modBy(int[] b, int m) {
    int rem = 0;
    for (int i = 0; i < b.length; i++) rem = (rem * 10 + b[i]) % m;
    return rem;
  }
}
