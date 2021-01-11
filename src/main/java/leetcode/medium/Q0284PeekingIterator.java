package leetcode.medium;

import java.util.Iterator;
import java.util.NoSuchElementException;

// https://leetcode.com/problems/peeking-iterator/
public class Q0284PeekingIterator {
  class PeekingIterator implements Iterator<Integer> {
    Integer next;
    Iterator<Integer> iterator;
    boolean noSuchElement;

    public PeekingIterator(Iterator<Integer> iterator) {
      // initialize any member here.
      this.iterator = iterator;
      advanceIterator();
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
      if (noSuchElement) throw new NoSuchElementException();
      return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
      if (noSuchElement) throw new NoSuchElementException();
      Integer result = next;
      advanceIterator();
      return result;
    }

    @Override
    public boolean hasNext() {
      return !noSuchElement;
    }

    private void advanceIterator() {
      if (iterator.hasNext()) next = iterator.next();
      else noSuchElement = true;
    }
  }
}
