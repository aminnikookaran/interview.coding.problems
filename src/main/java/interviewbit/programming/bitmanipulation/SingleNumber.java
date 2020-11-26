package interviewbit.programming.bitmanipulation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SingleNumber {
  public static int singleNumber1(final List<Integer> A) {
    int number = 0;
    for (int i = 0; i < A.size(); i++) number ^= A.get(i);
    return number;
  }

  public static int singleNumber2(final List<Integer> A) {
    Map<Integer, Integer> counts = new HashMap<Integer, Integer>();

    for (Integer i : A) {
      Integer value = counts.get(i);
      counts.put(i, value == null ? 1 : value + 1);
    }

    for (Map.Entry<Integer, Integer> entry : counts.entrySet())
      if (entry.getValue() == 1) return entry.getKey();

    return -1;
  }
}
