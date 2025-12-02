package linkedlist;

public class DoublyLinkedList {

    public static void main(String[] args) {
        Node head = headNode();

        print(head);

        Node newNode = new Node(8);

//        Node newHead = insertAtFirst(newNode, head);
//        Node newHead = insertAtEnd(newNode, head);
//        Node newHead = insertAtNode(newNode, head, 2);
//        Node newHead = deleteAtFirst(head);
        Node newHead = deleteAtEnd(head);

        print(newHead);

//        System.out.println(newHead.prev);
    }

    static Node insertAtFirst(Node newNode, Node head) {
        newNode.next = head;
        head.prev = newNode;
        return newNode;
    }

    static Node insertAtEnd(Node newNode, Node head) {
        Node ref = head;

        while (ref.next != null) {
            ref = ref.next;
        }

        ref.next = newNode;

        return head;
    }

    static Node insertAtNode(Node newNode, Node head, int index) {
        Node ref = head;

        for (int i = 0; i < index; i++) {
            if(ref ==  null) return head;
            ref = ref.next;
        }

        Node temp = ref.next;
        ref.next = newNode;
        newNode.next = temp;
        newNode.prev = ref;

        return head;
    }

    static Node deleteAtFirst(Node head) {
        Node newNode = head.next;
        newNode.prev = null;
        return newNode;
    }

    static Node deleteAtEnd(Node head) {
        Node ref = head;

        while (ref.next.next != null) {
            ref = ref.next;
        }

        ref.next = null;

        return head;
    }

    static Node headNode() {
        Node nodeOne = new Node(1);
        Node nodeTwo = new Node(2);
        Node nodeThree = new Node(3);
        Node nodeFour = new Node(4);
        Node nodeFive = new Node(5);
        // Присвоение ссылок head и tail
        Node head = nodeOne;
        Node tail = nodeFour;
        // связывание узлов
        nodeOne.next = nodeTwo;

        nodeTwo.next = nodeThree;
        nodeTwo.prev = nodeOne;

        nodeThree.next = nodeFour;
        nodeThree.prev = nodeTwo;

        nodeFour.next = nodeFive;
        nodeFour.prev = nodeThree;

        nodeFive.prev = nodeFour;

        return head;
    }

    static void print(Node head) {
        Node ref = head;
        while (ref != null) {
            System.out.print(ref.data + " ");
            ref = ref.next;
        }
        System.out.println();
    }

    static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
}