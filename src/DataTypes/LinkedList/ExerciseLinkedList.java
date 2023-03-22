package DataTypes.LinkedList;

import java.util.HashSet;

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

        // TODO 21. Merge Two Sorted Lists

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
    // TODO 141. Linked List Cycle
        // Runtime 0ms
        //Memory beats 79%
        public boolean hasCycle(ListNode head) {

            ListNode slow = head;
            ListNode fast = head;

            while(fast != null && fast.next!=null){
                slow = slow.next;
                fast = fast.next.next;

                if(slow == fast) return true;

            }
            return false;
        }

        // TODO 142. Linked List Cycle II
        //Runtime 3ms
       // Memory beats 50%
        public ListNode detectCycle(ListNode head) {

            HashSet<ListNode> hashNode = new HashSet<>();

            ListNode pointer = head;

            while(pointer != null){
                if(hashNode.contains(pointer)) return pointer;
                hashNode.add(pointer);
                pointer = pointer.next;
            }
            return null;
        }

        // TODO 142. Linked List Cycle II SOLUTION 2
        //Runtime 0ms
        //Memory beats 72%
        public ListNode detectCycle2(ListNode head) {

            ListNode meetNode = isCycle(head);


            if(meetNode == null) return null;
            else {

                while(head != meetNode){
                    head = head.next;
                    meetNode = meetNode.next;
                }

                return meetNode;

            }


        }

        public ListNode isCycle(ListNode head){
            ListNode slow = head;
            ListNode fast = head;

            while(fast != null && fast.next!=null){
                slow = slow.next;
                fast = fast.next.next;

                if (slow == fast) return slow;
            }

            return null;
        }

        // TODO 143 Reorder List
        //https://leetcode.com/problems/reorder-list/description/
        // Runtime 1ms BEATS 100%
        // Memory beats 50%

        public void reorderList(ListNode head) {

            //Find the middle to divide the list

            ListNode slow=head; ListNode fast=head;

            if (head.next != null) {
                while(fast!=null && fast.next!=null){
                    slow = slow.next;
                    fast = fast.next.next;
                }

                ListNode half= reverse(slow.next);
                slow.next = null;
                ListNode firstHalf = head;

                while(half!=null){

                    ListNode tempFirst = firstHalf.next;
                    firstHalf.next = half;

                    ListNode tempSec = half.next;
                    half.next = tempFirst;

                    firstHalf = tempFirst;
                    half = tempSec;
                }
            }
        }

        public ListNode reverse(ListNode head){
            ListNode curr = head;
            ListNode prev = null; ListNode next=null;

            while(curr!=null){
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr=next;

            }
            return prev;
        }
        //TODO 2095. Delete the Middle Node of a Linked List
        //https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/description/
        //Runtime 3ms (beats 100%)
        // Memory beats 50%
        public ListNode deleteMiddle(ListNode head) {

            ListNode slow= head;
            ListNode fast = head;

            ListNode slowTemp = slow;

            if(head.next == null) return null;

            while(fast!= null && fast.next!=null){
                slowTemp = slow;
                slow = slow.next;
                fast = fast.next.next;
            }
            slowTemp.next = slow.next;

            return head;
        }
        //TODO 2095. Delete the Middle Node of a Linked List
        //https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/description/
        //Runtime 3ms (beats 100%)
        // Memory beats 92%
        public ListNode deleteMiddle2(ListNode head) {

            ListNode slow= head;
            ListNode fast = head;

            if(head.next == null) return null;

            if(head.next.next == null) {
                head.next = null;
                return head;
            }

            while(fast!= null && fast.next!=null){
                slow = slow.next;
                fast = fast.next.next;
            }

            slow.val = slow.next.val;
            slow.next = slow.next.next;

            return head;
        }

        // TODO 2. Add Two Numbers
        // Runtime 1ms (beats 1oo%)
        // Memory beats 83%
        //https://leetcode.com/problems/add-two-numbers/description/

        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

            ListNode newList = l1;
            boolean isEnd=false;

            while(!isEnd){

                if (l2 != null) {
                    newList.val +=l2.val;
                    l2 = l2.next;
                }

                if(newList.val > 9) {

                    newList.val -=10;

                    if(newList.next == null) {

                        ListNode newNode = new ListNode(1);
                        newList.next = newNode;

                    }else newList.next.val+=1;
                }

                if(newList.next == null) isEnd = true;
                else newList = newList.next;
            }

            if(l2 == null) return l1;

            else{
                newList.next = l2;
            }

            return l1;

        }

    /*    TODO 876. Middle of the Linked List EASY
        https://leetcode.com/problems/middle-of-the-linked-list/description/
        Runtime -0ms beats 100%
        Memory 39mb beats 96%*/

        public ListNode middleNode(ListNode head) {

            if(head == null) return null;

            ListNode slow = head;
            ListNode fast = head;

            while(fast != null && fast.next!= null){
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;

        }

        // TODO 160. Intersection of Two Linked Lists EASY
        //https://leetcode.com/problems/intersection-of-two-linked-lists/description/
        // runtine 1ms beats 98%
        // Memory 55.9 MB beats 5%
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

            int sizeA = length(headA);
            int sizeB = length(headB);

            if(sizeA > sizeB)  {headA = ajust(headA, sizeA-sizeB);}
            else if(sizeA < sizeB){headB = ajust(headB, sizeB-sizeA);}

            if(headA == headB) return headA;

            while(headA != headB){

                headA = headA.next;
                headB = headB.next;
            }
            return headA;

        }

        public int length(ListNode head){
            ListNode fast = head;
            ListNode slow = head;

            int size = 1;

            while(fast!=null && fast.next!=null){
                fast = fast.next.next;
                slow = slow.next;
                size+=2;
            }

            if(fast == null) size--;
            return size;

        }

        public ListNode ajust(ListNode head, int diff){

            while(diff>0){
                head = head.next;
                diff--;
            }

            return head;
        }

        // DELETE CURRENT NODE
        public void deleteNode(ListNode node) {

            while(node.next.next!=null){
                int val = node.next.val;
                node.val = val;
                node = node.next;
            }
            node.val = node.next.val;
            node.next = null;

        }
        // TODO 19. Remove Nth Node From End of List MEDIUM
        // https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
        // Runtime 0 ms Beats 100%
        // Memory 40.8 MB Beats 39.51%

        public ListNode removeNthFromEnd(ListNode head, int n) {
            ListNode curr = head;
            ListNode nPlace = head;

            int trackN = 0;

            while(curr!=null){
                curr = curr.next;
                trackN++;
                if(trackN >= n+2){
                    nPlace = nPlace.next;
                }
            }
            if(nPlace.next == null ) return null;

            if (trackN < n+1) {
                head = head.next;
            }
            else {
                nPlace.next = nPlace.next.next;
            }
            return head;
        }

        public ListNode removeNthFromEnd2(ListNode head, int n) {

            ListNode start = new ListNode(0);
            start.next = head;
            ListNode slow = start, fast = start;

            //Move fast in front so that the gap between slow and fast becomes n
            for(int i=1; i<=n+1; i++)   {
                fast = fast.next;
            }
            //Move fast to the end, maintaining the gap
            while(fast != null) {
                slow = slow.next;
                fast = fast.next;
            }
            //Skip the desired node
            slow.next = slow.next.next;
            return start.next;
        }

        // TODO 234. Palindrome Linked List EASY
        // https://leetcode.com/problems/palindrome-linked-list/description/
        public boolean isPalindrome(ListNode head) {

            ListNode normal = new ListNode();
            ListNode currNormal = normal;

            ListNode prev = null;
            ListNode curr = head;
            ListNode next = null;

            while(curr!=null){
                currNormal.next = new ListNode(curr.val);
                currNormal = currNormal.next;

                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            normal = normal.next;
            while(prev!= null && normal!=null){

                if(prev.val != normal.val) return false;
                prev = prev.next;
                normal = normal.next;
            }
            return true;
        }

        public static void main(String[] args) {

        }

    }
}
