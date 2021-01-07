package leetcode.easy;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/binary-watch/
public class Q0401BinaryWatch {
  public List<String> readBinaryWatch1(int num) {
    List<String> result = new ArrayList<String>();
    for (int i = 0; i < 12; i++) {
      for (int j = 0; j < 60; j++) {
        int total = countDigits(i) + countDigits(j);
        if (total == num) {
          String s = "";
          s += i + ":";
          if (j < 10) s += "0" + j;
          else s += j;
          result.add(s);
        }
      }
    }
    return result;
  }

  public int countDigits(int num) {
    int result = 0;
    while (num > 0) {
      if ((num & 1) == 1) result++;
      num >>= 1;
    }
    return result;
  }

  public List<String> readBinaryWatch2(int num) {
    List<String> result = new ArrayList<>();
    for (int i = 0; i <= 4; i++) {
      int h = i;
      int m = num - i;
      List<List<Integer>> hSet = new ArrayList<>();
      subSet(h, 4, 1, new ArrayList<Integer>(), hSet);
      List<List<Integer>> mSet = new ArrayList<>();
      subSet(m, 6, 1, new ArrayList<>(), mSet);
      List<String> hoursList = new ArrayList<>();
      List<String> minsList = new ArrayList<>();
      if (hSet.size() == 0) hoursList.add("0");
      else hoursList.addAll(getTime(hSet, true));
      if (mSet.size() == 0) minsList.add("00");
      else minsList.addAll(getTime(mSet, false));
      for (int x = 0; x < hoursList.size(); x++)
        for (int y = 0; y < minsList.size(); y++)
          result.add(hoursList.get(x) + ":" + minsList.get(y));
    }
    return result;
  }

  public List<String> getTime(List<List<Integer>> lists, boolean isHour) {
    List<String> result = new ArrayList<>();
    for (List<Integer> l : lists) {
      int sum = 0;
      for (int i : l) sum += (1 << (i - 1));
      if (isHour && sum >= 12) continue;
      if (!isHour && sum >= 60) continue;
      if (sum < 10 && !isHour) result.add("0" + sum);
      else result.add("" + sum);
    }
    return result;
  }

  public void subSet(int k, int m, int start, List<Integer> temp, List<List<Integer>> result) {
    if (k == 0) {
      result.add(new ArrayList<Integer>(temp));
      return;
    }
    for (int i = start; i <= m; i++) {
      temp.add(i);
      subSet(k - 1, m, i + 1, temp, result);
      temp.remove(temp.size() - 1);
    }
  }
}
