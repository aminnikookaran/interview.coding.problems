package cracking.sortingsearching;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MissingInt {
  long numberOfInts = ((long) Integer.MAX_VALUE) + 1;
  byte[] bitfield = new byte[(int) (numberOfInts / 8)];
  String filename = "";

  void findOpenNumber() throws FileNotFoundException {
    Scanner in = new Scanner(new FileReader(filename));
    while (in.hasNextInt()) {
      int n = in.nextInt();
      /* Finds the corresponding number in the bitfield by using the OR operator to
       * set the nth bit of a byte (e.g., 10 would correspond to the 2nd bit of
       * index 2 in the byte array). */
      bitfield[n / 8] |= 1 << (n % 8);
    }

    for (int i = 0; i < bitfield.length; i++) {
      for (int j = 0; j < 8; j++) {
        /* Retrieves the individual bits of each byte. When 0 bit is found, print
         * the corresponding value. */
        if ((bitfield[i] & (1 << j)) == 0) {
          System.out.println(i * 8 + j);
          return;
        }
      }
    }
  }

  public static void main(String[] args) {
    int[] arr = new int[] {3, 4, 1, 6, 2};
    int[] output = new int[arr.length];
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < arr.length; i++) map.put(arr[i], i);
    for (int i = 0; i < arr.length; i++) {
      Integer index1 = map.get(arr[i] + 1);
      Integer index2 = map.get(arr[i] + 2);
      int start = 0, end = arr.length;
      if (index1 != null) {
        if (index1 < i) start = index1;
        else end = index1;
      }
      if (index2 != null) {
        if (index2 < i) start = Math.max(start, index2);
        else end = Math.min(end, index2);
      }
      output[i] = end - start;
    }
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < output.length; i++) stringBuilder.append(output[i] + " ");
    System.out.println(stringBuilder);
  }
}
