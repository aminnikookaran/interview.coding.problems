package problems;

import static java.lang.String.valueOf;
import java.util.ArrayList;
import java.util.List;

public class SpiralMatrixProblem {
  public static List<List<Integer>> generate(int n) {
    List<List<Integer>> a = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      List<Integer> b = new ArrayList<>();
      for (int j = 0; j < n; j++) b.add(0);
      a.add(b);
    }

    int lastNumber = 1;
    for (int i = 0; i < n / 2; i++) {
      for (int j = i; j < n - i - 1; j++) {
        a.get(i).set(j, lastNumber + j);
        a.get(j).set(n - i - 1, lastNumber + (n - 2 * i - 1) + j);
        a.get(n - i - 1).set(n - j - 1, lastNumber + 2 * (n - 2 * i - 1) + j);
        a.get(n - j - 1).set(i, lastNumber + 3 * (n - 2 * i - 1) + j);
      }
      lastNumber += 4 * (n - 2 * i - 1) - i - 1;
    }

    return a;
  }

  public static void main(String[] args) {
    List<List<Integer>> a = generate(8);
    for (int i = 0; i < a.size(); i++) {
      StringBuilder stringBuilder = new StringBuilder();
      for (int j = 0; j < a.size(); j++) {
        stringBuilder.append(valueOf(j)).append(" ");
      }
      System.out.println(stringBuilder.toString());
    }
    System.out.println(-7/2); 
  }
}
