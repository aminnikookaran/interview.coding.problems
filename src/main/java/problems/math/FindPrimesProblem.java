package problems.math;

import java.util.ArrayList;
import java.util.List;

public class FindPrimesProblem {
  public static ArrayList<Integer> getPrimes(int A) {
    ArrayList<Integer> primes = new ArrayList<>();
    for (int i = 2; i <= A; i++) {
      boolean isPrime = true;
      for (Integer prime : primes) if (i % prime == 0) isPrime = false;
      if (isPrime) primes.add(i);
    }
    return primes;
  }

  public static ArrayList<Integer> getPrimesSieve(int A) {
    boolean[] numbersNotPrime = new boolean[A + 1];
    ArrayList<Integer> primes = new ArrayList<>();
    for (int i = 2; i <= A; i++) {
      if (!numbersNotPrime[i]) {
        primes.add(i);
        for (int j = i * 2; j <= A; j += i) numbersNotPrime[j] = true;
      }
    }
    return primes;
  }

  public static void main(String[] args) {
    System.out.println(System.currentTimeMillis());
    List<Integer> primes = getPrimes(10000);
    System.out.println(System.currentTimeMillis());
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < primes.size(); i++) {
      stringBuilder.append(primes.get(i)).append(" ");
    }
    System.out.println(stringBuilder.toString());

    System.out.println(System.currentTimeMillis());
    primes = getPrimesSieve(10000);
    System.out.println(System.currentTimeMillis());
    stringBuilder = new StringBuilder();
    for (int i = 0; i < primes.size(); i++) {
      stringBuilder.append(primes.get(i)).append(" ");
    }
    System.out.println(stringBuilder.toString());
  }
}
