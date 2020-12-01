package cracking.recursiondynamicprogramming;

public class TripleStep {
  public static int function(int n) {
    int[] memo = new int[n];
    return function(n, memo);
  }

  public static int function(int n, int[] memo) {
    if (n < 0) return 0;
    if (n == 0) return 1;
    if (memo[n - 1] == 0)
      memo[n - 1] = function(n - 1, memo) + function(n - 2, memo) + function(n - 3, memo);
    return memo[n - 1];
  }

  public static void main(String[] args) {
    int n = 30;
    long time = System.currentTimeMillis();
    System.out.println(function(n));
    System.out.println(System.currentTimeMillis() - time);
  }
}
