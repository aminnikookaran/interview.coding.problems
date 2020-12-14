package cracking.bitmanipulation;

import java.util.ArrayList;
import java.util.List;

public class FlipBitToWin {
  int longestSequence(int n) {
    if (n == -1) return Integer.BYTES * 8;
    List<Integer> sequences = getAlternatingSequences(n);
    return findLongestSequence(sequences);
  }
  
  /* Return a list of the sizes of the sequences. The sequence starts off with the
  number of 0s (which might be 0) and then alternates with the counts of each
  value.*/
  List<Integer> getAlternatingSequences(int n) {
    List<Integer> sequences = new ArrayList<Integer>();

    int searchingFor = 0;
    int counter = 0;

    for (int i = 0; i < Integer.BYTES * 8; i++) {
      if ((n & 1) != searchingFor) {
        sequences.add(counter);
        searchingFor = n & 1; // Flip 1 to 0 or 0 to 1
        counter = 0;
      }
      counter++;
      n >>>= 1;
    }
    sequences.add(counter);

    return sequences;
  }

  /* Given the lengths of alternating sequences of 0s and 1s, find the longest one
   * we can build. */
  int findLongestSequence(List<Integer> seq) {
    int maxSeq = 1;

    for (int i = 0; i < seq.size(); i += 2) {
      int zerosSeq = seq.get(i);
      int onesSeqRight = i - 1 >= 0 ? seq.get(i - 1) : 0;
      int onesSeqLeft = i + 1 < seq.size() ? seq.get(i + 1) : 0;
      int thisSeq = 0;
      if (zerosSeq == 1) thisSeq = onesSeqLeft + 1 + onesSeqRight; // Can merge

      if (zerosSeq > 1)
        thisSeq = 1 + Math.max(onesSeqRight, onesSeqLeft); // Just add a zero to either side
      else if (zerosSeq == 0)
        thisSeq = Math.max(onesSeqRight, onesSeqLeft); // No zero, but take either side

      maxSeq = Math.max(thisSeq, maxSeq);
    }

    return maxSeq;
  }

  int flipBit(int a) {
    /* If all 1s, this is already the longest sequence. */
    if (~a == 0) return Integer.BYTES * 8;

    int currentLength = 0;
    int previousLength = 0;
    int maxLength = 1; // We can always have a sequence of at least one 1
    while (a != 0) {
      if ((a & 1) == 1) { // Current bit is a 1
        currentLength++;
      } else if ((a & 1) == 0) { // Current bit is a 0
        /* Update to 0 (if next bit is 0) or currentLength (if next bit is 1). */
        previousLength = (a & 2) == 0 ? 0 : currentLength;
        currentLength = 0;
      }
      maxLength = Math.max(previousLength + currentLength + 1, maxLength);
      a >>>= 1;
    }
    return maxLength;
  }
}
