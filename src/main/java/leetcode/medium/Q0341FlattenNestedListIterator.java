package leetcode.medium;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import leetcode.NestedInteger;

// https://leetcode.com/problems/flatten-nested-list-iterator/
public class Q0341FlattenNestedListIterator {
  public class NestedIterator1 implements Iterator<Integer> {
    Stack<NestedInteger> stack = new Stack<NestedInteger>();

    public NestedIterator1(List<NestedInteger> nestedList) {
      if (nestedList == null) return;
      for (int i = nestedList.size() - 1; i >= 0; i--) stack.push(nestedList.get(i));
    }

    @Override
    public Integer next() {
      return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {
      while (!stack.isEmpty()) {
        NestedInteger top = stack.peek();
        if (top.isInteger()) return true;
        else {
          stack.pop();
          for (int i = top.getList().size() - 1; i >= 0; i--) stack.push(top.getList().get(i));
        }
      }
      return false;
    }
  }

  public class NestedIterator2 implements Iterator<Integer> {
    Stack<Iterator<NestedInteger>> stack = new Stack<Iterator<NestedInteger>>();
    Integer current;

    public NestedIterator2(List<NestedInteger> nestedList) {
      if (nestedList == null) return;
      stack.push(nestedList.iterator());
    }

    @Override
    public Integer next() {
      Integer result = current;
      current = null;
      return result;
    }

    @Override
    public boolean hasNext() {
      while (!stack.isEmpty() && current == null) {
        Iterator<NestedInteger> top = stack.peek();
        if (!top.hasNext()) {
          stack.pop();
          continue;
        }
        NestedInteger n = top.next();
        if (n.isInteger()) {
          current = n.getInteger();
          return true;
        } else stack.push(n.getList().iterator());
      }
      return false;
    }
  }
}
