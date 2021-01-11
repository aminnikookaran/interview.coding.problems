package leetcode.medium;

import java.util.Iterator;
import java.util.List;

// https://leetcode.com/problems/flatten-2d-vector/
public class Q0251Flatten2DVector {
  public class Vector2D implements Iterator<Integer> {
    int j;
    int i;
    List<List<Integer>> vec2d;

    public Vector2D(List<List<Integer>> vec2d) {
      i = 0;
      j = 0;
      this.vec2d = vec2d;
    }

    @Override
    public Integer next() {
      return vec2d.get(i).get(j++);
    }

    @Override
    public boolean hasNext() {
      while (i < vec2d.size())
        if (j < vec2d.get(i).size()) return true;
        else {
          i++;
          j = 0;
        }
      return false;
    }
  }
}
