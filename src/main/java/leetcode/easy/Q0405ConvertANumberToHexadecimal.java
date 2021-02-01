package leetcode.easy;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/convert-a-number-to-hexadecimal/
public class Q0405ConvertANumberToHexadecimal {
  public String toHex1(int num) {
    Map<Integer, Character> map = new HashMap<>();
    map.put(0, '0');
    map.put(1, '1');
    map.put(2, '2');
    map.put(3, '3');
    map.put(4, '4');
    map.put(5, '5');
    map.put(6, '6');
    map.put(7, '7');
    map.put(8, '8');
    map.put(9, '9');
    map.put(10, 'a');
    map.put(11, 'b');
    map.put(12, 'c');
    map.put(13, 'd');
    map.put(14, 'e');
    map.put(15, 'f');
    String result = "";
    int n = 15;
    for (int i = 0; i < 8; i++) {
      result = map.get(num & n) + result;
      num >>>= 4;
      if (num == 0) break;
    }
    return result;
  }

  char[] map = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

  public String toHex2(int num) {
    if (num == 0) return "0";
    String result = "";
    while (num != 0) {
      result = map[(num & 15)] + result;
      num = (num >>> 4);
    }
    return result;
  }
}
