package leetcode.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/graph-valid-tree/
public class Q0261GraphValidTree {
  public boolean validTree1(int n, int[][] edges) {
    Map<Integer, List<Integer>> map = new HashMap<>();
    for (int i = 0; i < n; i++) map.put(i, new ArrayList<>());
    for (int[] edge : edges) {
      map.get(edge[0]).add(edge[1]);
      map.get(edge[1]).add(edge[0]);
    }
    Set<Integer> visited = new HashSet<>();

    if (!helper1(0, -1, map, visited)) return false;

    if (visited.size() < n) return false;
    return true;
  }

  public boolean helper1(
      int curr, int parent, Map<Integer, List<Integer>> map, Set<Integer> visited) {
    if (visited.contains(curr)) return false;
    visited.add(curr);
    for (int i : map.get(curr)) if (i != parent && !helper1(i, curr, map, visited)) return false;
    return true;
  }

  public boolean validTree2(int n, int[][] edges) {
    Map<Integer, List<Integer>> map = new HashMap<>();
    for (int i = 0; i < n; i++) map.put(i, new ArrayList<>());
    for (int[] edge : edges) {
      map.get(edge[0]).add(edge[1]);
      map.get(edge[1]).add(edge[0]);
    }
    Set<Integer> visited = new HashSet<>();

    Deque<Integer> deque = new ArrayDeque<>();
    Deque<Integer> parents = new ArrayDeque<>();
    deque.add(0);
    parents.add(-1);
    while (!deque.isEmpty()) {
      int head = deque.poll();
      int parent = parents.poll();
      if (visited.contains(head)) return false;
      visited.add(head);
      for (int node : map.get(head)) {
        if (node != parent && visited.contains(node)) return false;
        deque.add(node);
      }
    }

    if (visited.size() < n) return false;
    return true;
  }

  // Another method is to count the number of nodes == n and the number of edges == n - 1;
}
