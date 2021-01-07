package leetcode.easy;

// https://leetcode.com/problems/add-digits/
public class Q0258AddDigits {
  public int addDigits1(int num) {
    while (num > 9) num = num / 10 + num % 10;
    return num;
  }

  public int addDigits2(int num) {
    int digitalRoot = 0;
    while (num > 0) {
      digitalRoot += num % 10;
      num = num / 10;
      if (num == 0 && digitalRoot > 9) {
        num = digitalRoot;
        digitalRoot = 0;
      }
    }
    return digitalRoot;
  }

  public int addDigits3(int num) {
    if (num == 0) return 0;
    if (num % 9 == 0) return 9;
    return num % 9;
  }

  public int addDigits4(int num) {
    return num == 0 ? 0 : 1 + (num - 1) % 9;
  }
}
