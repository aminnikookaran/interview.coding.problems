package leetcode.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

// https://leetcode.com/problems/reconstruct-itinerary/
public class Q0332ReconstructItinerary {
  Map<String, PriorityQueue<String>> map = new HashMap<>();
  LinkedList<String> result = new LinkedList<>();

  public List<String> findItinerary1(String[][] tickets) {
    for (String[] ticket : tickets) {
      if (!map.containsKey(ticket[0])) map.put(ticket[0], new PriorityQueue<>());
      map.get(ticket[0]).offer(ticket[1]);
    }
    dfs("JFK");
    return result;
  }

  public void dfs(String s) {
    PriorityQueue<String> q = map.get(s);
    while (q != null && !q.isEmpty()) dfs(q.poll());
    result.addFirst(s);
  }

  public List<String> findItinerary2(String[][] tickets) {
    Map<String, PriorityQueue<String>> targets = new HashMap<>();
    for (String[] ticket : tickets) {
      if (!map.containsKey(ticket[0])) map.put(ticket[0], new PriorityQueue<>());
      map.get(ticket[0]).offer(ticket[1]);
    }
    LinkedList<String> route = new LinkedList<>();
    Stack<String> stack = new Stack<>();
    stack.push("JFK");
    while (!stack.empty()) {
      while (targets.containsKey(stack.peek()) && !targets.get(stack.peek()).isEmpty())
        stack.push(targets.get(stack.peek()).poll());
      route.addFirst(stack.pop());
    }
    return route;
  }
}
