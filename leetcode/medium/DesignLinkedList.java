/* 
707. Design Linked List 

Design your implementation of the linked list. You can choose to use a singly or doubly linked list.
A node in a singly linked list should have two attributes: val and next. val is the value of the current node, and next is a pointer/reference to the next node.
If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in the linked list. Assume all nodes in the linked list are 0-indexed. 

*/

// Singly Linked List
class MyLinkedList {
    ListNode head;
    int size;

    public MyLinkedList() {
        head = new ListNode(0);
        size = 0;
    }
    
    public int get(int index) {
        if (index < 0 || index >= size) return -1;

        ListNode current = head;
        for (int i = 0; i <= index; i++) {
            current = current.next;
        }
        return current.val;

    }
    
    public void addAtHead(int val) {
        addAtIndex(0, val);

    }
    
    public void addAtTail(int val) {
        addAtIndex(size, val);

    }
    
    public void addAtIndex(int index, int val) {
        if (index > size) return;
        if (index < 0) index = 0;

        ListNode pred = head;
        ListNode nodeToAdd = new ListNode(val);
        for (int i = 0; i < index; i++) {
            pred = pred.next;
        }
        nodeToAdd.next = pred.next;
        pred.next = nodeToAdd;
        size++;

    }
    
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;

        ListNode pred = head;
        for (int i = 0; i < index; i++) {
            pred = pred.next;
        }
        pred.next = pred.next.next;
        size--;

    }
}

class ListNode {
    int val;
    ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */