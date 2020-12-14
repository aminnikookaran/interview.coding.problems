package leetcode.medium;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import leetcode.Pair;

// https://leetcode.com/problems/word-ladder/
public class Q127WordLadder {
  public int ladderLength1(String beginWord, String endWord, List<String> wordList) {
    if (wordList == null
        || wordList.size() == 0
        || beginWord == null
        || endWord == null
        || beginWord.equals(endWord)) return 0;
    int listLength = wordList.size();
    int wordLength = wordList.get(0).length();
    if (beginWord.length() != wordLength || endWord.length() != wordLength) return 0;

    Map<String, List<String>> wordGraph = new HashMap<>();
    for (int i = 0; i < listLength; i++) wordGraph.put(wordList.get(i), new ArrayList<>());
    for (int i = 0; i < listLength; i++) {
      for (int j = i + 1; j < listLength; j++) {
        int distance = 0;
        for (int k = 0; k < wordLength; k++)
          if (wordList.get(i).charAt(k) != wordList.get(j).charAt(k)) distance++;
        if (distance == 1) {
          wordGraph.get(wordList.get(i)).add(wordList.get(j));
          wordGraph.get(wordList.get(j)).add(wordList.get(i));
        }
      }
    }

    if (!wordGraph.containsKey(endWord)) return 0;
    if (!wordGraph.containsKey(beginWord)) {
      wordGraph.put(beginWord, new ArrayList<>());
      for (int j = 0; j < listLength; j++) {
        int distance = 0;
        for (int k = 0; k < wordLength; k++)
          if (beginWord.charAt(k) != wordList.get(j).charAt(k)) distance++;
        if (distance == 1) {
          wordGraph.get(beginWord).add(wordList.get(j));
          wordGraph.get(wordList.get(j)).add(beginWord);
        }
      }
    }

    Set<String> seenWords = new HashSet<>();
    Deque<String> deque = new ArrayDeque<>();
    deque.add(beginWord);
    seenWords.add(beginWord);
    int distance = 0;
    while (!deque.isEmpty()) {
      distance++;
      int size = deque.size();
      for (int i = 0; i < size; i++) {
        String word = deque.poll();
        List<String> list = wordGraph.get(word);
        for (int j = 0; list != null && j < list.size(); j++) {
          if (!seenWords.contains(list.get(j))) {
            seenWords.add(list.get(j));
            deque.add(list.get(j));
            if (seenWords.contains(endWord)) return distance + 1;
          }
        }
      }
    }
    return 0;
  }

  public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
    int L = beginWord.length();
    Map<String, List<String>> allComboDict = new HashMap<>();
    wordList.forEach(
        word -> {
          for (int i = 0; i < L; i++) {
            // Key is the generic word
            // Value is a list of words which have the same intermediate generic word.
            String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
            List<String> transformations = allComboDict.getOrDefault(newWord, new ArrayList<>());
            transformations.add(word);
            allComboDict.put(newWord, transformations);
          }
        });

    // Queue for BFS
    Queue<Pair<String, Integer>> Q = new LinkedList<>();
    Q.add(new Pair<>(beginWord, 1));

    // Visited to make sure we don't repeat processing same word.
    Map<String, Boolean> visited = new HashMap<>();
    visited.put(beginWord, true);

    while (!Q.isEmpty()) {
      Pair<String, Integer> node = Q.remove();
      String word = node.getKey();
      int level = node.getValue();
      for (int i = 0; i < L; i++) {

        // Intermediate words for current word
        String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);

        // Next states are all the words which share the same intermediate state.
        for (String adjacentWord : allComboDict.getOrDefault(newWord, new ArrayList<>())) {
          // If at any point if we find what we are looking for
          // i.e. the end word - we can return with the answer.
          if (adjacentWord.equals(endWord)) return level + 1;
          // Otherwise, add it to the BFS Queue. Also mark it visited
          if (!visited.containsKey(adjacentWord)) {
            visited.put(adjacentWord, true);
            Q.add(new Pair<>(adjacentWord, level + 1));
          }
        }
      }
    }

    return 0;
  }

  class Solution {

    private int L;
    private Map<String, List<String>> allComboDict;

    Solution() {
      this.L = 0;

      // Dictionary to hold combination of words that can be formed,
      // from any given word. By changing one letter at a time.
      this.allComboDict = new HashMap<>();
    }

    private int visitWordNode(
        Queue<Pair<String, Integer>> Q,
        Map<String, Integer> visited,
        Map<String, Integer> othersVisited) {

      Pair<String, Integer> node = Q.remove();
      String word = node.getKey();
      int level = node.getValue();

      for (int i = 0; i < this.L; i++) {

        // Intermediate words for current word
        String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);

        // Next states are all the words which share the same intermediate state.
        for (String adjacentWord : this.allComboDict.getOrDefault(newWord, new ArrayList<>())) {
          // If at any point if we find what we are looking for
          // i.e. the end word - we can return with the answer.
          if (othersVisited.containsKey(adjacentWord)) {
            return level + othersVisited.get(adjacentWord);
          }

          if (!visited.containsKey(adjacentWord)) {

            // Save the level as the value of the dictionary, to save number of hops.
            visited.put(adjacentWord, level + 1);
            Q.add(new Pair<>(adjacentWord, level + 1));
          }
        }
      }
      return -1;
    }

    public int ladderLength3(String beginWord, String endWord, List<String> wordList) {
      if (!wordList.contains(endWord)) return 0;
      this.L = beginWord.length();
      wordList.forEach(
          word -> {
            for (int i = 0; i < L; i++) {
              // Key is the generic word
              // Value is a list of words which have the same intermediate generic word.
              String newWord = word.substring(0, i) + '*' + word.substring(i + 1, L);
              List<String> transformations =
                  this.allComboDict.getOrDefault(newWord, new ArrayList<>());
              transformations.add(word);
              this.allComboDict.put(newWord, transformations);
            }
          });

      // Queues for bidirectional BFS
      // BFS starting from beginWord
      Queue<Pair<String, Integer>> Q_begin = new LinkedList<>();
      // BFS starting from endWord
      Queue<Pair<String, Integer>> Q_end = new LinkedList<>();
      Q_begin.add(new Pair<>(beginWord, 1));
      Q_end.add(new Pair<>(endWord, 1));

      // Visited to make sure we don't repeat processing same word.
      Map<String, Integer> visitedBegin = new HashMap<>();
      Map<String, Integer> visitedEnd = new HashMap<>();
      visitedBegin.put(beginWord, 1);
      visitedEnd.put(endWord, 1);

      while (!Q_begin.isEmpty() && !Q_end.isEmpty()) {

        // One hop from begin word
        int ans = visitWordNode(Q_begin, visitedBegin, visitedEnd);
        if (ans > -1) {
          return ans;
        }

        // One hop from end word
        ans = visitWordNode(Q_end, visitedEnd, visitedBegin);
        if (ans > -1) {
          return ans;
        }
      }

      return 0;
    }
  }

  //  public static void main(String[] args) {
  //    System.out.println(
  //        ladderLength1(
  //            "hit", "cog", Arrays.asList(new String[] {"hot", "dot", "dog", "lot", "log",
  // "cog"})));
  //  }
}
