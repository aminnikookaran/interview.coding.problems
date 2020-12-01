package cracking.recursiondynamicprogramming;

public class MagicIndex {
  public static int magicFast1(int[] array) {
    return magicFast1(array, 0, array.length - 1);
  }

  public static int magicFast1(int[] array, int start, int end) {
    if (end < start) return -1;
    int mid = (start + end) / 2;
    if (array[mid] == mid) return mid;
    else if (array[mid] > mid) return magicFast1(array, start, mid - 1);
    else return magicFast1(array, mid + 1, end);
  }

  public static int magicFast2(int[] array) {
    return magicFast2(array, 0, array.length - 1);
  }

  public static int magicFast2(int[] array, int start, int end) {
    if (end < start) return -1;
    int midIndex = (start + end) / 2;
    int midValue = array[midIndex];
    if (midValue == midIndex) return midIndex;
    /* Search left */
    int leftIndex = Math.min(midIndex - 1, midValue);
    int left = magicFast2(array, start, leftIndex);
    if (left >= 0) return left;
    /* Search right */
    int rightIndex = Math.max(midIndex + 1, midValue);
    int right = magicFast2(array, rightIndex, end);
    return right;
  }
}
