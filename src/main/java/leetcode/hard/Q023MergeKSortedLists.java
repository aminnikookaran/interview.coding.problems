package leetcode.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import leetcode.ListNode;

// https://leetcode.com/problems/merge-k-sorted-lists/
public class Q023MergeKSortedLists {
  public ListNode mergeKLists1(ListNode[] lists) {
    List<Integer> list = new ArrayList<>();

    for (ListNode node : lists)
      while (node != null) {
        list.add(node.val);
        node = node.next;
      }

    Collections.sort(list);

    ListNode head = new ListNode(0);
    ListNode temp = head;
    for (int val : list) {
      ListNode node = new ListNode(val);
      temp.next = node;
      temp = temp.next;
    }
    temp.next = null;
    return head.next;
  }

  public ListNode mergeKLists2(ListNode[] lists) {
    int min_index = 0;
    ListNode head = new ListNode(0);
    ListNode temp = head;
    while (true) {
      boolean isBreak = true;
      int min = Integer.MAX_VALUE;
      for (int i = 0; i < lists.length; i++) {
        if (lists[i] != null) {
          if (lists[i].val < min) {
            min_index = i;
            min = lists[i].val;
          }
          isBreak = false;
        }
      }
      if (isBreak) break;
      ListNode node = new ListNode(lists[min_index].val);
      temp.next = node;
      temp = temp.next;
      lists[min_index] = lists[min_index].next;
    }
    temp.next = null;
    return head.next;
  }

  public ListNode mergeKLists3(ListNode[] lists) {
    int min_index = 0;
    ListNode head = new ListNode(0);
    ListNode temp = head;
    while (true) {
      boolean isBreak = true;
      int min = Integer.MAX_VALUE;
      for (int i = 0; i < lists.length; i++) {
        if (lists[i] != null) {
          if (lists[i].val < min) {
            min_index = i;
            min = lists[i].val;
          }
          isBreak = false;
        }
      }
      if (isBreak) break;
      temp.next = lists[min_index];
      temp = temp.next;
      lists[min_index] = lists[min_index].next;
    }
    temp.next = null;
    return head.next;
  }

  public ListNode mergeKLists4(ListNode[] lists) {
    Queue<ListNode> q = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
    for (ListNode l : lists) if (l != null) q.add(l);
    ListNode head = new ListNode(0);
    ListNode temp = head;
    while (!q.isEmpty()) {
      temp.next = q.poll();
      temp = temp.next;
      ListNode next = temp.next;
      if (next != null) q.add(next);
    }
    return head.next;
  }

  public ListNode mergeKLists5(ListNode[] lists) {
    if (lists.length == 0) return null;
    if (lists.length == 1) return lists[0];
    ListNode head = mergeTwoLists(lists[0], lists[1]);
    for (int i = 2; i < lists.length; i++) head = mergeTwoLists(head, lists[i]);
    return head;
  }

  public ListNode mergeKLists6(ListNode[] lists) {
    if (lists.length == 0) return null;
    int interval = 1;
    while (interval < lists.length) {
      for (int i = 0; i + interval < lists.length; i += interval * 2)
        lists[i] = mergeTwoLists(lists[i], lists[i + interval]);
      interval *= 2;
    }
    return lists[0];
  }

  public ListNode mergeKLists7(ListNode[] lists) {
    return mergeKList7(lists, 0, lists.length - 1);
  }

  public ListNode mergeKList7(ListNode[] lists, int start, int end) {
    if (start > end) return null;
    if (start == end) return lists[start];
    int middle = (end + start) / 2;
    ListNode leftList = mergeKList7(lists, start, middle);
    ListNode rightList = mergeKList7(lists, middle + 1, end);
    return mergeTwoLists(leftList, rightList);
  }

  public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    ListNode head = new ListNode(0);
    ListNode temp = head;
    while (list1 != null && list2 != null) {
      if (list1.val < list2.val) {
        temp.next = list1;
        temp = temp.next;
        list1 = list1.next;
      } else {
        temp.next = list2;
        temp = temp.next;
        list2 = list2.next;
      }
    }
    if (list1 == null) temp.next = list2;
    if (list2 == null) temp.next = list1;
    return head.next;
  }
}
