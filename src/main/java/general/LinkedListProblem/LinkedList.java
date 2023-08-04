package general.LinkedListProblem;


public class LinkedList {
    Node head;

    class Node<T> {
        T data;
        Node next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    void insertAtHead(int data) {
        Node<Integer> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
    }

    void insertAtTail(int data) {
        Node newData = new Node(data);
        if (head == null) {
            head = newData;
            return;
        }
        Node cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = newData;
    }

    void insertAtPosition(int position, int data) {

        if (position == 1) {
            insertAtHead(data);
            return;
        }
        Node newNode = new Node(data);
        Node temp = head;
        int counter = 1;
        while (counter < position - 1) {
            temp = temp.next;
            counter++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }

    void deleteAtPosition(int position) {
        Node temp = head;
        if (position == 1) {
            head = head.next;

        } else {
            int counter = 1;
            while (counter < position - 1) {
                temp = temp.next;
                counter++;
            }
            temp.next = temp.next.next;
        }
    }

    Node reverse() {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    Node recursiveReverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node newHead = recursiveReverse(head.next);
        Node headNext = head.next;
        headNext.next = head;
        head.next = null;
        return newHead;
    }

    Node findMiddleElement() {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    boolean checkPallindrome(Node tail) {
        Node curr = head;
        while (tail != null) {
            if (head!=null && head.data != tail.data) {
                return false;
            }
            head = head.next;
            tail = tail.next;
        }
        return true;
    }

    void printList(Node node) {
        Node temp = node;
        while (temp != null) {
            System.out.print(temp.data);
            System.out.print(" ==> ");
            temp = temp.next;
        }
    }

    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            System.out.print(" ==> ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertAtTail(22);
        list.insertAtTail(45);
        list.insertAtTail(12);
        list.insertAtTail(45);
        list.insertAtTail(22);

        list.printList();
        Node midElement = list.findMiddleElement();
        Node head = list.recursiveReverse(midElement.next);
        System.out.println(list.checkPallindrome(head));
    }
}
