package cracking.mathlogicpuzzles;

import java.util.Random;

public class TheApocalypse {
  double runNFamilies(int n) {
    int boys = 0;
    int girls = 0;
    for (int i = 0; i < n; i++) {
      int[] genders = runOneFamily();
      girls += genders[0];
      boys += genders[1];
    }
    return girls / (double) (boys + girls);
  }

  int[] runOneFamily() {
    Random random = new Random();
    int boys = 0;
    int girls = 0;
    while (girls == 0) { // until we have a girl
      if (random.nextBoolean()) girls += 1; // girl
      else boys += 1; // boy
    }
    int[] genders = {girls, boys};
    return genders;
  }
}
