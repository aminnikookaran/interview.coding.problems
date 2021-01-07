package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/repeated-dna-sequences/
public class Q0187RepeatedDNASequences {
  public List<String> findRepeatedDnaSequences1(String s) {
    Set<String> seen = new HashSet<>(), repeated = new HashSet<>();
    for (int i = 0; i + 9 < s.length(); i++) {
      String ten = s.substring(i, i + 10);
      if (!seen.add(ten)) repeated.add(ten);
    }
    return new ArrayList<>(repeated);
  }

  public List<String> findRepeatedDnaSequences2(String s) {
    List<String> result = new ArrayList<>();
    Set<Integer> word = new HashSet<>();
    Set<Integer> secondWord = new HashSet<>();
    int[] map = new int[26];
    map['C' - 'A'] = 1;
    map['G' - 'A'] = 2;
    map['T' - 'A'] = 3;
    int value = 0;
    for (int i = 0; i < s.length(); i++) {
      value <<= 2;
      value |= map[s.charAt(i) - 'A'];
      value &= 0xfffff;
      if (i < 9) continue;
      if (!word.add(value) && secondWord.add(value)) result.add(s.substring(i - 9, i + 1));
    }
    return result;
  }

  public List<String> findRepeatedDnaSequences(String s) {
    Map<Character, Integer> A = new HashMap<>();
    A.put('A', 0);
    A.put('C', 1);
    A.put('G', 2);
    A.put('T', 3);
    int A_SIZE_POW_9 = (int) Math.pow(A.size(), 9);

    Set<String> res = new HashSet<>();
    Set<Integer> hashes = new HashSet<>();
    for (int i = 0, rhash = 0; i < s.length(); i++) {
      if (i > 9) rhash -= A_SIZE_POW_9 * A.get(s.charAt(i - 10));
      rhash = A.size() * rhash + A.get(s.charAt(i));
      if (i > 8 && !hashes.add(rhash)) res.add(s.substring(i - 9, i + 1));
    }
    return new ArrayList<>(res);
  }
}
