package leetcode.medium;

import java.util.ArrayDeque;
import java.util.Deque;

// https://leetcode.com/problems/jump-game/
public class Q0055JumpGame {
  public boolean canJump1(int[] nums) {
    if (nums == null || nums.length == 0) return true;
    boolean[] seen = new boolean[nums.length];
    Deque<Integer> deque = new ArrayDeque<>();
    deque.add(0);
    seen[0] = true;
    while (!deque.isEmpty()) {
      Integer index = deque.poll();
      if (index == nums.length - 1) return true;
      for (int i = Math.min(index + nums[index], nums.length - 1);
          i > index && i < nums.length;
          i--) {
        if (!seen[i]) {
          deque.add(i);
          seen[i] = true;
        }
      }
    }
    return false;
  }

  public boolean canJumpFromPosition1(int position, int[] nums) {
    if (position == nums.length - 1) return true;
    int furthestJump = Math.min(position + nums[position], nums.length - 1);
    for (int nextPosition = furthestJump; nextPosition > position; nextPosition--)
      if (canJumpFromPosition1(nextPosition, nums)) return true;
    return false;
  }

  public boolean canJump2(int[] nums) {
    return canJumpFromPosition1(0, nums);
  }

  enum Index {
    GOOD,
    BAD,
    UNKNOWN
  }

  Index[] memo;

  public boolean canJumpFromPosition2(int position, int[] nums) {
    if (memo[position] != Index.UNKNOWN) return memo[position] == Index.GOOD ? true : false;
    int furthestJump = Math.min(position + nums[position], nums.length - 1);
    for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++)
      if (canJumpFromPosition2(nextPosition, nums)) {
        memo[position] = Index.GOOD;
        return true;
      }
    memo[position] = Index.BAD;
    return false;
  }

  public boolean canJump3(int[] nums) {
    memo = new Index[nums.length];
    for (int i = 0; i < memo.length; i++) memo[i] = Index.UNKNOWN;
    memo[memo.length - 1] = Index.GOOD;
    return canJumpFromPosition2(0, nums);
  }

  public boolean canJump4(int[] nums) {
    Index[] memo = new Index[nums.length];
    for (int i = 0; i < memo.length; i++) memo[i] = Index.UNKNOWN;
    memo[memo.length - 1] = Index.GOOD;
    for (int i = nums.length - 2; i >= 0; i--) {
      int furthestJump = Math.min(i + nums[i], nums.length - 1);
      for (int j = i + 1; j <= furthestJump; j++)
        if (memo[j] == Index.GOOD) {
          memo[i] = Index.GOOD;
          break;
        }
    }
    return memo[0] == Index.GOOD;
  }

  public boolean canJump5(int[] nums) {
    int lastPos = nums.length - 1;
    for (int i = nums.length - 1; i >= 0; i--) if (i + nums[i] >= lastPos) lastPos = i;
    return lastPos == 0;
  }
}
