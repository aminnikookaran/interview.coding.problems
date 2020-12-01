package cracking.sortingsearching;

import java.util.Arrays;
import java.util.List;

public class GroupAnagrams {

  /*HashMapList<String, Integer> is a HashMap that maps from Strings to
   *ArrayList<Integer>. See appendix for implementation.*/
  class HashMapList<K, V> {

    public void put(String key, String s) {
      // TODO Auto-generated method stub

    }

    public List<String> keySet() {
      // TODO Auto-generated method stub
      return null;
    }

    public List<String> get(String key) {
      // TODO Auto-generated method stub
      return null;
    }
  }

  void sort(String[] array) {
    HashMapList<String, String> maplist = new HashMapList<String, String>();

    /* Group words by anagram */
    for (String s : array) {
      String key = sortChars(s);
      maplist.put(key, s);
    }
    /*Convert hash table to array*/
    int index = 0;
    for (String key : maplist.keySet()) {
      List<String> list = maplist.get(key);
      for (String t : list) {
        array[index] = t;
        index++;
      }
    }
  }

  String sortChars(String s) {
    char[] content = s.toCharArray();
    Arrays.sort(content);
    return new String(content);
  }
}
