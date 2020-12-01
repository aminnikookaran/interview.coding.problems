package hackerrank.algorithms.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://www.hackerrank.com/challenges/triple-sum/problem?h_l=interview&playlist_slugs%5B%5D%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D%5B%5D=search
public class TripleSum {
  public static long triplets1(int[] a, int[] b, int[] c) {
    Set<Integer> aset = new HashSet<>();
    Set<Integer> bset = new HashSet<>();
    Set<Integer> cset = new HashSet<>();
    for (int i = 0; i < a.length; i++) aset.add(a[i]);
    for (int i = 0; i < b.length; i++) bset.add(b[i]);
    for (int i = 0; i < c.length; i++) cset.add(c[i]);
    List<Integer> alist = new ArrayList<>(aset);
    List<Integer> blist = new ArrayList<>(bset);
    List<Integer> clist = new ArrayList<>(cset);
    Collections.sort(alist);
    Collections.sort(blist);
    Collections.sort(clist);
    long count = 0;
    int j = 0, k = 0;
    for (int i = 0; i < blist.size(); i++) {
      while (j < alist.size() && alist.get(j) <= blist.get(i)) j++;
      while (k < clist.size() && clist.get(k) <= blist.get(i)) k++;
      count += (long) j * (long) k;
    }
    return count;
  }

  public static long triplets2(int[] a, int[] b, int[] c) {
    int[] arr = Arrays.stream(a).distinct().sorted().toArray();
    int[] brr = Arrays.stream(b).distinct().sorted().toArray();
    int[] crr = Arrays.stream(c).distinct().sorted().toArray();
    long count = 0;
    int j = 0, k = 0;
    for (int i = 0; i < brr.length; i++) {
      while (j < arr.length && arr[j] <= brr[i]) j++;
      while (k < crr.length && crr[k] <= brr[i]) k++;
      count += (long) j * (long) k;
    }
    return count;
  }
}
