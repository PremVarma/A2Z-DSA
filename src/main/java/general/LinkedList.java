package general;

import java.util.HashMap;

public class LinkedList {
    public static void traverse(Node head) {
        System.out.println("================PRINT ST=============");
        Node curr = head;
        while (curr != null) {
            System.out.println(curr.data);
            curr = curr.next;
        }
        System.out.println("================PRINT EN=============");
    }

    public static Node insert(Node head, int pos, String data) {
        Node newElement = new Node(data);
        if (pos == 0) {
            newElement.next = head;
            head = newElement;
            return head;
        }
        Node prev = head;
        for (int i = 0; i < pos - 1; i++) {
            prev = prev.next;
        }
        newElement.next = prev.next;
        prev.next = newElement;
        return head;
    }

    public static Node delete(Node head, int pos) {
        if (pos == 0) {
            head = head.next;
            return head;
        }
        Node curr = head;
        for (int i = 0; i < pos - 1; i++) {
            curr = curr.next;
        }
        curr.next = curr.next.next;
        return head;
    }

    public static Node deleteByData(Node head, String data) {
        if (head.data == data) {
            head = head.next;
            return head;
        }
        Node prev = head;
        while (prev.next.data != data) {
            prev = prev.next;
        }
        prev.next = prev.next.next;
        return head;
    }

    public static Node reverse(Node head) {
        Node curr = head, prev = null;
        while (curr != null) {
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
    public static Node recursiveReverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node lastNode = recursiveReverse(head.next);
        Node headNode = head.next;
        headNode.next = head;
        head.next = null;
        return lastNode;
    }

    public static Node middleElement(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void push(Node head, String data) {
        Node newNode = new Node(data);
        Node curr = head;
        while (curr != null && curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
    }

    public static void findAndRemoveCycle(Node head) {
        if (head == null || head.next == null) {
            return;
        }
        Node slow = head, fast = head, prev = null;
        while (slow != null && fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                System.out.println(prev.data);
                break;
            }
        }
        System.out.println(slow.data + " " +
                "" + fast.data);
    }

    public static boolean checkPallindrome(Node head) {
        if (head == null || head.next == null) {
            return true;
        }
        Node curr = head;
        Node midElement = middleElement(head);
        Node lastElement = reverse(midElement.next);
        while (lastElement != null && lastElement.next != null) {
            if (curr.data != lastElement.data) {
                return false;
            }
            lastElement = lastElement.next;
            curr = curr.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Node n1 = new Node("Prem");
        Node n2 = new Node("Abhijit");
        Node n3 = new Node("Mithil");
        Node n4 = new Node("Ramu");
        Node head = n1;
        head.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n2;
//        push(head, "Abhijit");
//        push(head, "Prem");
//        head = delete(head, 0);
//        traverse(head);
//        head = deleteByData(head, "Mithil");
//        traverse(head);
//        head = reverse(head);
//        traverse(head);
//        head = recursiveReverse(head);
//        traverse(head);
//        Node middle = middleElement(head);
//        System.out.println(middle.data);
//        push(head,"Test");
//        traverse(head);
//        System.out.println(checkPallindrome(head));
        findAndRemoveCycle(head);
    }

    static class Node<T> {

        Node next;
        T data;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
}
