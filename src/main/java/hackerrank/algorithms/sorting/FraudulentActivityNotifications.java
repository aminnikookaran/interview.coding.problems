package hackerrank.algorithms.sorting;

// https://www.hackerrank.com/challenges/fraudulent-activity-notifications/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=sorting
public class FraudulentActivityNotifications {
  static int activityNotifications(int[] expenditure, int d) {
    int[] window = new int[201];
    for (int i = 0; i < d; i++) window[expenditure[i]]++;
    int id1 = (d - 1) / 2;
    int id2 = d / 2;
    int notif = 0;
    for (int i = d; i < expenditure.length; i++) {
      int count = 0;
      int j = 0;
      int med1 = -1;
      int med2 = -1;
      while (j <= 200) {
        if (med1 < 0 && count + window[j] > id1) med1 = j;
        if (count + window[j] > id2) {
          med2 = j;
          break;
        }
        count += window[j];
        j++;
      }
      if (expenditure[i] >= med1 + med2) notif++;
      window[expenditure[i - d]]--;
      window[expenditure[i]]++;
    }
    return notif;
  }

  public static void main(String[] args) {
    System.out.println(activityNotifications(new int[] {1, 2, 3, 4, 5}, 4));
  }
}
