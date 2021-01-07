package leetcode.easy;

// https://leetcode.com/problems/count-of-matches-in-tournament/
public class Q1688CountOfMatchesInTournament {
  public int numberOfMatches1(int n) {
    int count = 0;
    while (n > 1) {
      count += n / 2;
      n = (n + 1) / 2;
    }
    return count;
  }

  public int numberOfMatches2(int n) {
    return n - 1;
  }
}
