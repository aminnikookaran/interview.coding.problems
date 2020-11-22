package hackerrank.datastructures.queues;

// https://www.hackerrank.com/challenges/down-to-zero-ii/problem
public class DownToZeroII {
  public static int downToZero1(int n) {
    int[] numbers = new int[n + 1];
    for (int i = 0; i <= n; i++) numbers[i] = i;
    for (int i = 2; i <= n; i++) {
      for (int j = i + 1; j < i + i && j <= n; j++)
        numbers[j] = Math.min(numbers[j], numbers[i] + j % i);
      for (int j = i + i; j <= i * i && j <= n; j++)
        numbers[j] = Math.min(numbers[j], numbers[i] + 1 + j % i);
    }

    return numbers[n];
  }

  public static int downToZero2(int n) {
    int[] numbers = new int[n + 1];
    for (int i = 0; i <= n; i++) numbers[i] = i;
    for (int i = 2; i <= n; i++) {
      if (numbers[i] > numbers[i - 1] + 1) numbers[i] = numbers[i - 1] + 1;
      for (int j = i + i; j <= i * i && j <= n; j += i)
        if (numbers[j] > numbers[i] + 1) numbers[j] = numbers[i] + 1;
    }

    return numbers[n];
  }

  public static int downToZero3(int n) {
    int[] numbers = new int[n + 1];
    for (int i = 0; i <= n; i++) numbers[i] = Integer.MAX_VALUE;
    numbers[0] = 0;
    numbers[1] = 1;
    for (int i = 2; i <= n; i++) {
      numbers[i] = Math.min(numbers[i], numbers[i - 1] + 1);
      for (int j = 2; j * j <= i; j++)
        if (i % j == 0) numbers[i] = Math.min(numbers[i], numbers[i / j] + 1);
    }

    return numbers[n];
  }

  static int[] numbers1 = new int[1000001];
  static int[] numbers2 = new int[1000001];

  static {
    for (int i = 0; i <= 1000000; i++) numbers1[i] = i;
    for (int i = 2; i <= 1000000; i++) {
      numbers1[i] = Math.min(numbers1[i], numbers1[i - 1] + 1);
      for (int j = i + i; j / i <= i && j <= 1000000; j += i)
        numbers1[j] = Math.min(numbers1[j], numbers1[i] + 1);
    }

    for (int i = 0; i <= 1000000; i++) numbers2[i] = i;
    for (int i = 2; i <= 1000000; i++) {
      numbers2[i] = Math.min(numbers2[i], numbers2[i - 1] + 1);
      for (int j = 2; j * j <= i; j++)
        if (i % j == 0) numbers2[i] = Math.min(numbers2[i], numbers2[i / j] + 1);
    }
  }

  public static void main(String[] args) {
    for (int i = 0; i <= 1000000; i++)
      if (numbers1[i] != numbers2[i])
        System.out.println(i + "\t" + numbers1[i] + "\t" + numbers2[i]);
  }
}
