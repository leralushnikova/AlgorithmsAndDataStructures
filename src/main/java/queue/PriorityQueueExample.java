package queue;

class Node {
    int data;        // данные
    int priority;   // приоритет узла
    Node next;      // ссылка на следующий элемент

    Node(int data, int priority) {
        this.data = data;
        this.priority = priority;
        this.next = null;
    }
}

/**
 * Пример работы очереди с приоритетом узлов
 */
public class PriorityQueueExample {
    static int peek(Node head) {
        return (head).data;
    }

    static Node pop(Node head) {
        Node temp = head;
        (head) = (head).next;
        return head;
    }

    static Node push(Node head, int d, int p) {
        Node start = (head);

        Node temp = new Node(d, p);

        if ((head).priority > p) {

            temp.next = head;
            (head) = temp;
        } else {

            while (start.next != null &&
                    start.next.priority < p) {
                start = start.next;
            }

            temp.next = start.next;
            start.next = temp;
        }
        return head;
    }

    static int isEmpty(Node head) {
        return ((head) == null) ? 1 : 0;
    }

    public static void main(String[] args) {
        // Создание приоритетной очереди в порядке возрастания
        Node pq = new Node(4, 1);
        pq =push(pq, 5, 2);
        pq =push(pq, 6, 3);
        pq =push(pq, 7, 0);
        while (isEmpty(pq)==0) {
            System.out.printf("%d ", peek(pq));
            pq=pop(pq);
        }
    }
}
