package cisco;


import cisco.data.SinglyLinkedListNode;

public class RemoveKthNodeFromEnd {

    public static SinglyLinkedListNode removeKthNode(SinglyLinkedListNode head, int k) {
        if (k == 1) {
            return head.next;
        }
        SinglyLinkedListNode prevNode = head;
        SinglyLinkedListNode currentNode = head.next;

        for (int i = 2; i <= k; i++) {
            if (i == k) {
                if (currentNode == null)
                    prevNode.next = null;

                else {
                    prevNode.next = currentNode.next;

                }
            } else {
                prevNode = currentNode;
                currentNode = currentNode.next;
            }

        }
        return head;
    }

    public static SinglyLinkedListNode removeKthNodeFromEnd(SinglyLinkedListNode head, int k) {
        SinglyLinkedListNode kthNote = head;
        SinglyLinkedListNode currentNode = head;
        int count = 0;
        while (currentNode.next != null) {
            if (count > k)
                kthNote = currentNode;

            currentNode = currentNode.next;
            count++;
        }

        if (count < k)
            return head;

        kthNote.next = kthNote.next.next;

        return head;
    }

    public static SinglyLinkedListNode removeKthNodeFromEndAI(SinglyLinkedListNode head, int k) {
        // Safe check for invalid k boundary conditions
        if (head == null || k < 0) {
            return head;
        }

        // Initialize a dummy node to cleanly handle deletion of the head node
        SinglyLinkedListNode dummy = new SinglyLinkedListNode(0);
        dummy.next = head;

        SinglyLinkedListNode fast = dummy;
        SinglyLinkedListNode slow = dummy;

        // Step 1: Move the fast pointer k steps ahead
        for (int i = 0; i <= k; i++) {
            fast = fast.next;
            // If fast reaches null before completing k steps, k is greater than list length (invalid)
            if (fast == null) {
                return head;
            }
        }

        // Step 2: Advance both pointers until fast reaches the last node
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        // Step 3: Delete the target node by skipping over it
        if (slow.next != null) {
            slow.next = slow.next.next;
        }

        // Return the true modified head of the list
        return dummy.next;

    }

    static void main() {

    }
}
