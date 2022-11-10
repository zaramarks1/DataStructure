package LinkedList;

public class ExerciseLinkedList {

    //Definition for singly-linked list.

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        // 21. Merge Two Sorted Lists

//         You are given the heads of two sorted linked lists list1 and list2.
//
//        Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.

        public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

            if (list1 == null) return list2;
            if (list2 == null) return list1;

            ListNode listNodeSorted = new ListNode(0);

            //listNodeSorted.val = list1.val < list2.val ? list1.val : list2.val;

            ListNode listNodeCurr = listNodeSorted;

            while (list1 != null && list2 != null) {
                if (list1.val < list2.val) {
                    listNodeCurr.next = list1;
                    list1 = list1.next;
                } else {
                    listNodeCurr.next = list2;
                    list2 = list2.next;
                }

                listNodeCurr = listNodeCurr.next;
            }

            listNodeCurr.next = list1 != null ? list1 : list2;

            return listNodeSorted.next;

        }


        public static void main(String[] args) {

        }

    }
}
