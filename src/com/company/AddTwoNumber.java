package com.company;

import java.io.IOException;
import java.util.List;

/**
 * Created by xiangyongzhou on 18/7/11.
 */
public class AddTwoNumber {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            long list1 = 0;
            long list2 = 0;
            int counter = 0;
            while(true) {
                list1 += l1.val * Math.pow(10, counter);
                if (l1.next == null) {
                    break;
                }
                l1 = l1.next;
                counter++;
            }
            counter = 0;
            while(true) {
                list2 += l2.val * Math.pow(10, counter);
                if (l2.next == null) {
                    break;
                }
                l2 = l2.next;
                counter++;
            }
            long sum = list1 + list2;
            ListNode head = new ListNode(0);
            ListNode currentList = head;
            while (sum > 0) {
                currentList.val = (int) (sum % 10);
                sum = sum / 10;
                if (sum > 0) {
                    ListNode nextList = new ListNode(0);
                    currentList.next = nextList;
                    currentList = nextList;
                }
            }
            return head;
        }
    }

    public static void main(String[] args) throws IOException {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(1);
        ListNode l22 = new ListNode(9);
        l2.next = l22;
        ListNode l23 = new ListNode(9);
        l22.next = l23;
        ListNode l24 = new ListNode(9);
        l23.next = l24;
        ListNode l25 = new ListNode(9);
        l24.next = l25;
        ListNode l26 = new ListNode(9);
        l25.next = l26;
        ListNode l27 = new ListNode(9);
        l26.next = l27;
        ListNode l28 = new ListNode(9);
        l27.next = l28;
        ListNode l29 = new ListNode(9);
        l28.next = l29;
        ListNode l299 = new ListNode(9);
        l29.next = l299;
        solution.addTwoNumbers(l1, l2);
    }

}
