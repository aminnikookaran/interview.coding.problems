package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class CountingTriangles {

  class Sides {
    int a;
    int b;
    int c;

    int getA() {
      return this.a;
    }

    Sides(int a, int b, int c) {
      this.a = a;
      this.b = b;
      this.c = c;
    }
  }

  // Add any helper functions you may need here
  boolean isSameTriangle(Sides a, Sides b) {
    return (a.a == b.a && a.b == b.b && a.c == b.c);
  }

  int countDistinctTriangles(ArrayList<Sides> arr) {
    // Write your code here
    int[] lengths = new int[3];
    for (int i = 0; i < arr.size(); i++) {
      lengths[0] = arr.get(i).a;
      lengths[1] = arr.get(i).b;
      lengths[2] = arr.get(i).c;
      Arrays.sort(lengths);
      arr.get(i).a = lengths[0];
      arr.get(i).b = lengths[1];
      arr.get(i).c = lengths[2];
    }

    //    Collections.sort(
    //        arr,
    //        new Comparator<Sides>() {
    //          public int compare(Sides o1, Sides o2) {
    //            int ca = Integer.compare(o1.a, o2.a);
    //            int cb = Integer.compare(o1.b, o2.b);
    //            int cc = Integer.compare(o1.c, o2.c);
    //            if (ca == 0) {
    //              if (cb == 0) {
    //                return cc;
    //              } else return cb;
    //            } else return ca;
    //          };
    //        });

    Collections.sort(
        arr,
        Comparator.comparing((Sides sides) -> sides.a)
            .thenComparing((Sides sides) -> sides.b)
            .thenComparing((Sides sides) -> sides.c));

    int count = arr.size();
    for (int i = 1; i < arr.size(); i++) if (isSameTriangle(arr.get(i), arr.get(i - 1))) count--;
    return count;
  }

  // These are the tests we use to determine if the solution is correct.
  // You can add your own at the bottom, but they are otherwise not editable!
  int test_case_number = 1;

  void check(int expected, int output) {
    boolean result = (expected == output);
    char rightTick = '\u2713';
    char wrongTick = '\u2717';
    if (result) {
      System.out.println(rightTick + " Test #" + test_case_number);
    } else {
      System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
      printInteger(expected);
      System.out.print(" Your output: ");
      printInteger(output);
      System.out.println();
    }
    test_case_number++;
  }

  void printInteger(int n) {
    System.out.print("[" + n + "]");
  }

  public void run() {
    ArrayList<Sides> arr_1 = new ArrayList<>();
    arr_1.add(new Sides(7, 6, 5));
    arr_1.add(new Sides(5, 7, 6));
    arr_1.add(new Sides(8, 2, 9));
    arr_1.add(new Sides(2, 3, 4));
    arr_1.add(new Sides(2, 4, 3));
    int expected_1 = 3;
    int output_1 = countDistinctTriangles(arr_1);
    check(expected_1, output_1);

    ArrayList<Sides> arr_2 = new ArrayList<>();
    arr_2.add(new Sides(3, 4, 5));
    arr_2.add(new Sides(8, 8, 9));
    arr_2.add(new Sides(7, 7, 7));
    int expected_2 = 3;
    int output_2 = countDistinctTriangles(arr_2);
    check(expected_2, output_2);

    // Add your own test cases here

  }

  public static void main(String[] args) {
    new CountingTriangles().run();
  }
}
