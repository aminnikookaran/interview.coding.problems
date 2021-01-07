package leetcode.medium;

// https://leetcode.com/problems/gas-station/
public class Q0134GasStation {
  public int canCompleteCircuit(int[] gas, int[] cost) {
    int total = 0, sum = 0, start = -1;
    for (int i = 0; i < gas.length; i++) {
      sum += gas[i] - cost[i];
      if (sum < 0) {
        start = -1;
        sum = 0;
      } else if (sum >= 0 && start == -1) start = i;
      total += gas[i] - cost[i];
    }
    if (total < 0) return -1;
    return start;
  }
}
