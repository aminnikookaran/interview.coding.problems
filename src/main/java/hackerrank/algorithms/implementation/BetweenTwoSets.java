package hackerrank.algorithms.implementation;

import java.util.ArrayList;
import java.util.List;

// https://www.hackerrank.com/challenges/between-two-sets/problem
public class BetweenTwoSets {
  public static int getTotalX(List<Integer> a, List<Integer> b) {
    //    if (a.size() == 0 || b.size() == 0) return 0;
    //
    //    int minb = Integer.MAX_VALUE;
    //    for (int i = 0; i < b.size(); i++) {
    //      if (minb > b.get(i)) minb = b.get(i);
    //    }
    //
    //    int maxa = 1;
    //    for (int i = 0; i < a.size(); i++) {
    //      if (maxa < a.get(i)) maxa = a.get(i);
    //    }
    //
    //    int count = 0;
    //    for (int i = maxa; i <= minb; i++) {
    //      boolean isFactor = true;
    //      for (int j = 0; j < b.size(); j++) {
    //        if (b.get(j) % i != 0) {
    //          isFactor = false;
    //          break;
    //        }
    //      }
    //
    //      for (int j = 0; j < a.size(); j++) {
    //        if (i % a.get(j) != 0) {
    //          isFactor = false;
    //          break;
    //        }
    //      }
    //
    //      if (isFactor) count++;
    //    }
    //    return count;

    if (a.size() == 0 || b.size() == 0) return 0;

    int alcm = a.get(0);
    for (int i = 1; i < a.size(); i++) {
      alcm = lcm(alcm, a.get(i));
    }

    int bgcd = b.get(0);
    for (int i = 1; i < b.size(); i++) {
      bgcd = gcd(bgcd, b.get(i));
    }

    int maxa = 1;
    for (int i = 0; i < a.size(); i++) {
      if (maxa < a.get(i)) maxa = a.get(i);
    }

    int count = 0;
    for (int i = alcm, j = 2; i <= bgcd; i = alcm * j, j++) {
      if (bgcd % i == 0) count++;
    }
    return count;
  }

  public static int gcd(int a, int b) {
    if (b == 0) return a;
    return gcd(b, a % b);

    //    if (b < a) {
    //      a = a + b;
    //      b = a - b;
    //      a = a - b;
    //    }
    //    while (b != 0) {
    //      a %= b;
    //      a = a + b;
    //      b = a - b;
    //      a = a - b;
    //    }
    //    return a;
  }

  public static int lcm(int a, int b) {
    if (a == 0 || b == 0) return 0;
    return a * b / gcd(a, b);
  }

  public static void main(String[] args) {
    List<Integer> a = new ArrayList<>();
    a.add(2);
    a.add(4);
    List<Integer> b = new ArrayList<>();
    b.add(16);
    b.add(32);
    b.add(96);
    System.out.println(getTotalX(a, b));
  }
}
