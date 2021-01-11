package leetcode.medium;

import java.util.Stack;

// https://leetcode.com/problems/find-the-celebrity/
public class Q0277FindTheCelebrity {
  public class Relation {
    public boolean knows(int left, int right) {
      return true;
    }
  }

  public class Solution1 extends Relation {
    public int findCelebrity(int n) {
      if (n <= 1) return -1;
      int left = 0;
      int right = n - 1;

      while (left < right) {
        if (knows(left, right)) left++;
        else right--;
      }

      int candidate = right;
      for (int i = 0; i < n; i++)
        if (i != candidate && (!knows(i, candidate) || knows(candidate, i))) return -1;

      return candidate;
    }
  }

  public class Solution2 extends Relation {
    public int findCelebrity(int n) {
      if (n == 1) return 0;

      int id = findCelebrity(n - 1);

      if (id == 1) return n - 1;
      if (knows(id, n - 1) && !knows(n - 1, id)) return n - 1;
      else if (!knows(id, n - 1) && knows(n - 1, id)) return id;
      return -1;
    }
  }

  public class Solution3 extends Relation {
    public int findCelebrity(int n) {
      Stack<Integer> st = new Stack<>();
      for (int i = 0; i < n; i++) st.push(i);
      while (st.size() > 1) {
        int a = st.pop();
        int b = st.pop();
        if (knows(a, b)) st.push(b);
        else st.push(a);
      }

      if (st.empty()) return -1;

      int candidate = st.pop();
      for (int i = 0; i < n; i++)
        if (i != candidate && (knows(candidate, i) || !knows(i, candidate))) return -1;

      return candidate;
    }
  }
}
