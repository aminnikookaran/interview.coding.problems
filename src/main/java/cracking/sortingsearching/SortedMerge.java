package cracking.sortingsearching;

public class SortedMerge {
  void merge(int[] a, int[] b, int lastA, int lastB) {
    int indexA = lastA - 1; /* Index of last element in array a*/
    int indexB = lastB - 1; /* Index of last element in array b*/
    int indexMerged = lastB + lastA - 1; /* end of merged array*/

    /* Merge a and b, starting from the last element in each*/
    while (indexB >= 0) {
      /* end of a is > than end of b*/
      if (indexA >= 0 && a[indexA] > b[indexB]) {
        a[indexMerged] = a[indexA]; // copy element
        indexA--;
      } else {
        a[indexMerged] = b[indexB]; // copy element
        indexB--;
      }
      indexMerged--; // move indices
    }
  }
}
