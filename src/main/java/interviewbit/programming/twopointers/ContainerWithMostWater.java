package interviewbit.programming.twopointers;

import java.util.List;

public class ContainerWithMostWater {
  public int maxArea(List<Integer> A) {
    int i = 0;
    int j = A.size() - 1;
    int maxSize = 0;
    while (i < j) {
      int size = Math.min(A.get(i), A.get(j)) * (j - i);
      if (size > maxSize) maxSize = size;
      if (A.get(i) < A.get(j)) i++;
      else j--;
    }
    return maxSize;
  }
}
