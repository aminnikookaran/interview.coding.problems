package problems.math;

import java.util.ArrayList;
import java.util.List;

public class AllFactorsProblem {
  public static ArrayList<Integer> allFactors(int A) {
    ArrayList<Integer> factors = new ArrayList<>();
    ArrayList<Integer> tempFactors = new ArrayList<>();
    for (int i = 1; i * i <= A; i++) {
      if (A % i == 0) {
        factors.add(i);
        if (A / i != i) tempFactors.add(A / i);
      }
    }
    for (int i = tempFactors.size() - 1; i >= 0; i--) factors.add(tempFactors.get(i));
    return factors;
  }

  public static void main(String[] args) {
    List<Integer> factors = allFactors(10000);
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < factors.size(); i++) {
      stringBuilder.append(factors.get(i)).append(" ");
    }
    System.out.println(stringBuilder.toString());
  }
}
