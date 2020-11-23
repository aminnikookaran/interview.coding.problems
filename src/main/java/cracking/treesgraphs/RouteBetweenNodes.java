package cracking.treesgraphs;

import java.util.LinkedList;
import java.util.List;

public class RouteBetweenNodes {
  enum State {
    Unvisited,
    Visited,
    Visiting;
  }

  boolean search(Graph g, Node start, Node end) {
    if (start == end) return true;

    // operates as Queue
    LinkedList<Node> q = new LinkedList<Node>();

    for (Node u : g.getNodes()) u.state = State.Unvisited;
    start.state = State.Visiting;
    q.add(start);
    Node u;
    while (!q.isEmpty()) {
      u = q.removeFirst(); // i.e., dequeue()
      if (u != null) {
        for (Node v : u.getAdjacent())
          if (v.state == State.Unvisited)
            if (v == end) return true;
            else {
              v.state = State.Visiting;
              q.add(v);
            }
        u.state = State.Visited;
      }
    }
    return false;
  }

  class Graph {
    private List<Node> nodes;

    public List<Node> getNodes() {
      return nodes;
    }

    public void setNodes(List<Node> nodes) {
      this.nodes = nodes;
    }
  }

  class Node {
    State state;
    private List<Node> adjacent;

    public List<Node> getAdjacent() {
      return adjacent;
    }

    public void setAdjacent(List<Node> adjacent) {
      this.adjacent = adjacent;
    }
  }
}
