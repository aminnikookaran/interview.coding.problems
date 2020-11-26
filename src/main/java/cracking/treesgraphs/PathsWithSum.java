package cracking.treesgraphs;

import java.util.HashMap;

public class PathsWithSum {
  public static int countPathsWithSum1(TreeNode root, int targetSum) {
    if (root == null) return 0;
    /* Count paths with sum starting from the root. */
    int pathsFromRoot = countPathsWithSumFromNode(root, targetSum, 0);
    /* Try the nodes on the left and right. */
    int pathsOnLeft = countPathsWithSum1(root.left, targetSum);
    int pathsOnRight = countPathsWithSum1(root.right, targetSum);
    return pathsFromRoot + pathsOnLeft + pathsOnRight;
  }

  /* Returns the number of paths with this sum starting from this node. */
  public static int countPathsWithSumFromNode(TreeNode node, int targetSum, int currentSum) {
    if (node == null) return 0;
    currentSum += node.data;
    int totalPaths = 0;
    if (currentSum == targetSum) totalPaths++; // Found a path from the root
    totalPaths += countPathsWithSumFromNode(node.left, targetSum, currentSum);
    totalPaths += countPathsWithSumFromNode(node.right, targetSum, currentSum);
    return totalPaths;
  }

  public static int countPathsWithSum2(TreeNode root, int targetSum) {
    return countPathsWithSum2(root, targetSum, 0, new HashMap<Integer, Integer>());
  }

  public static int countPathsWithSum2(
      TreeNode node, int targetSum, int runningSum, HashMap<Integer, Integer> pathCount) {
    if (node == null) return 0; // Base case

    /* Count paths with sum ending at the current node. */
    runningSum += node.data;
    int sum = runningSum - targetSum;
    int totalPaths = pathCount.getOrDefault(sum, 0);

    /* If runningSum equals targetSum, then one additional path starts at root.
     * Add in this path.*/
    if (runningSum == targetSum) totalPaths++;

    /* Increment pathCount, recurse, then decrement pathCount. */
    incrementHashTable(pathCount, runningSum, 1); // Increment pathCount
    totalPaths += countPathsWithSum2(node.left, targetSum, runningSum, pathCount);
    totalPaths += countPathsWithSum2(node.right, targetSum, runningSum, pathCount);
    incrementHashTable(pathCount, runningSum, -1); // Decrement pathCount

    return totalPaths;
  }

  public static void incrementHashTable(HashMap<Integer, Integer> hashTable, int key, int delta) {
    int newCount = hashTable.getOrDefault(key, 0) + delta;
    if (newCount == 0) // Remove when zero to reduce space usage
    hashTable.remove(key);
    else hashTable.put(key, newCount);
  }

  public static void main(String[] args) {
    TreeNode node = new TreeNode(10);
    node.left = new TreeNode(5);
    node.right = new TreeNode(-3);
    node.left.left = new TreeNode(3);
    node.left.right = new TreeNode(2);
    node.right.right = new TreeNode(11);
    node.left.left.left = new TreeNode(3);
    node.left.left.right = new TreeNode(-2);
    node.left.right.right = new TreeNode(1);
    countPathsWithSum2(node, 8);
  }
}
