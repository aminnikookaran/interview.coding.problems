package leetcode.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
public class Q395LongestSubstringWithAtLeastKRepeatingCharacters {
  public int longestSubstring2(String s, int k) {
    if (s == null || s.isEmpty() || k > s.length()) return 0;
    int[] countMap = new int[26];
    int n = s.length();
    int result = 0;
    for (int start = 0; start < n; start++) {
      // reset the count map
      Arrays.fill(countMap, 0);
      for (int end = start; end < n; end++) {
        countMap[s.charAt(end) - 'a']++;
        if (isValid(s, start, end, k, countMap)) result = Math.max(result, end - start + 1);
      }
    }
    return result;
  }

  private boolean isValid(String s, int start, int end, int k, int[] countMap) {
    int countLetters = 0, countAtLeastK = 0;
    for (int freq : countMap) {
      if (freq > 0) countLetters++;
      if (freq >= k) countAtLeastK++;
    }
    return countAtLeastK == countLetters;
  }

  public int longestSubstring3(String s, int k) {
    return longestSubstringUtil(s, 0, s.length(), k);
  }

  int longestSubstringUtil(String s, int start, int end, int k) {
    if (end < k) return 0;
    int[] countMap = new int[26];
    // update the countMap with the count of each character
    for (int i = start; i < end; i++) countMap[s.charAt(i) - 'a']++;
    for (int mid = start; mid < end; mid++) {
      if (countMap[s.charAt(mid) - 'a'] >= k) continue;
      int midNext = mid + 1;
      while (midNext < end && countMap[s.charAt(midNext) - 'a'] < k) midNext++;
      return Math.max(
          longestSubstringUtil(s, start, mid, k), longestSubstringUtil(s, midNext, end, k));
    }
    return (end - start);
  }

  public int longestSubstring4(String s, int k) {
    char[] str = s.toCharArray();
    int[] countMap = new int[26];
    int maxUnique = getMaxUniqueLetters(s);
    int result = 0;
    for (int currUnique = 1; currUnique <= maxUnique; currUnique++) {
      // reset countMap
      Arrays.fill(countMap, 0);
      int windowStart = 0, windowEnd = 0, idx = 0, unique = 0, countAtLeastK = 0;
      while (windowEnd < str.length) {
        // expand the sliding window
        if (unique <= currUnique) {
          idx = str[windowEnd] - 'a';
          if (countMap[idx] == 0) unique++;
          countMap[idx]++;
          if (countMap[idx] == k) countAtLeastK++;
          windowEnd++;
        }
        // shrink the sliding window
        else {
          idx = str[windowStart] - 'a';
          if (countMap[idx] == k) countAtLeastK--;
          countMap[idx]--;
          if (countMap[idx] == 0) unique--;
          windowStart++;
        }
        if (unique == currUnique && unique == countAtLeastK)
          result = Math.max(windowEnd - windowStart, result);
      }
    }

    return result;
  }

  // get the maximum number of unique letters in the string s
  int getMaxUniqueLetters(String s) {
    boolean map[] = new boolean[26];
    int maxUnique = 0;
    for (int i = 0; i < s.length(); i++) {
      if (!map[s.charAt(i) - 'a']) {
        maxUnique++;
        map[s.charAt(i) - 'a'] = true;
      }
    }
    return maxUnique;
  }

  public int longestSubstring5(String s, int k) {
    Map<Character, Integer> counter = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (counter.containsKey(c)) counter.put(c, counter.get(c) + 1);
      else counter.put(c, 1);
    }
    Set<Character> splitSet = new HashSet<>();
    for (char c : counter.keySet()) if (counter.get(c) < k) splitSet.add(c);
    if (splitSet.isEmpty()) return s.length();
    int max = 0;
    int i = 0, j = 0;
    while (j < s.length()) {
      char c = s.charAt(j);
      if (splitSet.contains(c)) {
        if (j != i) max = Math.max(max, longestSubstring5(s.substring(i, j), k));
        i = j + 1;
      }
      j++;
    }
    if (i != j) max = Math.max(max, longestSubstring5(s.substring(i, j), k));
    return max;
  }
}
