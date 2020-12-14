package cracking.moderate;

public class NumberSwapper {
  public void swap1(int a, int b) {
    a = a - b;
    b = a + b;
    a = a - b;
  }

  public void swap2(int a, int b) {
    a = a ^ b;
    b = a ^ b;
    a = a ^ b;
  }
}
