package leetcode.easy;

import java.util.Stack;

// https://leetcode.com/problems/min-stack/
public class Q0155MinStack {
  class MinStack1 {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    int min;

    /** initialize your data structure here. */
    public MinStack1() {
      stack = new Stack<>();
      minStack = new Stack<>();
      min = Integer.MAX_VALUE;
    }

    public void push(int x) {
      min = Math.min(min, x);
      minStack.push(min);
      stack.push(x);
    }

    public void pop() {
      minStack.pop();
      stack.pop();
      if (!minStack.isEmpty()) min = minStack.peek();
      else min = Integer.MAX_VALUE;
    }

    public int top() {
      return stack.peek();
    }

    public int getMin() {
      return min;
    }
  }

  class Elem {
    public int value;
    public int min;
    public Elem next;

    public Elem(int value, int min) {
      this.value = value;
      this.min = min;
    }
  }

  public class MinStack {
    public Elem top;
    /** initialize your data structure here. */
    public MinStack() {}

    public void push(int x) {
      if (top == null) top = new Elem(x, x);
      else {
        Elem e = new Elem(x, Math.min(x, top.min));
        e.next = top;
        top = e;
      }
    }

    public void pop() {
      if (top == null) return;
      Elem temp = top.next;
      top.next = null;
      top = temp;
    }

    public int top() {
      if (top == null) return -1;
      return top.value;
    }

    public int getMin() {
      if (top == null) return -1;
      return top.min;
    }
  }
}
