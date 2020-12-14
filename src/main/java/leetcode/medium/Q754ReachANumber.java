package leetcode.medium;

// https://leetcode.com/problems/reach-a-number/
public class Q754ReachANumber {
  public static int reachNumber1(int target) {
    target = Math.abs(target);
    int i = 0;
    while (target > 0) target -= ++i;
    if (target % 2 == 0) return i;
    else if (i % 2 == 0) return i + 1;
    else return i + 2;
  }

  public static int reachNumber2(int target) {
    target = Math.abs(target);
    int k = 0;
    while (target > 0) target -= ++k;
    return target % 2 == 0 ? k : k + 1 + k % 2;
  }

  public static void main(String[] args) {
    System.out.println(reachNumber1(1));
  }
}
