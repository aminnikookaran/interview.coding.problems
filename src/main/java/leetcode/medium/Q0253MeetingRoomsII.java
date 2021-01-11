package leetcode.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

// https://leetcode.com/problems/meeting-rooms-ii/
public class Q0253MeetingRoomsII {
  public int minMeetingRooms1(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
    PriorityQueue<Integer> heap = new PriorityQueue<>();
    int count = 0;
    for (int[] interval : intervals) {
      if (heap.isEmpty()) {
        count++;
        heap.add(interval[1]);
      } else {
        if (interval[0] >= heap.peek()) heap.poll();
        else count++;
        heap.add(interval[1]);
      }
    }
    return count;
  }

  public int minMeetingRooms2(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
    PriorityQueue<Integer> heap = new PriorityQueue<>();
    for (int[] interval : intervals) {
      if (!heap.isEmpty() && heap.peek() <= interval[0]) heap.poll();
      heap.add(interval[1]);
    }
    return heap.size();
  }
}
