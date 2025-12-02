package linkedlist;

/**
 * Отображение работы односвязного списка
 */
public class SinglyLinkedList {
    public static void main(String[] args) {
        // Вывод списка с использованием вспомогательной переменной ref

        Node head = headNode();

        print(head);

        Node newNode = new Node(8);

//        Node newHead = insertHead(newNode, head);
//        Node newHead = insertTail(newNode, head);
//        Node newHead = insertAfterNode(newNode, head, 2);
//        Node newHead = deleteHead(head);
//        Node newHead = deleteTail(head);
        Node newHead = deleteAfterNode(head, 2);

        print(newHead);
    }

    static Node headNode() {
        Node oneNode = new Node(1);
        Node oneTwo = new Node(2);
        Node oneThree = new Node(3);
        Node oneFour = new Node(4);
        Node oneFive = new Node(5);

        Node head = oneNode;

        oneNode.next = oneTwo;
        oneTwo.next = oneThree;
        oneThree.next = oneFour;
        oneFour.next = oneFive;

        return head;
    }

    static void print(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }

        System.out.println();
    }

    /*
    Вставка в голову списка
     */
    static Node insertHead(Node newNode, Node head) {
        newNode.next = head; // голова смещается на вторую позицию
        head = newNode;
        return head;
    }

    static Node insertTail(Node newNode, Node head) {
        Node ref = head;
        while (ref.next != null) {
            ref = ref.next;
        }

        ref.next = newNode;

        return head;
    }

    /*
    Вставка после Узла, после определенной ноды
     */
    static Node insertAfterNode(Node newNode, Node head, int index) {
        Node ref = head;
        for (int i = 0; i < index; i++) {
            ref = ref.next;
        }
        Node temp = ref.next;
        newNode.next = temp;
        ref.next = newNode;
       return head;
    }

    /*
    Удаление головы
     */
    static Node deleteHead(Node head) {
        head = head.next;
        return head;
    }

    /*
    Удаление хвоста
     */
    static Node deleteTail(Node head) {
        Node ref = head;
        while (ref.next.next != null) {
            ref = ref.next;
        }
        ref.next = null;
        return head;
    }

    /*
    Удаление узла после определенной ноды
     */
    static Node deleteAfterNode(Node head, int index) {
        Node ref = head;

        for (int i = 0; i < index; i++) {
            ref = ref.next;
        }

        ref.next = ref.next.next;

        return head;
    }

    static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }
}
