package cracking.mathlogicpuzzles;

public class TheEggDropProblem {
  int breakingPoint = 0;
  int countDrops = 0;

  boolean drop(int floor) {
    countDrops++;
    return floor >= breakingPoint;
  }

  int findBreakingPoint(int floors) {
    int interval = 14;
    int previousFloor = 0;
    int egg1 = interval;

    /* Drop egg1 at decreasing intervals. */
    while (!drop(egg1) && egg1 <= floors) {
      interval -= 1;
      previousFloor = egg1;
      egg1 += interval;
    }

    /* Drop egg2 at 1 unit increments. */
    int egg2 = previousFloor + 1;
    while (egg2 < egg1 && egg2 <= floors && !drop(egg2)) egg2 += 1;

    /* If it didn't break, return -1. */
    return egg2 > floors ? -1 : egg2;
  }
}
