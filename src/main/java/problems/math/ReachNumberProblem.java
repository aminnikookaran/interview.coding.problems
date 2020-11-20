package problems.math;

public class ReachNumberProblem {
  public static int solve(int A) {
    A = Math.abs(A);
    int i = 0;
    while (A > 0) A -= ++i;
    if (A % 2 == 0) return i;
    else if (i % 2 == 0) return i + 1;
    else return i + 2;
  }

  public static void main(String[] args) {
    System.out.println(solve(1));
  }
}
