package problems.math;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzzProblem {
  public static List<String> fizzBuzz(int A) {
    List<String> list = new ArrayList<>();
    for (int i = 1; i <= A; i++) {
      if (i % 3 == 0) {
        if (i % 5 == 0) list.add("FizzBuzz");
        else list.add("Fizz");
      } else if (i % 5 == 0) list.add("Buzz");
      else list.add(String.valueOf(i));
    }
    return list;
  }

  public static void main(String[] args) {
    List<String> list = fizzBuzz(25);
    StringBuilder stringBuilder = new StringBuilder();
    for (String string : list) stringBuilder.append(string).append("\t");
    System.out.println(stringBuilder);
  }
}
