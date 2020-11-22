package interviewbit.programming.math;

// https://www.interviewbit.com/problems/distribute-in-circle/
public class DistributeInCircle {
  public static int solve(int A, int B, int C) {
    int position = (C + A - 1) % B;
    if (position == 0) position = B;
    return position;
  }

  public static void main(String[] args) {
    System.out.println(solve(8, 5, 2));
  }
}
