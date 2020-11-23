package cracking.arraysstrings;

public class OneAway {
  public static boolean oneEditAway1(String first, String second) {
    if (first.length() == second.length()) return oneEditReplace(first, second);
    else if (first.length() + 1 == second.length()) return oneEditinsert(first, second);
    else if (first.length() - 1 == second.length()) return oneEditinsert(second, first);
    return false;
  }

  public static boolean oneEditReplace(String sl, String s2) {
    boolean foundDifference = false;
    for (int i = 0; i < sl.length(); i++)
      if (sl.charAt(i) != s2.charAt(i)) {
        if (foundDifference) return false;
        foundDifference = true;
      }
    return true;
  }

  /* Check if you can insert a character into sl to make s2. */
  public static boolean oneEditinsert(String sl, String s2) {
    int indexl = 0;
    int index2 = 0;
    while (index2 < s2.length() && indexl < sl.length()) {
      if (sl.charAt(indexl) != s2.charAt(index2)) {
        if (indexl != index2) return false;
        index2++;
      } else {
        indexl++;
        index2++;
      }
    }
    return true;
  }

  public static boolean oneEditAway2(String first, String second) {
    /* Length checks. */
    if (Math.abs(first.length() - second.length()) > 1) return false;

    /* Get shorter and longer string.*/
    String sl = first.length() < second.length() ? first : second;
    String s2 = first.length() < second.length() ? second : first;

    int indexl = 0;
    int index2 = 0;
    boolean foundDifference = false;
    while (index2 < s2.length() && indexl < sl.length()) {
      if (sl.charAt(indexl) != s2.charAt(index2)) {
        /* Ensure that this is the first difference found.*/
        if (foundDifference) return false;
        foundDifference = true;
        if (sl.length() == s2.length()) indexl++; // On replace, move shorter pointer
      } else indexl++; // If matching, move shorter pointer
      index2++; // Always move pointer for longer string
    }
    return true;
  }
}
