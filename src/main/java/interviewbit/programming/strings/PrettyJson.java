package interviewbit.programming.strings;

import java.util.ArrayList;
import java.util.List;

// https://www.interviewbit.com/problems/pretty-json/
public class PrettyJson {
  public static List<String> prettyJSON1(String A) {
    List<String> output = new ArrayList<String>();
    int indent = 0;
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < A.length(); i++) {
      if (A.charAt(i) == '[' || A.charAt(i) == '{') {
        if (stringBuilder.length() > indent) output.add(stringBuilder.toString());
        stringBuilder = new StringBuilder();
        for (int j = 0; j < indent; j++) stringBuilder.append("\t");
        stringBuilder.append(A.charAt(i));
        output.add(stringBuilder.toString());
        indent++;
        stringBuilder = new StringBuilder();
        for (int j = 0; j < indent; j++) stringBuilder.append("\t");
      } else if (A.charAt(i) == ']' || A.charAt(i) == '}') {
        output.add(stringBuilder.toString());
        indent--;
        stringBuilder = new StringBuilder();
        for (int j = 0; j < indent; j++) stringBuilder.append("\t");
        stringBuilder.append(A.charAt(i));
      } else if (A.charAt(i) == ',') {
        stringBuilder.append(A.charAt(i));
        output.add(stringBuilder.toString());
        stringBuilder = new StringBuilder();
        for (int j = 0; j < indent; j++) stringBuilder.append("\t");
      } else stringBuilder.append(A.charAt(i));
    }
    return output;
  }

  public static ArrayList<String> prettyJSON2(String a) {
    ArrayList<String> result = new ArrayList<String>();
    int tabCounter = 0;
    StringBuffer current = new StringBuffer();
    for (int i = 0; i < a.length(); i++) {
      char c = a.charAt(i);
      switch (c) {
        case '{':
        case '[':
          if (current.length() > 0) {
            result.add(current.toString());
            current = new StringBuffer();
          }
          for (int j = 0; j < tabCounter; j++) current.append('\t');
          current.append(c);
          result.add(current.toString());
          current = new StringBuffer();
          tabCounter++;
          break;

        case ']':
        case '}':
          if (current.length() > 0) {
            result.add(current.toString());
            current = new StringBuffer();
          }
          tabCounter--;
          for (int j = 0; j < tabCounter; j++) current.append('\t');
          current.append(c);
          break;

        case ',':
          current.append(c);
          result.add(current.toString());
          current = new StringBuffer();
          break;

        default:
          if (current.length() == 0) for (int j = 0; j < tabCounter; j++) current.append('\t');
          current.append(c);
      }
    }

    if (current.length() > 0) result.add(current.toString());

    return result;
  }

  public static ArrayList<String> prettyJSON3(String a) {
    int tabCount = 0;

    ArrayList<String> ans = new ArrayList<String>();

    for (int i = 0; i < a.length(); i++) {

      if (a.charAt(i) == '{' || a.charAt(i) == '[') {
        ans.add(get(tabCount).append(a.charAt(i)).toString());
        tabCount++;
      } else if (a.charAt(i) == '}' || a.charAt(i) == ']') {
        tabCount--;
        ans.add(get(tabCount).append(a.charAt(i)).toString());
      } else if (a.charAt(i) == ' ') {

      } else if (a.charAt(i) == ',') {
        ans.set(ans.size() - 1, ans.get(ans.size() - 1).concat(","));
      } else {
        int start = i;
        while (i < a.length()
            && (a.charAt(i) != ','
                && a.charAt(i) != '['
                && a.charAt(i) != '{'
                && a.charAt(i) != ']'
                && a.charAt(i) != '}')) {
          i++;
        }

        if (i >= a.length()) break;

        if (a.charAt(i) == ',') {
          ans.add(get(tabCount).toString() + a.substring(start, i + 1));
        } else if (a.charAt(i) == '}' || a.charAt(i) == ']') {
          ans.add(get(tabCount).toString() + a.substring(start, i));
          i--;
        } else if (a.charAt(i) == '{' || a.charAt(i) == '[') {
          ans.add(get(tabCount).toString() + a.substring(start, i));
          i--;
        }
      }
    }

    return ans;
  }

  public static StringBuilder get(int tabCount) {
    StringBuilder toAdd = new StringBuilder();
    for (int j = 0; j < tabCount; j++) toAdd.append('\t');
    return toAdd;
  }

  public static class Indent {
    char c;
    int tab;

    Indent(char c, int tab) {
      this.c = c;
      this.tab = tab;
    }
  }

  public static ArrayList<String> prettyJSON4(String a) {
    if (a == null || a.isEmpty()) return null;

    ArrayList<String> res = new ArrayList<String>();
    int indents = 0;
    int s = 0;
    boolean insideQuote = false;
    for (int i = 0; i < a.length(); i++) {
      char c = a.charAt(i);

      if (c == '"') {
        insideQuote = !insideQuote;
        continue;
      }
      if (insideQuote) continue;

      if (isOpen(c)) {
        createAndAdd(res, a, s, i - 1, indents);
        createAndAdd(res, a, i, i, indents);
        indents++;
        s = i + 1;
      } else if (isClose(c)) {
        createAndAdd(res, a, s, i - 1, indents);
        indents--;
        s = i;
        if (i == a.length() - 1 || (i < a.length() - 1 && a.charAt(i + 1) != ',')) {
          createAndAdd(res, a, i, i, indents);
          s = i + 1;
        }
      } else if (c == ',') {
        createAndAdd(res, a, s, i, indents);
        s = i + 1;
      }
    }

    return res;
  }

  public static void createAndAdd(ArrayList<String> res, String a, int s, int e, int indents) {
    if (s > e) return;

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < indents; i++) sb.append('\t');

    // skip leading spaces
    while (s <= e && a.charAt(s) == ' ') s++;

    // skip trailing spaces
    while (s <= e && a.charAt(e) == ' ') e--;

    while (s <= e) {
      sb.append(a.charAt(s));
      s++;
    }

    if (sb.length() > 0) res.add(sb.toString());
  }

  public static boolean isOpen(char c) {
    return c == '[' || c == '{';
  }

  public static boolean isClose(char c) {
    return c == ']' || c == '}';
  }

  public static void main(String[] args) {
    System.out.println(prettyJSON1("{A:\"B\",C:{D:\"E\",F:{G:\"H\",I:\"J\"}}}"));
  }
}
