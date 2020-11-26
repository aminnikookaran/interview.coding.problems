package cracking.treesgraphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class BuildOrder {
  /* Find a correct build order. */
  Project[] findBuildOrder1(String[] projects, String[][] dependencies) {
    Graph graph = buildGraph(projects, dependencies);
    return orderProjects1(graph.getNodes());
  }

  /* Build the graph, adding the edge (a, b) if b is dependent on a. Assumes a pair
   * is listed in "build order". The pair (a, b) in dependencies indicates that b
   * depends on a and a must be built before b. */
  Graph buildGraph(String[] projects, String[][] dependencies) {
    Graph graph = new Graph();
    for (String project : projects) graph.getOrCreateNode(project);

    for (String[] dependency : dependencies) {
      String first = dependency[0];
      String second = dependency[1];
      graph.addEdge(first, second);
    }

    return graph;
  }

  /* Return a list of the projects a correct build order.*/
  Project[] orderProjects1(List<Project> projects) {
    Project[] order = new Project[projects.size()];

    /* Add "roots" to the build order first.*/
    int endOfList = addNonDependent(order, projects, 0);

    int toBeProcessed = 0;
    while (toBeProcessed < order.length) {
      Project current = order[toBeProcessed];

      /* We have a circular dependency since there are no remaining projects with
       * zero dependencies. */
      if (current == null) return null;

      /* Remove myself as a dependency. */
      List<Project> children = current.getChildren();
      for (Project child : children) child.decrementDependencies();

      /* Add children that have no one depending on them. */
      endOfList = addNonDependent(order, children, endOfList);
      toBeProcessed++;
    }

    return order;
  }

  /* A helper function to insert projects with zero dependencies into the order
   * array, starting at index offset. */
  int addNonDependent(Project[] order, List<Project> projects, int offset) {
    for (Project project : projects)
      if (project.getNumberDependencies() == 0) {
        order[offset] = project;
        offset++;
      }
    return offset;
  }

  public class Graph {
    private List<Project> nodes = new ArrayList<Project>();
    private Map<String, Project> map = new HashMap<String, Project>();

    public Project getOrCreateNode(String name) {
      if (!map.containsKey(name)) {
        Project node = new Project(name);
        nodes.add(node);
        map.put(name, node);
      }

      return map.get(name);
    }

    public void addEdge(String startName, String endName) {
      Project start = getOrCreateNode(startName);
      Project end = getOrCreateNode(endName);
      start.addNeighbor(end);
    }

    public List<Project> getNodes() {
      return nodes;
    }
  }

  public static class Project {
    private List<Project> children = new ArrayList<Project>();
    private Map<String, Project> map = new HashMap<String, Project>();
    private String name;
    private int dependencies = 0;

    public enum State {
      COMPLETE,
      PARTIAL,
      BLANK
    };

    private State state = State.BLANK;

    public State getState() {
      return state;
    }

    public void setState(State st) {
      state = st;
    }

    public Project(String n) {
      name = n;
    }

    public void addNeighbor(Project node) {
      if (!map.containsKey(node.getName())) {
        children.add(node);
        map.put(node.getName(), node);
        node.incrementDependencies();
      }
    }

    public void incrementDependencies() {
      dependencies++;
    }

    public void decrementDependencies() {
      dependencies--;
    }

    public String getName() {
      return name;
    }

    public List<Project> getChildren() {
      return children;
    }

    public int getNumberDependencies() {
      return dependencies;
    }
  }

  Stack<Project> findBuildOrder2(String[] projects, String[][] dependencies) {
    Graph graph = buildGraph(projects, dependencies);
    return orderProjects2(graph.getNodes());
  }

  Stack<Project> orderProjects2(List<Project> projects) {
    Stack<Project> stack = new Stack<Project>();
    for (Project project : projects)
      if (project.getState() == Project.State.BLANK) if (!doDFS(project, stack)) return null;
    return stack;
  }

  boolean doDFS(Project project, Stack<Project> stack) {
    if (project.getState() == Project.State.PARTIAL) return false; // Cycle

    if (project.getState() == Project.State.BLANK) {
      project.setState(Project.State.PARTIAL);
      List<Project> children = project.getChildren();
      for (Project child : children) if (!doDFS(child, stack)) return false;

      project.setState(Project.State.COMPLETE);
      stack.push(project);
    }
    return true;
  }
}
