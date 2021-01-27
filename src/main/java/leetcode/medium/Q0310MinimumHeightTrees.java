package leetcode.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/minimum-height-trees/
public class Q0310MinimumHeightTrees {
  public List<Integer> findMinHeightTrees1(int n, int[][] edges) {
    // base cases
    if (n < 2) {
      List<Integer> centroids = new ArrayList<>();
      for (int i = 0; i < n; i++) centroids.add(i);
      return centroids;
    }

    // Build the graph with the adjacency list
    List<Set<Integer>> neighbors = new ArrayList<>();
    for (int i = 0; i < n; i++) neighbors.add(new HashSet<>());

    for (int[] edge : edges) {
      Integer start = edge[0], end = edge[1];
      neighbors.get(start).add(end);
      neighbors.get(end).add(start);
    }

    // Initialize the first layer of leaves
    List<Integer> leaves = new ArrayList<>();
    for (int i = 0; i < n; i++) if (neighbors.get(i).size() == 1) leaves.add(i);

    // Trim the leaves until reaching the centroids
    int remainingNodes = n;
    while (remainingNodes > 2) {
      remainingNodes -= leaves.size();
      List<Integer> newLeaves = new ArrayList<>();

      // remove the current leaves along with the edges
      for (Integer leaf : leaves) {
        // the only neighbor left for the leaf node
        Integer neighbor = neighbors.get(leaf).iterator().next();
        // remove the edge along with the leaf node
        neighbors.get(neighbor).remove(leaf);
        if (neighbors.get(neighbor).size() == 1) newLeaves.add(neighbor);
      }

      // prepare for the next round
      leaves = newLeaves;
    }

    // The remaining nodes are the centroids of the graph
    return leaves;
  }

  public List<Integer> findMinHeightTrees2(int n, int[][] edges) {
    List<Integer> result = new ArrayList<>();
    if (n == 1) {
      result.add(0);
      return result;
    }

    List<List<Integer>> myGraph = new ArrayList<>();
    int[] degree = new int[n];
    for (int i = 0; i < n; i++) myGraph.add(new ArrayList<>());
    for (int i = 0; i < edges.length; i++) {
      myGraph.get(edges[i][0]).add(edges[i][1]);
      myGraph.get(edges[i][1]).add(edges[i][0]);
      degree[edges[i][0]]++;
      degree[edges[i][1]]++;
    }

    Deque<Integer> deque = new ArrayDeque<>();
    for (int i = 0; i < n; i++)
      if (degree[i] == 0) return result;
      else if (degree[i] == 1) deque.add(i);

    while (!deque.isEmpty()) {
      result = new ArrayList<>();
      int size = deque.size();

      for (int i = 0; i < size; i++) {
        int curr = deque.poll();
        result.add(curr);
        for (int k = 0; k < myGraph.get(curr).size(); k++) {
          int next = myGraph.get(curr).get(k);
          degree[next]--;
          if (degree[next] == 1) deque.add(next);
        }
      }
    }
    return result;
  }
}
