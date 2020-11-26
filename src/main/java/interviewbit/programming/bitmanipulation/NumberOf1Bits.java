package interviewbit.programming.bitmanipulation;

public class NumberOf1Bits {
  public static int numSetBits1(long a) {
    int count = 0;
    for (int i = 0; i < 63; i++) {
      if ((a & 1) == 1) count++;
      a = a >>> 1;
    }
    return count;
  }

  public static int numSetBits2(long a) {
    int count = 0;
    while (a > 0) {
      a &= a - 1;
      count++;
    }
    return count;
  }
}
