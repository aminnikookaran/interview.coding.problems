package interviewbit.programming.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://www.interviewbit.com/problems/wave-array/
public class WaveArray {
  public static List<Integer> wave1(List<Integer> A) {
    Collections.sort(A);
    List<Integer> B = new ArrayList<>();
    for (int i = 0; i < A.size() / 2; i++) {
      B.add(A.get(2 * i + 1));
      B.add(A.get(2 * i));
    }
    if ((A.size() / 2) * 2 < A.size()) B.add(A.get(A.size() - 1));
    return B;
  }

  public List<Integer> wave2(List<Integer> a) {
    Collections.sort(a);
    for (int i = 0; i < a.size() - 1; i = i + 2) {
      int temp = a.get(i);
      a.set(i, a.get(i + 1));
      a.set(i + 1, temp);
    }
    return a;
  }

  public static void main(String[] args) {}
}
