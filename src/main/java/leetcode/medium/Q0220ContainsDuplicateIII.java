package leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

// https://leetcode.com/problems/contains-duplicate-iii/
public class Q0220ContainsDuplicateIII {
  public boolean containsNearbyAlmostDuplicate1(int[] nums, int k, int t) {
    if (k < 1 || t < 0) return false;
    Map<Long, Long> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      long remappedNum = (long) nums[i] - Integer.MIN_VALUE;
      long bucket = remappedNum / ((long) t + 1);
      if (map.containsKey(bucket)
          || (map.containsKey(bucket - 1) && remappedNum - map.get(bucket - 1) <= t)
          || (map.containsKey(bucket + 1) && map.get(bucket + 1) - remappedNum <= t)) return true;
      if (map.entrySet().size() >= k) {
        long lastBucket = ((long) nums[i - k] - Integer.MIN_VALUE) / ((long) t + 1);
        map.remove(lastBucket);
      }
      map.put(bucket, remappedNum);
    }
    return false;
  }

  // other way of generating id because in java dividing is rounded towards zero
  public long getID(long i, long w) {
    return i < 0 ? (i + 1) / w - 1 : i / w;
  }

  public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
    if (nums == null || nums.length == 0 || k <= 0) return false;
    final TreeSet<Integer> values = new TreeSet<>();
    for (int ind = 0; ind < nums.length; ind++) {
      final Integer floor = values.floor(nums[ind] + t);
      final Integer ceil = values.ceiling(nums[ind] - t);
      if ((floor != null && floor >= nums[ind]) || (ceil != null && ceil <= nums[ind])) return true;
      values.add(nums[ind]);
      if (ind >= k) values.remove(nums[ind - k]);
    }
    return false;
  }
}
