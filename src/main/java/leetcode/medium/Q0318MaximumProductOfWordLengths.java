package leetcode.medium;

// https://leetcode.com/problems/maximum-product-of-word-lengths/
public class Q0318MaximumProductOfWordLengths {
  public int maxProduct(String[] words) {
    if (words == null || words.length == 0) return 0;
    int[] arr = new int[words.length];
    for (int i = 0; i < words.length; i++)
      for (int j = 0; j < words[i].length(); j++) arr[i] |= (1 << (words[i].charAt(j) - 'a'));

    int result = 0;
    for (int i = 0; i < words.length; i++)
      for (int j = i + 1; j < words.length; j++)
        if ((arr[i] & arr[j]) == 0)
          result = Math.max(result, words[i].length() * words[j].length());

    return result;
  }
}
