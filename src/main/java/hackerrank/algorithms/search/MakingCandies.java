package hackerrank.algorithms.search;

// https://www.hackerrank.com/challenges/making-candies/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=search
public class MakingCandies {
  public static long minimumPasses1(long m, long w, long p, long n) {
    long candy = 0;
    long invest = 0;
    long spend = n / (m * w) + (n % (m * w) > 0 ? 1 : 0);
    while (candy < n) {
      long days = (p - candy) / (m * w);
      if (days <= 0) {
        long buys = (candy / p) + m + w;
        if (m > w) {
          m = Math.max(m, buys / 2);
          w = buys - m;
        } else {
          w = Math.max(w, buys / 2);
          m = buys - w;
        }
        candy %= p;
        days = 1;
      }
      candy += days * m * w;
      invest += days;
      spend = Math.min(spend, invest + (n - candy) / (m * w) + ((n - candy) % (m * w) > 0 ? 1 : 0));
    }
    return Math.min(invest, spend);
  }

  public static long minimumPasses2(long m, long w, long p, long n) {
    long pass = 0;
    long result = n / (m * w) + (n % (m * w) > 0 ? 1 : 0);
    long resource = 0;
    while (pass < result) {
      long stPass = (p - resource) / (m * w) + ((p - resource) % (m * w) > 0 ? 1 : 0);
      pass += stPass;
      resource += m * w * stPass;
      long buys = (resource / p) + m + w;
      if (m > w) {
        m = Math.max(m, buys / 2);
        w = buys - m;
      } else {
        w = Math.max(w, buys / 2);
        m = buys - w;
      }
      resource %= p;
      long minPass = (n - resource) / (m * w) + ((n - resource) % (m * w) > 0 ? 1 : 0);
      result = Math.min(result, pass + minPass);
    }
    return result;
  }

  public static void main(String[] args) {
    System.out.println(minimumPasses1(1, 1, 6, 45));
  }
}
