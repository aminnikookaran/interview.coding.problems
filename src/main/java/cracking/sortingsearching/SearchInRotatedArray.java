package cracking.sortingsearching;

public class SearchInRotatedArray {
  int search(int a[], int left, int right, int x) {
    int mid = (left + right) / 2;
    if (x == a[mid]) return mid; // Found element
    if (right < left) return -1;

    /*Either the left or right half must be normally ordered. Find out which side
     * is normally ordered, and then use the normally ordered half to figure out
     * which side to search to find x. */
    if (a[left] < a[mid]) { // Left is normally ordered.
      if (x >= a[left] && x < a[mid]) return search(a, left, mid - 1, x); // Search left
      else return search(a, mid + 1, right, x); // Search right
    } else if (a[mid] < a[left]) { // Right is normally ordered.
      if (x > a[mid] && x <= a[right]) return search(a, mid + 1, right, x); // Search right
      else return search(a, left, mid - 1, x); // Search left
    } else if (a[left] == a[mid]) { // Left or right half is all repeats
      if (a[mid] != a[right]) { // If right is different, search it
        return search(a, mid + 1, right, x); // search right
      } else { // Else, we have to search both halves
        int result = search(a, left, mid - 1, x); // Search left
        if (result == -1) return search(a, mid + 1, right, x); // Search right
        else return result;
      }
    }
    return -1;
  }
}
