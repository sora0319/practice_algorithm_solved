package no_206_reverse_linked_list;

class Solution {

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode prevNode = null;
        ListNode nextNode = null;

        while (true) {
            nextNode = head.next;
            head.next = prevNode;
            prevNode = head;

            if (nextNode == null) {
                break;
            }

            head = nextNode;
        }

        return head;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(
                1,
                new ListNode(
                        2,
                        new ListNode(
                                3,
                                new ListNode(
                                        4,
                                        new ListNode(5)
                                )
                        )
                )
        );

        System.out.print("원본 리스트: ");
        printList(head);

        ListNode reversed = solution.reverseList(head);

        System.out.print("뒤집은 리스트: ");
        printList(reversed);
    }

    private static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val);
            if (node.next != null) {
                System.out.print(" -> ");
            }
            node = node.next;
        }
        System.out.println();
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}