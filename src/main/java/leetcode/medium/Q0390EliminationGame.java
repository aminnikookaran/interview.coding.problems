package leetcode.medium;

// https://leetcode.com/problems/elimination-game/
public class Q0390EliminationGame {
  public int lastRemaining1(int n) {
    boolean left = true;
    int remaining = n;
    int step = 1;
    int head = 1;
    while (remaining > 1) {
      if (left || remaining % 2 == 1) head = head + step;
      remaining = remaining / 2;
      step = step * 2;
      left = !left;
    }
    return head;
  }

  public int lastRemaining2(int n) {
    return leftToRight(n);
  }

  // eliminate [1...n] first from left to right, then alternate
  private int leftToRight(int n) {
    if (n == 1) return 1;
    // scan from left to right is simple, the length of array doesn't matter
    // [1, 2, 3, 4] -> 2 * [1, 2]
    // [1, 2, 3, 4, 5] -> 2 * [1, 2]
    return 2 * rightToLeft(n / 2);
  }

  // eliminate [1...n] first from right to left, then alternate
  private int rightToLeft(int n) {
    if (n == 1) return 1;
    // if the length of array is even, we will get only odd number
    // [1, 2, 3, 4] -> [1, 3] = 2 * [1, 2] - 1
    if (n % 2 == 0) return 2 * leftToRight(n / 2) - 1;
    // else if the length of array is odd, we will get only even number
    // [1, 2, 3, 4, 5] -> [2, 4] = 2 * [1, 2]
    else return 2 * leftToRight(n / 2);
  }
}
