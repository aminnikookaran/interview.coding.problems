package interviewbit.programming.strings;

// https://www.interviewbit.com/problems/atoi/
public class Atoi {
  public static int atoi(final String A) {
    int sum = 0;
    boolean negative = false;
    boolean nonSpaceSeen = false;
    for (int i = 0; i < A.length(); i++) {
      if (A.charAt(i) != ' ') {
        nonSpaceSeen = true;
        if (A.charAt(i) == '+') {
          if (sum > 0) break;
        } else if (A.charAt(i) == '-')
          if (sum > 0) break;
          else negative = !negative;
        else if ((A.charAt(i) - '0') >= 0 && (A.charAt(i) - '0') <= 9) {
          int digit = A.charAt(i) - '0';
          if (sum > Integer.MAX_VALUE / 10
              || (sum == Integer.MAX_VALUE / 10)
                  && ((digit > 6 && !negative) || (digit > 7 && negative)))
            if (negative) return Integer.MIN_VALUE;
            else return Integer.MAX_VALUE;
          sum = sum * 10 + digit;
        } else break;
      } else if (nonSpaceSeen) break;
    }
    if (negative) return -sum;
    return sum;
  }

  public static void main(String[] args) {
    System.out.println(atoi("- 5 88C340185Q 71 8079 834617385 2898422X5297Z6900"));
  }
}
