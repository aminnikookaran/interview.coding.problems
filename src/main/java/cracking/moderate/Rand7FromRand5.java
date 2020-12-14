package cracking.moderate;

import java.util.concurrent.ThreadLocalRandom;

public class Rand7FromRand5 {
  private int rand5() {
    return ThreadLocalRandom.current().nextInt() % 5;
  }

  int rand7First() {
    while (true) {
      int num = 5 * rand5() + rand5();
      if (num < 21) return num % 7;
    }
  }

  int rand7Second() {
    while (true) {
      int r1 = 2 * rand5(); /*evens between 0 and 9*/
      int r2 = rand5(); /*used later to generate a·0 or 1*/
      if (r2 != 4) {
        /*r2 has extra even num-discard the extra*/
        int rand1 = r2 % 2; /*Generate 0 or 1*/
        int num = r1 + rand1; /*will be in the range 0 to 9 */
        if (num < 7) return num;
      }
    }
  }
}
