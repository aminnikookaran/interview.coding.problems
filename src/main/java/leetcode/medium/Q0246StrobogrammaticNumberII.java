package leetcode.medium;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/strobogrammatic-number-ii/
public class Q0246StrobogrammaticNumberII {
  public List<String> findStrobogrammatic1(int n) {
    return find1(n, n);
  }

  List<String> find1(int n, int m) {
    List<String> res = new ArrayList<>();
    if (n == 0) {
      res.add("");
      return res;
    }
    if (n == 1) {
      res.add("1");
      res.add("0");
      res.add("8");
      return res;
    }

    List<String> prev = find1(n - 2, m);

    for (String s : prev) {
      if (n != m) res.add("0" + s + "0");
      res.add("1" + s + "1");
      res.add("8" + s + "8");
      res.add("6" + s + "9");
      res.add("9" + s + "6");
    }

    return res;
  }

  public List<String> findStrobogrammatic2(int n) {
    List<String> res;
    if ((n & 1) == 0) {
      List<String> l0 = new ArrayList<>();
      l0.add("");
      res = l0;
    } else {
      List<String> l1 = new ArrayList<>();
      l1.add("1");
      l1.add("0");
      l1.add("8");
      res = l1;
    }

    int i = ((n & 1) == 0) ? 2 : 3;
    for (; i <= n; i += 2) {
      List<String> tmp = new ArrayList<>();
      for (String s : res) {
        if (i != n) tmp.add("0" + s + "0");
        tmp.add("1" + s + "1");
        tmp.add("9" + s + "6");
        tmp.add("6" + s + "9");
        tmp.add("8" + s + "8");
      }

      res = tmp;
    }
    return res;
  }
}
