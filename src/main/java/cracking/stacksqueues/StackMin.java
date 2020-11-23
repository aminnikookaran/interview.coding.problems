package cracking.stacksqueues;

import java.util.Stack;

public class StackMin {
  public class StackWithMin extends Stack<NodeWithMin> {
    private static final long serialVersionUID = 1L;

    public void push(int value) {
      int newMin = Math.min(value, min());
      super.push(new NodeWithMin(value, newMin));
    }

    public int min() {
      if (this.isEmpty()) return Integer.MAX_VALUE; // Error value
      else return peek().min;
    }
  }

  class NodeWithMin {
    public int value;
    public int min;

    public NodeWithMin(int v, int min) {
      value = v;
      this.min = min;
    }
  }

  public class StackWithMin2 extends Stack<Integer> {
    private static final long serialVersionUID = 1L;
    Stack<Integer> s2;

    public StackWithMin2() {
      s2 = new Stack<Integer>();
    }

    public void push(int value) {
      if (value <= min()) s2.push(value);
      super.push(value);
    }

    public Integer pop() {
      int value = super.pop();
      if (value == min()) s2.pop();
      return value;
    }

    public int min() {
      if (s2.isEmpty()) return Integer.MAX_VALUE;
      else return s2.peek();
    }
  }
}
