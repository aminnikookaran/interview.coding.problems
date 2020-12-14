package problems;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class QueueRemovals {

  // Add any helper functions you may need here
  class Pair {
    int index;
    int value;

    public Pair(int index, int value) {
      this.index = index;
      this.value = value;
    }
  }

  int[] findPositions(int[] arr, int x) {
    // Write your code here
    List<Integer> result = new ArrayList<>();
    Deque<Pair> deque = new ArrayDeque<>();
    for (int i = 0; i < arr.length; i++) deque.add(new Pair(i + 1, arr[i]));
    for (int i = 0; i < x; i++) {
      Deque<Pair> temp = new ArrayDeque<>();
      int max = 0;
      int size = deque.size();
      for (int j = 0; j < x && j < size; j++) {
        Pair pair = deque.poll();
        if (pair.value > max) max = pair.value;
        temp.add(pair);
      }
      while (!temp.isEmpty()) {
        Pair pair = temp.poll();
        if (pair.value == max) {
          result.add(pair.index);
          max = -1;
        } else if (pair.value == 0) {
          deque.add(pair);
        } else {
          pair.value--;
          deque.add(pair);
        }
      }
    }
    int[] output = new int[result.size()];
    for (int i = 0; i < output.length; i++) {
      output[i] = result.get(i);
    }
    return output;
  }

  // These are the tests we use to determine if the solution is correct.
  // You can add your own at the bottom, but they are otherwise not editable!
  int test_case_number = 1;

  void check(int[] expected, int[] output) {
    int expected_size = expected.length;
    int output_size = output.length;
    boolean result = true;
    if (expected_size != output_size) {
      result = false;
    }
    for (int i = 0; i < Math.min(expected_size, output_size); i++) {
      result &= (output[i] == expected[i]);
    }
    char rightTick = '\u2713';
    char wrongTick = '\u2717';
    if (result) {
      System.out.println(rightTick + " Test #" + test_case_number);
    } else {
      System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
      printIntegerArray(expected);
      System.out.print(" Your output: ");
      printIntegerArray(output);
      System.out.println();
    }
    test_case_number++;
  }

  void printIntegerArray(int[] arr) {
    int len = arr.length;
    System.out.print("[");
    for (int i = 0; i < len; i++) {
      if (i != 0) {
        System.out.print(", ");
      }
      System.out.print(arr[i]);
    }
    System.out.print("]");
  }

  public void run() {
    //    int n_1 = 6;
    int x_1 = 5;
    int[] arr_1 = {1, 2, 2, 3, 4, 5};
    int[] expected_1 = {5, 6, 4, 1, 2};
    int[] output_1 = findPositions(arr_1, x_1);
    check(expected_1, output_1);

    //    int n_2 = 13;
    int x_2 = 4;
    int[] arr_2 = {2, 4, 2, 4, 3, 1, 2, 2, 3, 4, 3, 4, 4};
    int[] expected_2 = {2, 5, 10, 13};
    int[] output_2 = findPositions(arr_2, x_2);
    check(expected_2, output_2);

    // Add your own test cases here

  }

  public static void main(String[] args) {
    new QueueRemovals().run();
  }
}
