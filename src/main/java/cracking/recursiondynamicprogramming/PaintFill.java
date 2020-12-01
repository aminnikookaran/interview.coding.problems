package cracking.recursiondynamicprogramming;

public class PaintFill {
  enum Color {
    Black,
    White,
    Red,
    Yellow,
    Green
  }

  boolean PaintFill1(Color[][] screen, int r, int c, Color ncolor) {
    if (screen[r][c] == ncolor) return false;
    return PaintFill1(screen, r, c, screen[r][c], ncolor);
  }

  boolean PaintFill1(Color[][] screen, int r, int c, Color ocolor, Color ncolor) {
    if (r < 0 || r >= screen.length || c < 0 || c >= screen[0].length) return false;
    if (screen[r][c] == ocolor) {
      screen[r][c] = ncolor;
      PaintFill1(screen, r - 1, c, ocolor, ncolor); // up
      PaintFill1(screen, r + 1, c, ocolor, ncolor); // down
      PaintFill1(screen, r, c - 1, ocolor, ncolor); // left
      PaintFill1(screen, r, c + 1, ocolor, ncolor); // right
    }
    return true;
  }
}
