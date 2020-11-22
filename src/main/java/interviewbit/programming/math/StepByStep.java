package interviewbit.programming.math;

// https://www.interviewbit.com/problems/step-by-step/
public class StepByStep {
  public static int solve1(int A) {
    A = Math.abs(A);
    int i = 0;
    while (A > 0) A -= ++i;
    if (A % 2 == 0) return i;
    else if (i % 2 == 0) return i + 1;
    else return i + 2;
  }

  public static int solve2(int A) {
    int step = 0, total = 0;
    A = Math.abs(A);
    while (total < A || (total - A) % 2 != 0) {
      step += 1;
      total += step;
    }
    return step;
  }

  public static void main(String[] args) {
    System.out.println(solve1(1));
  }
}
