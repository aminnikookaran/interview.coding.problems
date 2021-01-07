package leetcode.easy;

import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// https://leetcode.com/problems/count-and-say/
public class Q0038CountAndSay {
  public String countAndSay1(int n) {
    if (n < 1) return "";
    String string = "1";
    for (int i = 2; i <= n; i++) {
      StringBuilder stringBuilder = new StringBuilder();
      int count = 1;
      for (int j = 1; j < string.length(); j++) {
        if (string.charAt(j) != string.charAt(j - 1)) {
          stringBuilder.append(count).append(string.charAt(j - 1));
          count = 1;
        } else count++;
      }
      stringBuilder.append(count).append(string.charAt(string.length() - 1));
      string = stringBuilder.toString();
    }
    return string;
  }

  public String countAndSay2(int n) {
    LinkedList<Integer> prevSeq = new LinkedList<Integer>();
    prevSeq.add(1);
    // Using -1 as the delimiter
    prevSeq.add(-1);

    List<Integer> finalSeq = this.nextSequence(n, prevSeq);
    StringBuffer seqStr = new StringBuffer();
    for (Integer digit : finalSeq) seqStr.append(String.valueOf(digit));

    return seqStr.toString();
  }

  protected LinkedList<Integer> nextSequence(int n, LinkedList<Integer> prevSeq) {
    if (n <= 1) {
      // remove the delimiter before return
      prevSeq.pollLast();
      return prevSeq;
    }

    LinkedList<Integer> nextSeq = new LinkedList<Integer>();
    Integer prevDigit = null;
    Integer digitCnt = 0;
    for (Integer digit : prevSeq) {
      if (prevDigit == null) {
        prevDigit = digit;
        digitCnt += 1;
      } else if (digit == prevDigit) {
        // in the middle of the sub-sequence
        digitCnt += 1;
      } else {
        // end of a sub-sequence
        nextSeq.add(digitCnt);
        nextSeq.add(prevDigit);
        // reset for the next sub-sequence
        prevDigit = digit;
        digitCnt = 1;
      }
    }

    // add the delimiter for the next recursion
    nextSeq.add(-1);
    return this.nextSequence(n - 1, nextSeq);
  }

  public String countAndSay3(int n) {
    String currSeq = "1";

    // Pattern to match the repetitive digits
    String regexPattern = "(.)\\1*";
    Pattern pattern = Pattern.compile(regexPattern);

    for (int i = 1; i < n; ++i) {
      Matcher m = pattern.matcher(currSeq);
      StringBuffer nextSeq = new StringBuffer();

      // each group contains identical and adjacent digits
      while (m.find()) nextSeq.append(m.group().length() + String.valueOf(m.group().charAt(0)));

      // prepare for the next iteration
      currSeq = nextSeq.toString();
    }

    return currSeq;
  }
}
