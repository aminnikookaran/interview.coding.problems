package leetcode.medium;

// https://leetcode.com/problems/utf-8-validation/
public class Q0393UTF8Validation {
  public boolean validUtf81(int[] data) {
    int numberOfBytesToProcess = 0;
    for (int i = 0; i < data.length; i++) {
      String binRep = Integer.toBinaryString(data[i]);
      binRep =
          binRep.length() >= 8
              ? binRep.substring(binRep.length() - 8)
              : "00000000".substring(binRep.length() % 8) + binRep;

      if (numberOfBytesToProcess == 0) {
        for (int j = 0; j < binRep.length(); j++) {
          if (binRep.charAt(j) == '0') break;
          numberOfBytesToProcess += 1;
        }
        if (numberOfBytesToProcess == 0) continue;
        if (numberOfBytesToProcess > 4 || numberOfBytesToProcess == 1) return false;
      } else if (!(binRep.charAt(0) == '1' && binRep.charAt(1) == '0')) return false;
      numberOfBytesToProcess -= 1;
    }
    return numberOfBytesToProcess == 0;
  }

  public boolean validUtf82(int[] data) {
    int numberOfBytesToProcess = 0;
    int mask1 = 1 << 7;
    int mask2 = 1 << 6;
    for (int i = 0; i < data.length; i++) {
      if (numberOfBytesToProcess == 0) {
        int mask = 1 << 7;
        while ((mask & data[i]) != 0) {
          numberOfBytesToProcess += 1;
          mask = mask >> 1;
        }
        if (numberOfBytesToProcess == 0) continue;
        if (numberOfBytesToProcess > 4 || numberOfBytesToProcess == 1) return false;
      } else if (!((data[i] & mask1) != 0 && (mask2 & data[i]) == 0)) return false;
      numberOfBytesToProcess -= 1;
    }
    return numberOfBytesToProcess == 0;
  }
}
