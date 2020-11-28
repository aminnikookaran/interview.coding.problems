package hackerrank.datastructures.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://www.hackerrank.com/challenges/array-left-rotation/problem
public class LeftRotation { // Implement using less ram
  public static List<Integer> rotateLeft(int d, List<Integer> arr) {
    d %= arr.size();
    List<Integer> newArr = new ArrayList<>();
    for (int i = 0; i < arr.size(); i++) {
      int oldIndex = (i + d) % arr.size();
      newArr.add(arr.get(oldIndex));
    }
    return newArr;
  }

  // https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=arrays
  public static int[] rotLeft(int[] a, int d) {
    int[] b = new int[a.length];
    for (int i = 0; i < a.length; i++) b[i] = a[(i + d) % a.length];
    return b;
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
