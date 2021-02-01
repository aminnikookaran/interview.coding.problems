package leetcode.easy;

// https://leetcode.com/problems/longest-common-prefix/
public class Q0014LongestCommonPrefix {
  public String longestCommonPrefix1(String[] strs) {
    if (strs == null || strs.length == 0) return "";
    String common = strs[0];
    for (int i = 1; i < strs.length; i++) {
      int j = 0;
      while (j < Math.min(common.length(), strs[i].length())) {
        if (common.charAt(j) != strs[i].charAt(j)) break;
        j++;
      }
      if (j == 0) return "";
      common = common.substring(0, j);
    }
    return common;
  }

  public String longestCommonPrefix2(String[] strs) {
    if (strs == null || strs.length == 0) return "";
    for (int i = 0; i < strs[0].length(); i++) {
      char c = strs[0].charAt(i);
      for (int j = 1; j < strs.length; j++)
        if (i == strs[j].length() || strs[j].charAt(i) != c) return strs[0].substring(0, i);
    }
    return strs[0];
  }

  public String longestCommonPrefix3(String[] strs) {
    if (strs == null || strs.length == 0) return "";
    return longestCommonPrefix3(strs, 0, strs.length - 1);
  }

  private String longestCommonPrefix3(String[] strs, int l, int r) {
    if (l == r) return strs[l];
    else {
      int mid = (l + r) / 2;
      String lcpLeft = longestCommonPrefix3(strs, l, mid);
      String lcpRight = longestCommonPrefix3(strs, mid + 1, r);
      return commonPrefix(lcpLeft, lcpRight);
    }
  }

  String commonPrefix(String left, String right) {
    int min = Math.min(left.length(), right.length());
    for (int i = 0; i < min; i++)
      if (left.charAt(i) != right.charAt(i)) return left.substring(0, i);
    return left.substring(0, min);
  }

  public String longestCommonPrefix4(String[] strs) {
    if (strs == null || strs.length == 0) return "";
    int minLen = Integer.MAX_VALUE;
    for (String str : strs) minLen = Math.min(minLen, str.length());
    int low = 1;
    int high = minLen;
    while (low <= high) {
      int middle = (low + high) / 2;
      if (isCommonPrefix(strs, middle)) low = middle + 1;
      else high = middle - 1;
    }
    return strs[0].substring(0, (low + high) / 2);
  }

  private boolean isCommonPrefix(String[] strs, int len) {
    String str1 = strs[0].substring(0, len);
    for (int i = 1; i < strs.length; i++) if (!strs[i].startsWith(str1)) return false;
    return true;
  }

  public String longestCommonPrefix5(String q, String[] strs) {
    if (strs == null || strs.length == 0) return "";
    if (strs.length == 1) return strs[0];
    Trie trie = new Trie();
    for (int i = 1; i < strs.length; i++) trie.insert(strs[i]);
    return trie.searchLongestPrefix(q);
  }

  class TrieNode {
    // R links to node children
    private TrieNode[] links;
    private final int R = 26;
    private boolean isEnd;
    // number of children non null links
    private int size;

    public TrieNode() {
      links = new TrieNode[R];
    }

    public boolean containsKey(char ch) {
      return links[ch - 'a'] != null;
    }

    public TrieNode get(char ch) {
      return links[ch - 'a'];
    }

    public void put(char ch, TrieNode node) {
      links[ch - 'a'] = node;
      size++;
    }

    public void setEnd() {
      isEnd = true;
    }

    public boolean isEnd() {
      return isEnd;
    }

    public int getLinks() {
      return size;
    }
  }

  public class Trie {
    private TrieNode root;

    public Trie() {
      root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
      TrieNode node = root;
      for (int i = 0; i < word.length(); i++) {
        char currentChar = word.charAt(i);
        if (!node.containsKey(currentChar)) node.put(currentChar, new TrieNode());
        node = node.get(currentChar);
      }
      node.setEnd();
    }

    // search a prefix or whole key in trie and
    // returns the node where search ends
    private TrieNode searchPrefix(String word) {
      TrieNode node = root;
      for (int i = 0; i < word.length(); i++) {
        char curLetter = word.charAt(i);
        if (node.containsKey(curLetter)) node = node.get(curLetter);
        else return null;
      }
      return node;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
      TrieNode node = searchPrefix(word);
      return node != null && node.isEnd();
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
      TrieNode node = searchPrefix(prefix);
      return node != null;
    }

    private String searchLongestPrefix(String word) {
      TrieNode node = root;
      StringBuilder prefix = new StringBuilder();
      for (int i = 0; i < word.length(); i++) {
        char curLetter = word.charAt(i);
        if (node.containsKey(curLetter) && (node.getLinks() == 1) && (!node.isEnd())) {
          prefix.append(curLetter);
          node = node.get(curLetter);
        } else return prefix.toString();
      }
      return prefix.toString();
    }
  }
}
