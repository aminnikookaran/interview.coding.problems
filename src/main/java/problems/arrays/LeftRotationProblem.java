package problems.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeftRotationProblem { // Implement using less ram
  public static List<Integer> rotateLeft(int d, List<Integer> arr) {
    d %= arr.size();
    List<Integer> newArr = new ArrayList<>();
    for (int i = 0; i < arr.size(); i++) {
      int oldIndex = (i + d) % arr.size();
      newArr.add(arr.get(oldIndex));
    }
    return newArr;
  }

  public static void main(String[] args) {
    List<Integer> result = rotateLeft(4, Arrays.asList(new Integer[] {1, 2, 3, 4, 5}));
    StringBuilder stringBuilder = new StringBuilder();
    for (Integer integer : result) {
      stringBuilder.append(integer).append(" ");
    }
    System.out.println(stringBuilder);
    Integer.parseInt(String.valueOf("1".charAt(0)));
  }
}
