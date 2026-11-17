package cisco;

import cisco.data.SinglyLinkedListNode;

public class RemoveConsecutiveDuplicatesFromSortedLinkedList {
    public static SinglyLinkedListNode deleteDuplicates(SinglyLinkedListNode head) {
        // Write your code here
        if(head!=null){
            SinglyLinkedListNode node=head;

            while(node.next!=null){
                if(node.data==node.next.data){
                    node.next=node.next.next;

                }
                else
                    node= node.next;

            }
        }
        return head;

    }

}
