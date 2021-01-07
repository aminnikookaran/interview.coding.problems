package leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/design-add-and-search-words-data-structure/
public class Q0211DesignAddAndSearchWordsDataStructure {
  class WordDictionary1 {
    private static final int R = 26;
    private Node root;

    private class Node {
      boolean isEnd = false;
      Node[] next = new Node[R];
    }

    /** Initialize your data structure here. */
    public WordDictionary1() {
      root = new Node();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
      root = insert(word, root, 0);
    }

    private Node insert(String word, Node x, int d) {
      if (x == null) x = new Node();
      if (d == word.length()) {
        x.isEnd = true;
        return x;
      }
      char c = word.charAt(d);
      x.next[c - 'a'] = insert(word, x.next[c - 'a'], d + 1);
      return x;
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to
     * represent any one letter.
     */
    public boolean search(String word) {
      return search(word, root, 0);
    }

    private boolean search(String pat, Node x, int d) {
      if (x == null) return false;
      if (d == pat.length()) return x.isEnd;
      char next = pat.charAt(d);
      char start = next == '.' ? 'a' : next;
      char end = next == '.' ? 'z' : next;
      for (char c = start; c <= end; c++) if (search(pat, x.next[c], d + 1)) return true;
      return false;
    }
  }

  class WordDictionary2 {
    Map<Integer, List<String>> map = new HashMap<>();

    public void addWord(String word) {
      int index = word.length();
      if (!map.containsKey(index)) {
        List<String> list = new ArrayList<>();
        list.add(word);
        map.put(index, list);
      } else {
        map.get(index).add(word);
      }
    }

    public boolean search(String word) {
      int index = word.length();
      if (!map.containsKey(index)) {
        return false;
      }

      List<String> list = map.get(index);
      for (String s : list) {
        if (isSame(s, word)) { // when word has '.'
          return true;
        }
      }
      return false;
    }

    public boolean isSame(String s, String word) { // word has '.'
      for (int i = 0; i < s.length(); i++) {
        if (word.charAt(i) != '.' && s.charAt(i) != word.charAt(i)) {
          return false;
        }
      }
      return true;
    }
  }
}
