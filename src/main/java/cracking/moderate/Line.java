package cracking.moderate;

public class Line {
  public double slope, yintercept;

  public Line(Point start, Point end) {
    double deltaY = end.y - start.y;
    double deltaX = end.x - start.x;
    slope = deltaY / deltaX; // Will be Infinity (not exception) when deltaX 0
    yintercept = end.y - slope * end.x;
  }
}
