package cracking.moderate;

import java.util.HashMap;
import java.util.Map;

public class WordFrequencies {
  int getFrequency1(String[] book, String word) {
    word = word.trim().toLowerCase();
    int count = 0;
    for (String w : book) if (w.trim().toLowerCase().equals(word)) count++;
    return count;
  }

  Map<String, Integer> setupDictionary(String[] book) {
    Map<String, Integer> table = new HashMap<String, Integer>();
    for (String word : book) {
      word = word.toLowerCase();
      if (word.trim() != "") {
        if (!table.containsKey(word)) table.put(word, 0);
        table.put(word, table.get(word) + 1);
      }
    }
    return table;
  }

  int getFrequency(Map<String, Integer> table, String word) {
    if (table == null || word == null) return -1;
    word = word.toLowerCase();
    if (table.containsKey(word)) return table.get(word);
    return 0;
  }
}
