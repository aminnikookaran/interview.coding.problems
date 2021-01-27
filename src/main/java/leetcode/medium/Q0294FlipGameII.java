package leetcode.medium;

// https://leetcode.com/problems/flip-game-ii/
public class Q0294FlipGameII {
  public boolean canWin(String s) {
    if (s == null || s.length() == 0) return false;
    return canWin(s.toCharArray());
  }

  private boolean canWin(char[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
      if (arr[i] == '+' && arr[i + 1] == '+') {
        arr[i] = '-';
        arr[i + 1] = '-';
        boolean otherWin = canWin(arr);
        arr[i] = '+';
        arr[i + 1] = '+';
        if (!otherWin) return true;
      }
    }
    return false;
  }
}
