package leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

// https://leetcode.com/problems/encode-and-decode-strings/
public class Q0271EncodeAndDecodeStrings {
  public class Codec1 {
    public String encode(List<String> strs) {
      StringBuilder sb = new StringBuilder();
      for (String s : strs) sb.append(s.length()).append('/').append(s);
      return sb.toString();
    }

    public List<String> decode(String s) {
      List<String> res = new ArrayList<String>();
      int i = 0;
      while (i < s.length()) {
        int slash = s.indexOf('/', i);
        int size = Integer.valueOf(s.substring(i, slash));
        res.add(s.substring(slash + 1, slash + size + 1));
        i = slash + size + 1;
      }
      return res;
    }
  }

  public class Codec2 {
    public String encode(List<String> strs) {
      return strs.stream()
          .map(s -> s.replace("/", "//").replace("*", "/*") + "*")
          .collect(Collectors.joining());
    }

    public List<String> decode(String s) {
      List<String> res = new ArrayList<>();
      StringBuilder str = new StringBuilder();

      for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == '/') {
          str.append(s.charAt(++i));
        } else if (s.charAt(i) == '*') {
          res.add(str.toString());
          str.setLength(0);
        } else {
          str.append(s.charAt(i));
        }
      }

      return res;
    }
  }

  public class Codec3 {
    public String encode(List<String> strs) {
      String result = strs.size() + "";
      for (String s : strs) result += ":" + s.length();
      result += ":";
      for (String s : strs) result += s;
      return result;
    }

    public List<String> decode(String s) {
      List<String> result = new LinkedList<>();
      int i = 0;
      int numOfStr = 0;
      while (s.charAt(i) != ':') {
        numOfStr = numOfStr * 10 + (s.charAt(i) - '0');
        i++;
      }
      List<Integer> lengths = new LinkedList<>();
      i++;
      for (int j = 0; j < numOfStr; j++) {
        int leng = 0;
        while (s.charAt(i) != ':') {
          leng = leng * 10 + (s.charAt(i) - '0');
          i++;
        }
        lengths.add(leng);
        i++;
      }
      for (Integer l : lengths) {
        String tmp = "";
        for (int j = 0; j < l; j++) {
          tmp += s.charAt(i);
          i++;
        }
        result.add(tmp);
      }
      return result;
    }
  }
}
