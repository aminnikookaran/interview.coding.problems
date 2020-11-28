package hackerrank.datastructures.dictionariesandhashmaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://www.hackerrank.com/challenges/frequency-queries/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=dictionaries-hashmaps
public class FrequencyQueries {
  public static List<Integer> freqQuery1(List<List<Integer>> queries) {
    List<Integer> result = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();
    Map<Integer, Integer> map2 = new HashMap<>();
    for (List<Integer> list : queries) {
      Integer key = list.get(0);
      Integer value = list.get(1);
      switch (key) {
        case 1:
          Integer count1st = map.get(value);
          if (count1st == null) {
            map.put(value, 1);
            Integer count2 = map2.get(1);
            map2.put(1, count2 == null ? 1 : count2 + 1);
          } else {
            map.put(value, count1st + 1);

            Integer count1 = map2.get(count1st);
            if (count1 == 1) map2.remove(count1st);
            else map2.put(count1st, count1 - 1);

            Integer count2 = map2.get(count1st + 1);
            map2.put(count1st + 1, count2 == null ? 1 : count2 + 1);
          }
          break;
        case 2:
          Integer count2nd = map.get(value);
          if (count2nd != null) {
            if (count2nd == 1) {
              map.remove(value);
              Integer count2 = map2.get(1);
              if (count2 == 1) map2.remove(1);
              else map2.put(1, count2 - 1);
            } else {
              map.put(value, count2nd - 1);

              Integer count1 = map2.get(count2nd);
              if (count1 == 1) map2.remove(count2nd);
              else map2.put(count2nd, count1 - 1);

              Integer count2 = map2.get(count2nd - 1);
              map2.put(count2nd - 1, count2 == null ? 1 : count2 + 1);
            }
          }
          break;
        default:
          Integer count3rd = map2.get(value);
          if (count3rd != null || value == 0) result.add(1);
          else result.add(0);
          break;
      }
    }
    return result;
  }

  public static List<Integer> freqQuery2(List<List<Integer>> queries) {
    final Map<Integer, Integer> valueToFreq = new HashMap<>();
    final Map<Integer, Integer> freqToOccurrence = new HashMap<>();
    final List<Integer> frequencies = new ArrayList<>();

    int key;
    int value;
    Integer oldFreq;
    Integer newFreq;
    Integer oldOccurrence;
    Integer newOccurrence;
    for (List<Integer> query : queries) {
      key = query.get(0);
      value = query.get(1);
      if (key == 3) {
        if (value == 0 || freqToOccurrence.get(value) != null) frequencies.add(1);
        else frequencies.add(0);
      } else {
        oldFreq = valueToFreq.get(value);
        oldFreq = oldFreq == null ? 0 : oldFreq;
        oldOccurrence = freqToOccurrence.get(oldFreq);
        oldOccurrence = oldOccurrence == null ? 0 : oldOccurrence;

        if (key == 1) newFreq = oldFreq + 1;
        else newFreq = oldFreq - 1;

        newOccurrence = freqToOccurrence.get(newFreq);
        newOccurrence = newOccurrence == null ? 0 : newOccurrence;

        if (newFreq < 1) valueToFreq.remove(value);
        else valueToFreq.put(value, newFreq);

        if ((oldOccurrence - 1) < 1) freqToOccurrence.remove(oldFreq);
        else freqToOccurrence.put(oldFreq, oldOccurrence - 1);

        freqToOccurrence.put(newFreq, newOccurrence + 1);
      }
    }
    return frequencies;
  }
}
