package problems.warmup;

public class TimeConversionProblem {
  public static String timeConversion(String s) {
    int hour = Integer.parseInt(s.substring(0, 2));
    if (s.contains("PM") && hour != 12) s = String.valueOf(hour + 12) + s.substring(2);
    else if (s.contains("AM") && hour == 12) s = "00" + s.substring(2);
    return s.replace("PM", "").replace("AM", "");
  }

  public static void main(String[] args) {
    System.out.println(timeConversion("07:05:45PM"));
  }
}
