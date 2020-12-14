package cracking.moderate;

import java.util.List;
import java.util.Set;

public class BestLine {
  class GraphPoint {
    public int x;
    public int y;
  }
  /* Find line that goes through most number of points. */
  Line findBestLine(GraphPoint[] points) {
    HashMapList<Double, Line> linesBySlope = getListOfLines(points);
    return getBestLine(linesBySlope);
  }

  /* Add each pair of points as a line to the list. */
  HashMapList<Double, Line> getListOfLines(GraphPoint[] points) {
    HashMapList<Double, Line> linesBySlope = new HashMapList<Double, Line>();
    for (int i = 0; i < points.length; i++)
      for (int j = i + 1; j < points.length; j++) {
        Line line = new Line(points[i], points[j]);
        double key = Line.floorToNearestEpsilon(line.slope);
        linesBySlope.put(key, line);
      }

    return linesBySlope;
  }

  /* Return the line with the most equivalent other lines. */
  Line getBestLine(HashMapList<Double, Line> linesBySlope) {
    Line bestLine = null;
    int bestCount = 0;

    Set<Double> slopes = linesBySlope.keySet();

    for (double slope : slopes) {
      List<Line> lines = linesBySlope.get(slope);
      for (Line line : lines) {
        /* count lines that are equivalent to current line */
        int count = countEquivalentLines(linesBySlope, line);

        /* if better than current line, replace it */
        if (count > bestCount) {
          bestLine = line;
          bestCount = count;
          bestLine.Print();
          System.out.println(bestCount);
        }
      }
    }
    return bestLine;
  }

  /* Check hashmap for lines that are equivalent. Note that we need to check one
   * epsilon above and below the actual slope since we're defining two lines as
   * equivalent if they're within an epsilon of each other. */
  int countEquivalentLines(HashMapList<Double, Line> linesBySlope, Line line) {
    double key = Line.floorToNearestEpsilon(line.slope);
    int count = countEquivalentLines(linesBySlope.get(key), line);
    count += countEquivalentLines(linesBySlope.get(key - Line.epsilon), line);
    count += countEquivalentLines(linesBySlope.get(key + Line.epsilon), line);
    return count;
  }

  /* Count lines within an array of lines which are "equivalent" (slope and
   * y-intercept are within an epsilon value) to a given line */
  int countEquivalentLines(List<Line> lines, Line line) {
    if (lines == null) return 0;

    int count = 0;
    for (Line parallelLine : lines) if (parallelLine.isEquivalent(line)) count++;

    return count;
  }

  public static class Line {
    public static double epsilon = 0.0001;
    public double slope, intercept;
    private boolean infinite_slope = false;

    public Line(GraphPoint p, GraphPoint q) {
      if (Math.abs(p.x - q.x) > epsilon) { // if x's are different
        slope = (p.y - q.y) / (p.x - q.x); // compute slope
        intercept = p.y - slope * p.x; // u intercept from y = mx+b
      } else {
        infinite_slope = true;
        intercept = p.x; // x-intercept, since slope is infinite
      }
    }

    public void Print() {
      // TODO Auto-generated method stub

    }

    public static double floorToNearestEpsilon(double d) {
      int r = (int) (d / epsilon);
      return ((double) r) * epsilon;
    }

    public boolean isEquivalent(double a, double b) {
      return (Math.abs(a - b) < epsilon);
    }

    public boolean isEquivalent(Object o) {
      Line l = (Line) o;
      if (isEquivalent(l.slope, slope)
          && isEquivalent(l.intercept, intercept)
          && (infinite_slope == l.infinite_slope)) return true;

      return false;
    }
  }
}
