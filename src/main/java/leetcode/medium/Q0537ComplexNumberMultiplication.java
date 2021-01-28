package leetcode.medium;

// https://leetcode.com/problems/complex-number-multiplication/
public class Q0537ComplexNumberMultiplication {
  public String complexNumberMultiply1(String a, String b) {
    String x[] = a.split("\\+|i");
    String y[] = b.split("\\+|i");
    int a_real = Integer.parseInt(x[0]);
    int a_img = Integer.parseInt(x[1]);
    int b_real = Integer.parseInt(y[0]);
    int b_img = Integer.parseInt(y[1]);
    return (a_real * b_real - a_img * b_img) + "+" + (a_real * b_img + a_img * b_real) + "i";
  }

  public String complexNumberMultiply2(String a, String b) {
    String result = "";
    String[] A = a.split("\\+");
    String[] B = b.split("\\+");
    int a1 = Integer.parseInt(A[0]);
    int b1 = Integer.parseInt(A[1].replace("i", ""));

    int a2 = Integer.parseInt(B[0]);
    int b2 = Integer.parseInt(B[1].replace("i", ""));

    int a1a2 = a1 * a2;
    int b1b2 = b1 * b2;
    int a1b2a2b1 = (a1 * b2) + (b1 * a2);

    String afinal = (a1a2 + (-1 * b1b2)) + "";
    String bfinal = a1b2a2b1 + "i";
    result = afinal + "+" + bfinal;
    return result;
  }
}
