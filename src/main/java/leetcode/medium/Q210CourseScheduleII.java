package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

// https://leetcode.com/problems/course-schedule-ii/
public class Q210CourseScheduleII {
  public int[] findOrder1(int numCourses, int[][] prerequisites) {
    int[] prCount = new int[numCourses];
    Map<Integer, Set<Integer>> map = new HashMap<>();
    for (int i = 0; i < prerequisites.length; i++) {
      prCount[prerequisites[i][0]]++;
      if (!map.containsKey(prerequisites[i][1])) map.put(prerequisites[i][1], new HashSet<>());
      map.get(prerequisites[i][1]).add(prerequisites[i][0]);
    }

    Map<Integer, Set<Integer>> prCountMap = new HashMap<>();
    for (int i = 0; i < numCourses; i++) {
      if (!prCountMap.containsKey(prCount[i])) prCountMap.put(prCount[i], new HashSet<>());
      prCountMap.get(prCount[i]).add(i);
    }

    List<Integer> resultList = new ArrayList<>();
    while (prCountMap.containsKey(0)) {
      Set<Integer> courses = prCountMap.get(0);
      prCountMap.remove(0);
      resultList.addAll(courses);
      for (Integer course : courses) {
        Set<Integer> postCourses = map.get(course);
        if (postCourses != null)
          for (Integer postCourse : postCourses) {
            prCountMap.get(prCount[postCourse]).remove(postCourse);
            prCount[postCourse]--;
            if (!prCountMap.containsKey(prCount[postCourse]))
              prCountMap.put(prCount[postCourse], new HashSet<>());
            prCountMap.get(prCount[postCourse]).add(postCourse);
          }
      }
    }
    if (resultList.size() < numCourses) return new int[0];
    int[] result = new int[numCourses];
    for (int i = 0; i < numCourses; i++) result[i] = resultList.get(i);
    return result;
  }

  static int WHITE = 1;
  static int GRAY = 2;
  static int BLACK = 3;

  boolean isPossible;
  Map<Integer, Integer> color;
  Map<Integer, List<Integer>> adjList;
  List<Integer> topologicalOrder;

  private void init(int numCourses) {
    this.isPossible = true;
    this.color = new HashMap<Integer, Integer>();
    this.adjList = new HashMap<Integer, List<Integer>>();
    this.topologicalOrder = new ArrayList<Integer>();

    // By default all vertces are WHITE
    for (int i = 0; i < numCourses; i++) this.color.put(i, WHITE);
  }

  private void dfs(int node) {
    // Don't recurse further if we found a cycle already
    if (!this.isPossible) return;

    // Start the recursion
    this.color.put(node, GRAY);

    // Traverse on neighboring vertices
    for (Integer neighbor : this.adjList.getOrDefault(node, new ArrayList<Integer>()))
      if (this.color.get(neighbor) == WHITE) this.dfs(neighbor);
      else if (this.color.get(neighbor) == GRAY)
        this.isPossible = false; // An edge to a GRAY vertex represents a cycle

    // Recursion ends. We mark it as black
    this.color.put(node, BLACK);
    this.topologicalOrder.add(node);
  }

  public int[] findOrder2(int numCourses, int[][] prerequisites) {
    this.init(numCourses);

    // Create the adjacency list representation of the graph
    for (int i = 0; i < prerequisites.length; i++) {
      int dest = prerequisites[i][0];
      int src = prerequisites[i][1];
      List<Integer> lst = adjList.getOrDefault(src, new ArrayList<Integer>());
      lst.add(dest);
      adjList.put(src, lst);
    }

    // If the node is unprocessed, then call dfs on it.
    for (int i = 0; i < numCourses; i++) if (this.color.get(i) == WHITE) this.dfs(i);

    int[] order;
    if (this.isPossible) {
      order = new int[numCourses];
      for (int i = 0; i < numCourses; i++) order[i] = this.topologicalOrder.get(numCourses - i - 1);
    } else order = new int[0];

    return order;
  }

  public int[] findOrder3(int numCourses, int[][] prerequisites) {
    Map<Integer, List<Integer>> adjList = new HashMap<Integer, List<Integer>>();
    int[] indegree = new int[numCourses];
    int[] topologicalOrder = new int[numCourses];

    // Create the adjacency list representation of the graph
    for (int i = 0; i < prerequisites.length; i++) {
      int dest = prerequisites[i][0];
      int src = prerequisites[i][1];
      List<Integer> lst = adjList.getOrDefault(src, new ArrayList<Integer>());
      lst.add(dest);
      adjList.put(src, lst);

      // Record in-degree of each vertex
      indegree[dest] += 1;
    }

    // Add all vertices with 0 in-degree to the queue
    Queue<Integer> q = new LinkedList<Integer>();
    for (int i = 0; i < numCourses; i++) if (indegree[i] == 0) q.add(i);

    int i = 0;
    // Process until the Q becomes empty
    while (!q.isEmpty()) {
      int node = q.remove();
      topologicalOrder[i++] = node;

      // Reduce the in-degree of each neighbor by 1
      if (adjList.containsKey(node))
        for (Integer neighbor : adjList.get(node)) {
          indegree[neighbor]--;

          // If in-degree of a neighbor becomes 0, add it to the Q
          if (indegree[neighbor] == 0) q.add(neighbor);
        }
    }

    // Check to see if topological sort is possible or not.
    if (i == numCourses) return topologicalOrder;

    return new int[0];
  }
}
