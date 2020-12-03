package cracking.sortingsearching;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class MissingInt {
  long numberOfInts = ((long) Integer.MAX_VALUE) + 1;
  byte[] bitfield = new byte[(int) (numberOfInts / 8)];
  String filename = "";

  void findOpenNumber1() throws FileNotFoundException {
    Scanner in = new Scanner(new FileReader(filename));
    while (in.hasNextInt()) {
      int n = in.nextInt();
      /* Finds the corresponding number in the bitfield by using the OR operator to
       * set the nth bit of a byte (e.g., 10 would correspond to the 2nd bit of
       * index 2 in the byte array). */
      bitfield[n / 8] |= 1 << (n % 8);
    }

    for (int i = 0; i < bitfield.length; i++) {
      for (int j = 0; j < 8; j++) {
        /* Retrieves the individual bits of each byte. When 0 bit is found, print
         * the corresponding value. */
        if ((bitfield[i] & (1 << j)) == 0) {
          System.out.println(i * 8 + j);
          return;
        }
      }
    }
  }

  int findOpenNumber(String filename) throws FileNotFoundException {
    int rangeSize = (1 << 20); // 2^20 bits (2^17 bytes)
    /* Get count of number of values within each block. */
    int[] blocks = getCountPerBlock(filename, rangeSize);
    /* Find a block with a missing value. */
    int blockIndex = findBlockWithMissing(blocks, rangeSize);
    if (blockIndex < 0) return -1;
    /* Create bit vector for items within this range. */
    byte[] bitVector = getBitVectorForRange(filename, blockIndex, rangeSize);
    /* Find a zero in the bit vector */
    int offset = findZero(bitVector);
    if (offset < 0) return -1;
    /* Compute missing value. */
    return blockIndex * rangeSize + offset;
  }

  /* Get count of items within each range. */
  int[] getCountPerBlock(String filename, int rangeSize) throws FileNotFoundException {
    int arraySize = Integer.MAX_VALUE / rangeSize + 1;
    int[] blocks = new int[arraySize];
    Scanner in = new Scanner(new FileReader(filename));
    while (in.hasNextInt()) {
      int value = in.nextInt();
      blocks[value / rangeSize]++;
    }
    in.close();
    return blocks;
  }

  /* Find a block whose count is low. */
  int findBlockWithMissing(int[] blocks, int rangeSize) {
    for (int i = 0; i < blocks.length; i++) if (blocks[i] < rangeSize) return i;
    return -1;
  }

  /* Create a bit vector for the values within a specific range. */
  byte[] getBitVectorForRange(String filename, int blockindex, int rangeSize)
      throws FileNotFoundException {
    int startRange = blockindex * rangeSize;
    int endRange = startRange + rangeSize;
    byte[] bitVector = new byte[rangeSize / Byte.SIZE];
    Scanner in = new Scanner(new FileReader(filename));
    while (in.hasNextInt()) {
      int value = in.nextInt();
      /* If the number is inside the block that's missing numbers, we record it */
      if (startRange <= value && value < endRange) {
        int offset = value - startRange;
        int mask = (1 << (offset % Byte.SIZE));
        bitVector[offset / Byte.SIZE] |= mask;
      }
    }
    in.close();
    return bitVector;
  }

  /*Find bit index that is 0 within byte. */
  int findZero(byte b) {
    for (int i = 0; i < Byte.SIZE; i++) {
      int mask = 1 << i;
      if ((b & mask) == 0) return i;
    }
    return -1;
  }

  /*Find a zero within the bit vector and return the index. */
  int findZero(byte[] bitVector) {
    for (int i = 0; i < bitVector.length; i++)
      if (bitVector[i] != ~0) { // If not all 1s
        int bitindex = findZero(bitVector[i]);
        return i * Byte.SIZE + bitindex;
      }
    return -1;
  }
}
