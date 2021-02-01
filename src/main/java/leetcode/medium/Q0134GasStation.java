package leetcode.medium;

// https://leetcode.com/problems/gas-station/
public class Q0134GasStation {
  public int canCompleteCircuit1(int[] gas, int[] cost) {
    int total = 0, sum = 0, start = -1;
    for (int i = 0; i < gas.length; i++) {
      sum += gas[i] - cost[i];
      if (sum < 0) {
        start = -1;
        sum = 0;
      } else if (start == -1) start = i;
      total += gas[i] - cost[i];
    }
    if (total < 0) return -1;
    return start;
  }

  public int canCompleteCircuit2(int[] gas, int[] cost) {
    int sumGas = 0;
    int sumCost = 0;
    int start = 0;
    int tank = 0;
    for (int i = 0; i < gas.length; i++) {
      sumGas += gas[i];
      sumCost += cost[i];
      tank += gas[i] - cost[i];
      if (tank < 0) {
        start = i + 1;
        tank = 0;
      }
    }
    if (sumGas < sumCost) return -1;
    else return start;
  }
}
