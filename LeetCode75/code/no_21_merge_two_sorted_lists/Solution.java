package no_21_merge_two_sorted_lists;





class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = null;
        ListNode next = null;

        while (list1 != null || list2 != null) {
            int firstVal = Integer.MAX_VALUE;
            int secondVal = Integer.MAX_VALUE;

            if (list1 != null) {
                firstVal = list1.val;
            }

            if (list2 != null) {
                secondVal = list2.val;
            }

            if (firstVal <= secondVal) {
                if (head == null) {
                    head = list1;
                    next = list1;
                    list1 = list1.next;
                    continue;
                }

                next.next = list1;
                next = next.next;
                list1 = list1.next;
            }

            if (firstVal > secondVal) {
                if (head == null) {
                    head = list2;
                    next = list2;
                    list2 = list2.next;
                    continue;
                }

                next.next = list2;
                next = next.next;
                list2 = list2.next;
            }
        }

        return head;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        ListNode list1 = new ListNode(1,
                new ListNode(2,
                        new ListNode(4)));

        ListNode list2 = new ListNode(1,
                new ListNode(3,
                        new ListNode(4)));

        ListNode result = solution.mergeTwoLists(list1, list2);

        printList(result);
    }

    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) {
                System.out.print(" -> ");
            }
            head = head.next;
        }
        System.out.println();
    }
}