package cracking.moderate;

import java.util.Arrays;

public class LivingPeople {
  public class Person {
    public int birth;
    public int death;

    public Person(int birthYear, int deathYear) {
      birth = birthYear;
      death = deathYear;
    }
  }

  int maxAliveYear1(Person[] people, int min, int max) {
    int[] births = getSortedYears(people, true);
    int[] deaths = getSortedYears(people, false);
    int birthIndex = 0;
    int deathIndex = 0;
    int currentlyAlive = 0;
    int maxAlive = 0;
    int maxAliveYear = min;
    /* Walk through arrays. */
    while (birthIndex < births.length) {
      if (births[birthIndex] <= deaths[deathIndex]) {
        currentlyAlive++; // include birth
        if (currentlyAlive > maxAlive) {
          maxAlive = currentlyAlive;
          maxAliveYear = births[birthIndex];
        }
        birthIndex++; // move birth index
      } else if (births[birthIndex] > deaths[deathIndex]) {
        currentlyAlive--; // include death
        deathIndex++; // move death index
      }
    }
    return maxAliveYear;
  }

  /* Copy birth years or death years (depending on the value of copyBirthVear into
  integer array, then sort array. */
  int[] getSortedYears(Person[] people, boolean copyBirthYear) {
    int[] years = new int[people.length];
    for (int i = 0; i < people.length; i++)
      years[i] = copyBirthYear ? people[i].birth : people[i].death;
    Arrays.sort(years);
    return years;
  }

  int maxAliveYear(Person[] people, int min, int max) {
    /* Build population delta array. */
    int[] populationDeltas = getPopulationDeltas(people, min, max);
    int maxAliveYear = getMaxAliveYear(populationDeltas);
    return maxAliveYear + min;
  }

  /* Add birth and death years to deltas array. */
  int[] getPopulationDeltas(Person[] people, int min, int max) {
    int[] populationDeltas = new int[max - min + 2];
    for (Person person : people) {
      int birth = person.birth - min;
      populationDeltas[birth]++;
      int death = person.death - min;
      populationDeltas[death + 1]--;
    }
    return populationDeltas;
  }

  /* Compute running sums and return index with max. */
  int getMaxAliveYear(int[] deltas) {
    int maxAliveYear = 0;
    int maxAlive = 0;
    int currentlyAlive = 0;
    for (int year = 0; year < deltas.length; year++) {
      currentlyAlive += deltas[year];
      if (currentlyAlive > maxAlive) {
        maxAliveYear = year;
        maxAlive = currentlyAlive;
      }
    }
    return maxAliveYear;
  }
}
