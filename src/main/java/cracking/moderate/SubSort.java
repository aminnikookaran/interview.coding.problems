package cracking.moderate;

public class SubSort {
  void findUnsortedSequence(int[] array) {
    // find left subsequence
    int endLeft = findEndOfLeftSubsequence(array);
    if (endLeft >= array.length - 1) return; // Already sorted

    // find right subsequence
    int startRight = findStartOfRightSubsequence(array);

    // get min and max
    int maxIndex = endLeft; // max of left side
    int minIndex = startRight; // min of right side
    for (int i = endLeft + 1; i < startRight; i++) {
      if (array[i] < array[minIndex]) minIndex = i;
      if (array[i] > array[maxIndex]) maxIndex = i;
    }

    // slide left until less than array[min_index]
    int leftIndex = shrinkLeft(array, minIndex, endLeft);

    // slide right until greater than array[max_index]
    int rightIndex = shrinkRight(array, maxIndex, startRight);

    System.out.println(leftIndex + " " + rightIndex);
  }

  int findEndOfLeftSubsequence(int[] array) {
    for (int i = 1; i < array.length; i++) if (array[i] < array[i - 1]) return i - 1;
    return array.length - 1;
  }

  int findStartOfRightSubsequence(int[] array) {
    for (int i = array.length - 2; i >= 0; i--) if (array[i] > array[i + 1]) return i + 1;
    return 0;
  }

  int shrinkLeft(int[] array, int minIndex, int start) {
    int comp = array[minIndex];
    for (int i = start - 1; i >= 0; i--) if (array[i] <= comp) return i + 1;
    return 0;
  }

  int shrinkRight(int[] array, int maxIndex, int start) {
    int comp = array[maxIndex];
    for (int i = start; i < array.length; i++) if (array[i] >= comp) return i - 1;
    return array.length - 1;
  }
}
