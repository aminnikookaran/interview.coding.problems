package hackerrank.algorithms.sorting;

import java.util.Comparator;

// https://www.hackerrank.com/challenges/ctci-comparator-sorting/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=sorting
public class SortingComparator {
  class Player {
    String name;
    int score;

    Player(String name, int score) {
      this.name = name;
      this.score = score;
    }
  }

  class Checker implements Comparator<Player> {
    public int compare(Player a, Player b) {
      if (a.score < b.score) return 1;
      else if (a.score == b.score) {
        int compS = a.name.compareTo(b.name);
        if (compS > 0) return 1;
        else if (compS == 0) return 0;
        else return -1;
      } else return -1;
    }
  }
}
