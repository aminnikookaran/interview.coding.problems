package cracking.recursiondynamicprogramming;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class StackOfBoxes {
  class Box {
    int width;
    int height;
    int depth;

    public boolean canBeAbove(Box bottom) {
      if (width < bottom.width && height < bottom.height && depth < bottom.depth) return true;
      return false;
    }
  }

  class BoxComparator implements Comparator<Box> {
    @Override
    public int compare(Box x, Box y) {
      return Integer.compare(y.height, x.height);
    }
  }

  int createStack1(List<Box> boxes) {
    Collections.sort(boxes, new BoxComparator());
    int maxHeight = 0;
    int[] stackMap = new int[boxes.size()];
    for (int i = 0; i < boxes.size(); i++) {
      int height = createStack1(boxes, i, stackMap);
      maxHeight = Math.max(maxHeight, height);
    }
    return maxHeight;
  }

  int createStack1(List<Box> boxes, int bottomIndex, int[] stackMap) {
    if (bottomIndex < boxes.size() && stackMap[bottomIndex] > 0) return stackMap[bottomIndex];

    Box bottom = boxes.get(bottomIndex);
    int maxHeight = 0;
    for (int i = bottomIndex + 1; i < boxes.size(); i++) {
      if (boxes.get(i).canBeAbove(bottom)) {
        int height = createStack1(boxes, i, stackMap);
        maxHeight = Math.max(height, maxHeight);
      }
    }
    maxHeight += bottom.height;
    stackMap[bottomIndex] = maxHeight;
    return maxHeight;
  }

  int createStack2(List<Box> boxes) {
    Collections.sort(boxes, new BoxComparator());
    int[] stackMap = new int[boxes.size()];
    return createStack2(boxes, null, 0, stackMap);
  }

  int createStack2(List<Box> boxes, Box bottom, int offset, int[] stackMap) {
    if (offset >= boxes.size()) return 0; // Base case

    /*height with this bottom*/
    Box newBottom = boxes.get(offset);
    int heightWithBottom = 0;
    if (bottom == null || newBottom.canBeAbove(bottom)) {
      if (stackMap[offset] == 0) {
        stackMap[offset] = createStack2(boxes, newBottom, offset + 1, stackMap);
        stackMap[offset] += newBottom.height;
      }
      heightWithBottom = stackMap[offset];
    }

    /*without this bottom*/
    int heightWithoutBottom = createStack2(boxes, bottom, offset + 1, stackMap);
    /* Return better of two options. */
    return Math.max(heightWithBottom, heightWithoutBottom);
  }
}
