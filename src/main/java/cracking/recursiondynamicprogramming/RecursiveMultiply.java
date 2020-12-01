package cracking.recursiondynamicprogramming;

public class RecursiveMultiply {
  public static int minProduct1(int a, int b) {
    int bigger = a < b ? b : a;
    int smaller = a < b ? a : b;
    return minProductHelper1(smaller, bigger);
  }

  public static int minProductHelper1(int smaller, int bigger) {
    if (smaller == 0) return 0;
    else if (smaller == 1) return bigger;

    /* Compute half. If uneven, compute other half. If even, double it. */
    int s = smaller >> 1; // Divide by 2
    int sidel = minProductHelper1(s, bigger);
    int side2 = sidel;
    if (smaller % 2 == 1) side2 = minProductHelper1(smaller - s, bigger);

    return sidel + side2;
  }

  int minProduct2(int a, int b) {
    int bigger = a < b ? b : a;
    int smaller = a < b ? a : b;
    int memo[] = new int[smaller + 1];
    return minProduct2(smaller, bigger, memo);
  }

  int minProduct2(int smaller, int bigger, int[] memo) {
    if (smaller == 0) return 0;
    else if (smaller == 1) return bigger;
    else if (memo[smaller] > 0) return memo[smaller];

    /* Compute half. If uneven, compute other half. If even, double it. */
    int s = smaller >> 1; // Divide by 2
    int sidel = minProduct2(s, bigger, memo); // Compute half
    int side2 = sidel;
    if (smaller % 2 == 1) side2 = minProduct2(smaller - s, bigger, memo);

    /* Sum and cache.*/
    memo[smaller] = sidel + side2;
    return memo[smaller];
  }

  public static int minProduct3(int a, int b) {
    int bigger = a < b ? b : a;
    int smaller = a < b ? a : b;
    return minProductHelper3(smaller, bigger);
  }

  public static int minProductHelper3(int smaller, int bigger) {
    if (smaller == 0) return 0;
    else if (smaller == 1) return bigger;

    int s = smaller >> 1; // Divide by 2
    int halfProd = minProductHelper3(s, bigger);

    if (smaller % 2 == 0) return halfProd + halfProd;
    else return halfProd + halfProd + bigger;
  }

  public static void main(String[] args) {
    System.out.println(minProduct3(3, 4));
  }
}
