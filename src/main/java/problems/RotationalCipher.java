package problems;

import java.util.HashMap;
import java.util.Map;

public class RotationalCipher {
  public static String rotationalCipher(String input, int rotationFactor) {
    Map<Character, Character> map = new HashMap<>();
    for (int i = 0; i < 10; i++)
      map.put((char) ('0' + i), (char) ('0' + ((i + rotationFactor) % 10)));
    for (int i = 0; i < 26; i++) {
      map.put((char) ('a' + i), (char) ('a' + ((i + rotationFactor) % 26)));
      map.put((char) ('A' + i), (char) ('A' + ((i + rotationFactor) % 26)));
    }
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < input.length(); i++) {
      Character c = map.get(input.charAt(i));
      if (c == null) c = input.charAt(i);
      stringBuilder.append(c);
    }
    return stringBuilder.toString();
  }

  public static void main(String[] args) {
    System.out.println(rotationalCipher("All-convoYs-9-be:Alert1.", 4));
    System.out.println(rotationalCipher("abcdZXYzxy-999.@", 200));
  }
}
