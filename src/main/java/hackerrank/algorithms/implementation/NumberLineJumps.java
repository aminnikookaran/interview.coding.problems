package hackerrank.algorithms.implementation;

// https://www.hackerrank.com/challenges/kangaroo/problem
public class NumberLineJumps {
  public static String kangaroo(int x1, int v1, int x2, int v2) {
    if (v1 == v2)
      if (x1 == x2) return "YES";
      else return "NO";
    if (((x1 - x2) / (v2 - v1) > 0) && ((x1 - x2) % (v2 - v1) == 0)) return "YES";
    else return "NO";
  }

  public static void main(String[] args) {
    System.out.println(kangaroo(0, 3, 4, 2));
  }
}
