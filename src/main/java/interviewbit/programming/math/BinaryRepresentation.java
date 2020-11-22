package interviewbit.programming.math;

// https://www.interviewbit.com/problems/binary-representation/
public class BinaryRepresentation {
  public static String findDigitsInBinary(int A) {
    if (A == 0) return "0";
    String binary = "";
    while (A > 0) {
      binary = String.valueOf(A % 2) + binary;
      A /= 2;
    }
    return binary;
  }

  public static void main(String[] args) {
    System.out.println(findDigitsInBinary(10000));
  }
}
