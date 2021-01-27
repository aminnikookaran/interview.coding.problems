package leetcode.medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

// https://leetcode.com/problems/water-and-jug-problem/
public class Q0365WaterAndJugProblem {
  public boolean canMeasureWater1(int x, int y, int z) {
    if (x + y < z) return false;
    if (x == z || y == z || x + y == z) return true;
    return z % gcd(x, y) == 0;
  }

  public int gcd(int a, int b) {
    while (b != 0) {
      int temp = b;
      b = a % b;
      a = temp;
    }
    return a;
  }

  public boolean canMeasureWater2(int x, int y, int z) {
    if (x + y < z) return false;
    if (z == x || x == y || x == x + y) return true;

    if (x > y) {
      int tmp = x;
      x = y;
      y = tmp;
    }

    Deque<State> states = new ArrayDeque<>();
    Set<State> visited = new HashSet<>();

    // initial state
    State init = new State(0, 0);
    states.offer(init);
    visited.add(init);

    while (!states.isEmpty()) {
      State curr = states.poll();
      if (curr.a + curr.b == z) return true;

      // fill jug1
      Deque<State> queue = new ArrayDeque<>();
      queue.offer(new State(x, curr.b)); // fill jug 1
      queue.offer(new State(0, curr.b)); // empty jug1
      queue.offer(new State(curr.a, y)); // fill jug 2
      queue.offer(new State(curr.a, 0)); // empty jug2
      queue.offer(
          new State(
              Math.min(curr.a + curr.b, x),
              curr.a + curr.b < x ? 0 : curr.b - (x - curr.a))); // pour all water from jug2 to jug1
      queue.offer(
          new State(
              curr.a + curr.b < y ? 0 : curr.a - (y - curr.b),
              Math.min(curr.a + curr.b, y))); // pour all water from jug1 to jug2

      for (State tmp : queue) {
        if (visited.contains(tmp)) continue;
        states.offer(tmp);
        visited.add(tmp);
      }
    }
    return false;
  }

  class State {
    public int a, b;

    public State(int a, int b) {
      this.a = a;
      this.b = b;
    }

    public int hashCode() {
      return 31 * a + b;
    }

    public boolean equals(Object o) {
      State other = (State) o;
      return this.a == other.a && this.b == other.b;
    }
  }

  public boolean canMeasureWater3(int x, int y, int z) {
    if (z < 0 || z > x + y) return false;

    Set<Integer> set = new HashSet<>();
    Queue<Integer> q = new LinkedList<>();
    q.offer(0);
    while (!q.isEmpty()) {
      int n = q.poll();
      if (n + x <= x + y && set.add(n + x)) q.offer(n + x);
      if (n + y <= x + y && set.add(n + y)) q.offer(n + y);
      if (n - x >= 0 && set.add(n - x)) q.offer(n - x);
      if (n - y >= 0 && set.add(n - y)) q.offer(n - y);
      if (set.contains(z)) return true;
    }
    return false;
  }
}
