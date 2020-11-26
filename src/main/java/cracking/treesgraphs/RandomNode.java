package cracking.treesgraphs;

import java.util.Random;

public class RandomNode {
  class TreeNode {
    private int data;
    public TreeNode left;
    public TreeNode right;
    private int size = 0;

    public TreeNode(int d) {
      data = d;
      size = 1;
    }

    public TreeNode getRandomNode() {
      int leftSize = left == null ? 0 : left.size();
      Random random = new Random();
      int index = random.nextInt(size);
      if (index < leftSize) return left.getRandomNode();
      else if (index == leftSize) return this;
      else return right.getRandomNode();
    }

    public void insertInOrder(int d) {
      if (d <= data)
        if (left == null) left = new TreeNode(d);
        else left.insertInOrder(d);
      else if (right == null) right = new TreeNode(d);
      else right.insertInOrder(d);
      size++;
    }

    public int size() {
      return size;
    }

    public int data() {
      return data;
    }

    public TreeNode find(int d) {
      if (d == data) return this;
      else if (d <= data) return left != null ? left.find(d) : null;
      else if (d > data) return right != null ? right.find(d) : null;
      return null;
    }

    public TreeNode getIthNode(int i) {
      int leftSize = left == null ? 0 : left.size();
      if (i < leftSize) return left.getIthNode(i);
      else if (i == leftSize) return this;
      else
        /* Skipping over leftSize + 1 nodes, so subtract them. */
        return right.getIthNode(i - (leftSize + 1));
    }
  }

  class Tree {
    TreeNode root = null;

    public int size() {
      return root == null ? 0 : root.size();
    }

    public TreeNode getRandomNode() {
      if (root == null) return null;
      Random random = new Random();
      int i = random.nextInt(size());
      return root.getIthNode(i);
    }

    public void insertInOrder(int value) {
      if (root == null) root = new TreeNode(value);
      else root.insertInOrder(value);
    }
  }
}
