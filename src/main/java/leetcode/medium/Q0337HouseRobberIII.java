package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import leetcode.TreeNode;

// https://leetcode.com/problems/house-robber-iii/
public class Q0337HouseRobberIII {
  public int rob1(TreeNode root) {
    int[] answer = helper1(root);
    return Math.max(answer[0], answer[1]);
  }

  public int[] helper1(TreeNode node) {
    // return [rob this node, not rob this node]
    if (node == null) return new int[] {0, 0};
    int left[] = helper1(node.left);
    int right[] = helper1(node.right);
    // if we rob this node, we cannot rob its children
    int rob = node.val + left[1] + right[1];
    // else, we free to choose rob its children or not
    int notRob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

    return new int[] {rob, notRob};
  }

  HashMap<TreeNode, Integer> robResult = new HashMap<>();
  HashMap<TreeNode, Integer> notRobResult = new HashMap<>();

  public int helper2(TreeNode node, boolean parentRobbed) {
    if (node == null) {
      return 0;
    }
    if (parentRobbed) {
      if (robResult.containsKey(node)) return robResult.get(node);
      int result = helper2(node.left, false) + helper2(node.right, false);
      robResult.put(node, result);
      return result;
    } else {
      if (notRobResult.containsKey(node)) return notRobResult.get(node);
      int rob = node.val + helper2(node.left, true) + helper2(node.right, true);
      int notRob = helper2(node.left, false) + helper2(node.right, false);
      int result = Math.max(rob, notRob);
      notRobResult.put(node, result);
      return result;
    }
  }

  public int rob2(TreeNode root) {
    return helper2(root, false);
  }

  public int rob3(TreeNode root) {
    if (root == null) return 0;
    // reform tree into array-based tree
    ArrayList<Integer> tree = new ArrayList<>();
    HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
    graph.put(-1, new ArrayList<>());
    int index = -1;
    // we use two Queue to store node and index
    Queue<TreeNode> q_node = new LinkedList<>();
    q_node.add(root);
    Queue<Integer> q_index = new LinkedList<>();
    q_index.add(index);

    while (q_node.size() > 0) {
      TreeNode node = q_node.poll();
      int parentIndex = q_index.poll();
      if (node != null) {
        index++;
        tree.add(node.val);
        graph.put(index, new ArrayList<>());
        graph.get(parentIndex).add(index);
        // push new node into Queue
        q_node.add(node.left);
        q_index.add(index);
        q_node.add(node.right);
        q_index.add(index);
      }
    }

    // represent the maximum start by node i with robbing i
    int[] dpRob = new int[index + 1];

    // represent the maximum start by node i without robbing i
    int[] dpNotRob = new int[index + 1];

    for (int i = index; i >= 0; i--) {
      ArrayList<Integer> children = graph.get(i);
      if (children == null || children.size() == 0) {
        // if is leaf
        dpRob[i] = tree.get(i);
        dpNotRob[i] = 0;
      } else {
        dpRob[i] = tree.get(i);
        for (int child : children) {
          dpRob[i] += dpNotRob[child];
          dpNotRob[i] += Math.max(dpRob[child], dpNotRob[child]);
        }
      }
    }

    return Math.max(dpRob[0], dpNotRob[0]);
  }
}
