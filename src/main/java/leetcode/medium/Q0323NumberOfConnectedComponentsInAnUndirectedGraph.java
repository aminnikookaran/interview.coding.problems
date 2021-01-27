package leetcode.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/number-of-connected-components-in-an-undirected-graph
public class Q0323NumberOfConnectedComponentsInAnUndirectedGraph {
  public int countComponents1(int n, int[][] edges) {
    if (n <= 1) return n;

    List<Set<Integer>> adjList = new ArrayList<>();
    for (int i = 0; i < n; i++) adjList.add(new HashSet<>());
    for (int[] edge : edges) {
      adjList.get(edge[0]).add(edge[1]);
      adjList.get(edge[1]).add(edge[0]);
    }

    boolean[] visited = new boolean[n];
    int count = 0;
    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        ++count;
        Deque<Integer> queue = new ArrayDeque<>();
        queue.add(i);

        while (!queue.isEmpty()) {
          int curIndex = queue.remove();
          visited[curIndex] = true;
          for (int nextIndex : adjList.get(curIndex)) if (!visited[nextIndex]) queue.add(nextIndex);
        }
      }
    }
    return count;
  }

  public int countComponents2(int n, int[][] edges) {
    if (n <= 1) return n;

    List<Set<Integer>> adjList = new ArrayList<>();
    for (int i = 0; i < n; i++) adjList.add(new HashSet<>());
    for (int[] edge : edges) {
      adjList.get(edge[0]).add(edge[1]);
      adjList.get(edge[1]).add(edge[0]);
    }

    boolean[] visited = new boolean[n];
    int count = 0;
    for (int i = 0; i < n; i++) {
      if (!visited[i]) {
        ++count;
        searchComponentByDFS(i, adjList, visited);
      }
    }
    return count;
  }

  public void searchComponentByDFS(int node, List<Set<Integer>> adjList, boolean[] visited) {
    visited[node] = true;
    for (int nextNode : adjList.get(node))
      if (!visited[nextNode]) searchComponentByDFS(nextNode, adjList, visited);
  }

  public int countComponents3(int n, int[][] edges) {
    int count = n;
    int[] root = new int[n];
    // initialize each node is an island
    for (int i = 0; i < n; i++) root[i] = i;

    for (int i = 0; i < edges.length; i++) {
      int x = edges[i][0];
      int y = edges[i][1];
      int xRoot = getRoot(root, x);
      int yRoot = getRoot(root, y);
      if (xRoot != yRoot) {
        count--;
        root[xRoot] = yRoot;
      }
    }
    return count;
  }

  public int getRoot(int[] arr, int i) {
    while (arr[i] != i) {
      arr[i] = arr[arr[i]];
      i = arr[i];
    }
    return i;
  }

  public int countComponents4(int n, int[][] edges) {
    if (n <= 1) return n;

    UnionFind uf = new UnionFind(n);

    for (int[] edge : edges) uf.union(edge[0], edge[1]);
    return uf.count;
  }

  class UnionFind {
    int[] sets;
    int[] size;
    int count;

    public UnionFind(int n) {
      sets = new int[n];
      size = new int[n];
      count = n;

      for (int i = 0; i < n; i++) {
        sets[i] = i;
        size[i] = 1;
      }
    }

    public int find(int node) {
      while (node != sets[node]) node = sets[node];
      return node;
    }

    public void union(int i, int j) {
      int node1 = find(i);
      int node2 = find(j);

      if (node1 == node2) return;

      if (size[node1] < size[node2]) {
        sets[node1] = node2;
        size[node2] += size[node2];
      } else {
        sets[node2] = node1;
        size[node1] += size[node2];
      }
      --count;
    }
  }
}
