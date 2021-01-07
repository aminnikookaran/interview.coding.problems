package leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/implement-stack-using-queues/
public class Q0225ImplementStackUsingQueues {
  class MyStack1 {
    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();
    private int top;

    public MyStack1() {}

    public void push(int x) {
      q1.add(x);
      top = x;
    }

    public int pop() {
      while (q1.size() > 1) {
        top = q1.remove();
        q2.add(top);
      }
      int value = q1.remove();
      Queue<Integer> temp = q1;
      q1 = q2;
      q2 = temp;
      return value;
    }

    public int top() {
      return top;
    }

    public boolean empty() {
      return q1.isEmpty();
    }
  }

  class MyStack2 {
    private Queue<Integer> q1 = new LinkedList<>();
    private Queue<Integer> q2 = new LinkedList<>();
    private int top;

    public MyStack2() {}

    public void push(int x) {
      q2.add(x);
      top = x;
      while (!q1.isEmpty()) q2.add(q1.remove());
      Queue<Integer> temp = q1;
      q1 = q2;
      q2 = temp;
    }

    public int pop() {
      int value = q1.remove();
      if (!q1.isEmpty()) top = q1.peek();
      return value;
    }

    public int top() {
      return top;
    }

    public boolean empty() {
      return q1.isEmpty();
    }
  }

  class MyStack3 {
    private Queue<Integer> q1 = new LinkedList<>();

    public MyStack3() {}

    public void push(int x) {
      q1.add(x);
      int sz = q1.size();
      while (sz > 1) {
        q1.add(q1.remove());
        sz--;
      }
    }

    public int pop() {
      return q1.remove();
    }

    public int top() {
      return q1.peek();
    }

    public boolean empty() {
      return q1.isEmpty();
    }
  }
}
