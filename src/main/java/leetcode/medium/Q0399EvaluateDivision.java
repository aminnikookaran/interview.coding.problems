package leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/evaluate-division/
public class Q0399EvaluateDivision {
  public double[] calcEquation1(String[][] eq, double[] vals, String[][] q) {
    Map<String, Map<String, Double>> m = new HashMap<>();
    for (int i = 0; i < vals.length; i++) {
      m.putIfAbsent(eq[i][0], new HashMap<>());
      m.putIfAbsent(eq[i][1], new HashMap<>());
      m.get(eq[i][0]).put(eq[i][1], vals[i]);
      m.get(eq[i][1]).put(eq[i][0], 1 / vals[i]);
    }
    double[] r = new double[q.length];
    for (int i = 0; i < q.length; i++)
      r[i] = calcEquation1(q[i][0], q[i][1], 1, m, new HashSet<>());
    return r;
  }

  double calcEquation1(
      String s, String t, double r, Map<String, Map<String, Double>> m, Set<String> seen) {
    if (!m.containsKey(s) || !seen.add(s)) return -1;
    if (s.equals(t)) return r;
    Map<String, Double> next = m.get(s);
    for (String c : next.keySet()) {
      double result = calcEquation1(c, t, r * next.get(c), m, seen);
      if (result != -1) return result;
    }
    return -1;
  }

  public double[] calcEquation2(String[][] e, double[] values, String[][] q) {
    double[] res = new double[q.length];
    Map<String, String> root = new HashMap<>();
    Map<String, Double> dist = new HashMap<>();
    for (int i = 0; i < e.length; i++) {
      String r1 = find(root, dist, e[i][0]);
      String r2 = find(root, dist, e[i][1]);
      root.put(r1, r2);
      dist.put(r1, dist.get(e[i][1]) * values[i] / dist.get(e[i][0]));
    }
    for (int i = 0; i < q.length; i++) {
      if (!root.containsKey(q[i][0]) || !root.containsKey(q[i][1])) {
        res[i] = -1.0;
        continue;
      }
      String r1 = find(root, dist, q[i][0]);
      String r2 = find(root, dist, q[i][1]);
      if (!r1.equals(r2)) {
        res[i] = -1.0;
        continue;
      }
      res[i] = (double) dist.get(q[i][0]) / dist.get(q[i][1]);
    }
    return res;
  }

  private String find(Map<String, String> root, Map<String, Double> dist, String s) {
    if (!root.containsKey(s)) {
      root.put(s, s);
      dist.put(s, 1.0);
      return s;
    }
    if (root.get(s).equals(s)) return s;
    String lastP = root.get(s);
    String p = find(root, dist, lastP);
    root.put(s, p);
    dist.put(s, dist.get(s) * dist.get(lastP));
    return p;
  }
}
