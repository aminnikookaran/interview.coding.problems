package leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

// https://leetcode.com/problems/remove-duplicate-letters/
public class Q0316RemoveDuplicateLetters {
  public String removeDuplicateLetters1(String s) {
    int[] last = new int[26];
    for (int i = 0; i < s.length(); ++i) last[s.charAt(i) - 'a'] = i;

    boolean[] seen = new boolean[26];
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < s.length(); ++i) {
      int c = s.charAt(i) - 'a';
      if (seen[c]) continue;
      while (!stack.isEmpty() && stack.peek() > c && i < last[stack.peek()])
        seen[stack.pop()] = false;
      stack.push(c);
      seen[c] = true;
    }

    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) sb.append(stack.pop());
    return sb.reverse().toString();
  }

  public String removeDuplicateLetters2(String s) {
    // character frequency
    int[] count = new int[26];
    for (char c : s.toCharArray()) count[c - 'a']++;

    // to keep track of visited character so that we don't use them if present in answer
    boolean[] visited = new boolean[26];

    // Stack store resulting characters
    Stack<Character> stack = new Stack<>();
    // traverse through string and add characters
    for (char c : s.toCharArray()) {
      // Decrement the frequency of character since we are using it in answer
      // !!! We have decrement the character frequency before checking it is visited
      count[c - 'a']--;

      // if already present in stack we don't need the character
      if (visited[c - 'a']) continue;

      // traverse through the stack and check for larger characters
      // if found and it is not the last position then pop from stack
      // Eg: bcabc => if stack has bc, now a<b and curr b is not the last one
      // if not in last position come out of loop and add curr character to stack
      while (!stack.isEmpty() && c < stack.peek() && count[stack.peek() - 'a'] > 0) {
        // make the current character available for next operations
        visited[stack.pop() - 'a'] = false;
      }
      // add curr character to string
      stack.push(c);
      // mark it as visited
      visited[c - 'a'] = true;
    }

    // Now characters are in reverse order in stack
    // Use StringBuilder instead of String for storing result
    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) sb.append(stack.pop());
    return sb.reverse().toString();
  }

  public String removeDuplicateLetters3(String text) {
    char[] arr = text.toCharArray();
    Map<Character, Integer> map = new HashMap<>();
    for (char c : arr) map.put(c, map.getOrDefault(c, 0) + 1);

    Set<Character> seen = new HashSet<>();
    Stack<Character> stack = new Stack<>();
    for (char c : arr) {
      // we have seen this char
      map.put(c, map.get(c) - 1);
      if (seen.contains(c)) continue;

      // if the top char is larger than current char, we should remove it
      while (!stack.isEmpty() && stack.peek() > c && map.get(stack.peek()) > 0)
        seen.remove(stack.pop());

      stack.push(c);
      seen.add(c);
    }

    StringBuilder sb = new StringBuilder();
    while (!stack.isEmpty()) sb.append(stack.pop());
    return sb.reverse().toString();
  }
}
