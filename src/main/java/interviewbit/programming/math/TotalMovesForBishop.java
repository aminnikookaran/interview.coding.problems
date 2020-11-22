package interviewbit.programming.math;

// https://www.interviewbit.com/problems/total-moves-for-bishop/
public class TotalMovesForBishop {
  public static int solve(int A, int B) {
    return Math.min(A - 1, B - 1)
        + Math.min(8 - A, B - 1)
        + Math.min(A - 1, 8 - B)
        + Math.min(8 - A, 8 - B);
  }

  public static void main(String[] args) {
    System.out.println(solve(4, 4));
  }
}
