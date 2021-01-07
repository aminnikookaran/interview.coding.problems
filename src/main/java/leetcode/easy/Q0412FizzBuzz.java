package leetcode.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/fizz-buzz/
public class Q0412FizzBuzz {
  public List<String> fizzBuzz1(int n) {
    List<String> list = new ArrayList<>();
    for (int i = 1; i <= n; i++) {
      int div3 = i % 3;
      int div5 = i % 5;
      if (div3 == 0 && div5 == 0) list.add("FizzBuzz");
      else if (div5 == 0) list.add("Buzz");
      else if (div3 == 0) list.add("Fizz");
      else list.add(String.valueOf(i));
    }
    return list;
  }

  public List<String> fizzBuzz2(int n) {
    List<String> ans = new ArrayList<String>();
    for (int num = 1; num <= n; num++) {
      boolean divisibleBy3 = (num % 3 == 0);
      boolean divisibleBy5 = (num % 5 == 0);
      String numAnsStr = "";
      if (divisibleBy3) numAnsStr += "Fizz";
      if (divisibleBy5) numAnsStr += "Buzz";
      if (numAnsStr.equals("")) numAnsStr += Integer.toString(num);
      ans.add(numAnsStr);
    }
    return ans;
  }

  public List<String> fizzBuzz3(int n) {
    List<String> ans = new ArrayList<String>();
    Map<Integer, String> fizzBizzDict = new HashMap<>();
    fizzBizzDict.put(3, "Fizz");
    fizzBizzDict.put(5, "Buzz");
    for (int num = 1; num <= n; num++) {
      String numAnsStr = "";
      for (Integer key : fizzBizzDict.keySet())
        if (num % key == 0) numAnsStr += fizzBizzDict.get(key);
      if (numAnsStr.equals("")) numAnsStr += Integer.toString(num);
      ans.add(numAnsStr);
    }
    return ans;
  }
}
