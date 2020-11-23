package cracking.arraysstrings;

public class StringRotation {
  boolean isRotation(String sl, String s2) {
    int len = sl.length();
    /* Check that sl and s2 are equal length and not empty*/
    if (len == s2.length() && len > 0) {
      /* Concatenate sl and sl within new buffer */
      String slsl = sl + sl;
      return isSubstring(slsl, s2);
    }
    return false;
  }

  private boolean isSubstring(String slsl, String s2) {
    return slsl.contains(s2);
  }
}
