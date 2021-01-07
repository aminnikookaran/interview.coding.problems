package leetcode.easy;

// https://leetcode.com/problems/construct-the-rectangle/
public class Q0492ConstructTheRectangle {
  public int[] constructRectangle(int area) {
    int w = (int) Math.sqrt(area);
    while (area % w != 0) w--;
    return new int[] {area / w, w};
  }
}
