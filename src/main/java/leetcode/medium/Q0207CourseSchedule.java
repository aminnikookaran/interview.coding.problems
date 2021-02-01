package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/course-schedule/
public class Q0207CourseSchedule {
  public boolean canFinish1(int numCourses, int[][] prerequisites) {
    Map<Integer, Set<Integer>> requiresMap = new HashMap<>();
    Map<Integer, Set<Integer>> requiredMap = new HashMap<>();
    for (int i = 0; i < prerequisites.length; i++) {
      if (!requiresMap.containsKey(prerequisites[i][0]))
        requiresMap.put(prerequisites[i][0], new HashSet<>());
      requiresMap.get(prerequisites[i][0]).add(prerequisites[i][1]);
      if (!requiredMap.containsKey(prerequisites[i][1]))
        requiredMap.put(prerequisites[i][1], new HashSet<>());
      requiredMap.get(prerequisites[i][1]).add(prerequisites[i][0]);
    }

    boolean canTakeCourse = true;
    while (canTakeCourse) {
      canTakeCourse = false;
      Iterator<Map.Entry<Integer, Set<Integer>>> iterator = requiredMap.entrySet().iterator();
      while (iterator.hasNext()) {
        Map.Entry<Integer, Set<Integer>> entry = iterator.next();
        if (!requiresMap.containsKey(entry.getKey())) {
          for (Integer course : entry.getValue()) requiresMap.get(course).remove(entry.getKey());
          iterator.remove();
          canTakeCourse = true;
        }
      }

      iterator = requiresMap.entrySet().iterator();
      while (iterator.hasNext()) if (iterator.next().getValue().isEmpty()) iterator.remove();
    }
    return requiredMap.isEmpty();
  }

  public boolean canFinish2(int numCourses, int[][] prerequisites) {
    int len = prerequisites.length;
    if (numCourses == 0 || len == 0) return true;
    // counter for number of prerequisites
    int[] pCounter = new int[numCourses];
    for (int i = 0; i < len; i++) pCounter[prerequisites[i][0]]++;
    // store courses that have no prerequisites
    LinkedList<Integer> queue = new LinkedList<>();
    for (int i = 0; i < numCourses; i++) if (pCounter[i] == 0) queue.add(i);
    // number of courses that have no prerequisites
    int numNoPre = queue.size();
    while (!queue.isEmpty()) {
      int top = queue.remove();
      for (int i = 0; i < len; i++) {
        // if a course's prerequisite can be satisfied by a course in queue
        if (prerequisites[i][1] == top) {
          pCounter[prerequisites[i][0]]--;
          if (pCounter[prerequisites[i][0]] == 0) {
            numNoPre++;
            queue.add(prerequisites[i][0]);
          }
        }
      }
    }
    return numNoPre == numCourses;
  }

  public boolean canFinish(int numCourses, int[][] prerequisites) {
    int len = prerequisites.length;
    if (numCourses == 0 || len == 0) return true;
    // track visited courses
    int[] visit = new int[numCourses];
    // use the map to store what courses depend on a course
    Map<Integer, List<Integer>> map = new HashMap<>();
    for (int[] a : prerequisites)
      if (map.containsKey(a[1])) map.get(a[1]).add(a[0]);
      else {
        List<Integer> l = new ArrayList<>();
        l.add(a[0]);
        map.put(a[1], l);
      }
    for (int i = 0; i < numCourses; i++) if (!canFinishDFS(map, visit, i)) return false;
    return true;
  }

  private boolean canFinishDFS(Map<Integer, List<Integer>> map, int[] visit, int i) {
    if (visit[i] == -1) return false;
    if (visit[i] == 1) return true;
    visit[i] = -1;
    if (map.containsKey(i)) for (int j : map.get(i)) if (!canFinishDFS(map, visit, j)) return false;
    visit[i] = 1;
    return true;
  }
}
