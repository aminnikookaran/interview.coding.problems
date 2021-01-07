package leetcode.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import leetcode.Node;

// https://leetcode.com/problems/clone-graph/
public class Q0133CloneGraph {
  public Node cloneGraph1(Node node) {
    Map<Integer, Node> map = new HashMap<>();
    return cloneGraph1(node, map);
  }

  private Node cloneGraph1(Node node, Map<Integer, Node> map) {
    if (node == null) return null;
    if (map.containsKey(node.val)) return map.get(node.val);
    else {
      Node clone = new Node(node.val, new ArrayList<>());
      map.put(node.val, clone);
      for (int i = 0; i < node.neighbors.size(); i++)
        clone.neighbors.add(cloneGraph1(node.neighbors.get(i), map));
      return clone;
    }
  }

  public Node cloneGraph2(Node node) {
    if (node == null) return null;
    Map<Node, Node> map = new HashMap<>();
    Deque<Node> queue = new ArrayDeque<>();
    map.put(node, new Node(node.val, new ArrayList<>()));
    queue.add(node);
    while (!queue.isEmpty()) {
      Node currNode = queue.poll();
      for (Node currNeighbor : currNode.neighbors) {
        if (!map.containsKey(currNeighbor)) {
          map.put(currNeighbor, new Node(currNeighbor.val, new ArrayList<>()));
          queue.add(currNeighbor);
        }
        map.get(currNode).neighbors.add(map.get(currNeighbor));
      }
    }
    return map.get(node);
  }
}
