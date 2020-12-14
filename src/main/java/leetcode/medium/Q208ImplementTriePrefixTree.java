package leetcode.medium;

// https://leetcode.com/problems/implement-trie-prefix-tree/
public class Q208ImplementTriePrefixTree {
  class Trie1 {
    Trie1[] children;
    boolean isWord;

    /** Initialize your data structure here. */
    public Trie1() {
      children = new Trie1[26];
      isWord = false;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
      if (word == null) return;
      if (word.length() == 0) {
        isWord = true;
        return;
      }
      if (children[word.charAt(0) - 'a'] == null) children[word.charAt(0) - 'a'] = new Trie1();
      children[word.charAt(0) - 'a'].insert(word.substring(1));
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
      if (word == null) return false;
      if (word.length() == 0) return isWord;
      if (children[word.charAt(0) - 'a'] == null) return false;
      return children[word.charAt(0) - 'a'].search(word.substring(1));
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
      if (prefix == null) return false;
      if (prefix.length() == 0) return true;
      if (children[prefix.charAt(0) - 'a'] == null) return false;
      return children[prefix.charAt(0) - 'a'].startsWith(prefix.substring(1));
    }
  }

  class TrieNode {
    private TrieNode[] links;
    private final int R = 26;
    private boolean isEnd;

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
    }

    public void setEnd() {
      isEnd = true;
    }

    public boolean isEnd() {
      return isEnd;
    }
  }

  class Trie {
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
  }
}
