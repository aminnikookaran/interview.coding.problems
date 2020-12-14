package cracking.moderate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class T9 {
  List<String> getValidT9Words1(String number, Set<String> wordList) {
    List<String> results = new ArrayList<String>();
    getValidWords1(number, 0, "", wordList, results);
    return results;
  }

  void getValidWords1(
      String number, int index, String prefix, Set<String> wordSet, List<String> results) {
    /* If it's a complete word, print it. */
    if (index == number.length() && wordSet.contains(prefix)) {
      results.add(prefix);
      return;
    }

    /* Get characters that match this digit. */
    char digit = number.charAt(index);
    char[] letters = getT9Chars(digit);
    /* Go through all remaining options. */
    if (letters != null)
      for (char letter : letters)
        getValidWords1(number, index + 1, prefix + letter, wordSet, results);
  }

  /* Return array of characters that map to this digit. */
  char[] getT9Chars(char digit) {
    if (!Character.isDigit(digit)) return null;
    int dig = Character.getNumericValue(digit) - Character.getNumericValue('0');
    return t9Letters[dig];
  }

  /* Mapping of digits to letters. */
  char[][] t9Letters = {
    null,
    null,
    {'a', 'b', 'c'},
    {'d', 'e', 'f'},
    {'g', 'h', 'i'},
    {'j', 'k', 'l'},
    {'m', 'n', 'o'},
    {'p', 'q', 'r', 's'},
    {'t', 'u', 'v'},
    {'w', 'x', 'y', 'z'}
  };

  List<String> getValidT9Words2(String number, Trie trie) {
    List<String> results = new ArrayList<String>();
    getValidWords(number, 0, "", trie.getRoot(), results);
    return results;
  }

  void getValidWords(
      String number, int index, String prefix, TrieNode trieNode, List<String> results) {
    /*If it's a complete word, print it. */
    if (index == number.length()) {
      if (trieNode.terminates()) results.add(prefix); // Is complete word
      return;
    }

    /* Get characters that match this digit */
    char digit = number.charAt(index);
    char[] letters = getT9Chars(digit);

    /* Go through all remaining options. */
    if (letters != null)
      for (char letter : letters) {
        TrieNode child = trieNode.getChild(letter);
        /* If there are words that start with prefix + letter,
         * then continue recursing. */
        if (child != null) getValidWords(number, index + 1, prefix + letter, child, results);
      }
  }

  /* WORD LOOKUP */
  List<String> getValidT9Words(String numbers, HashMapList<String, String> dictionary) {
    return dictionary.get(numbers);
  }

  /* PRECOMPUTATION */
  /* Create a hash table that maps from a number to all words that have this
   * numerical representation. */
  HashMapList<String, String> initializeDictionary(String[] words) {
    /* Create a hash table that maps from a letter to the digit */
    Map<Character, Character> letterToNumberMap = createLetterToNumberMap();
    /* Create word -> number map. */
    HashMapList<String, String> wordsToNumbers = new HashMapList<String, String>();
    for (String word : words) {
      String numbers = convertToT9(word, letterToNumberMap);
      wordsToNumbers.put(numbers, word);
    }
    return wordsToNumbers;
  }

  /* Convert mapping of number->letters into letter->number. */
  Map<Character, Character> createLetterToNumberMap() {
    Map<Character, Character> letterToNumberMap = new HashMap<Character, Character>();
    for (int i = 0; i < t9Letters.length; i++) {
      char[] letters = t9Letters[i];
      if (letters != null)
        for (char letter : letters) {
          char c = Character.forDigit(i, 10);
          letterToNumberMap.put(letter, c);
        }
    }
    return letterToNumberMap;
  }

  /* Convert from a string to its T9 representation. */
  String convertToT9(String word, Map<Character, Character> letterToNumberMap) {
    StringBuilder sb = new StringBuilder();
    for (char c : word.toCharArray())
      if (letterToNumberMap.containsKey(c)) {
        char digit = letterToNumberMap.get(c);
        sb.append(digit);
      }
    return sb.toString();
  }
}
