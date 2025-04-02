package DS;

import javax.swing.*;

public class MyLinkedList {

    Node head;

    static class Node {
        Node next;
        int data;

        Node(int d) {
            this.data = d;
            next = null;
        }
    }

    public static MyLinkedList insert(MyLinkedList list, int data) {
        Node newNode = new Node(data);
        if (list.head == null) {
            list.head = newNode;
        } else {
            // travel head ---> next null
            Node currentNode = list.head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }
        return list;
    }

    public static void print(MyLinkedList list) {

        Node head = list.head;
        if (head == null) {
            System.out.println("empty");
        }
        while (head != null) {
            System.out.println(head.data);
            head = head.next;
        }
    }

    public static void reverse(MyLinkedList list) {
        Node previous = null;
        Node current = list.head;
        Node next;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        list.head = previous;
    }

    public static void main(String[] args) {

        MyLinkedList list = new MyLinkedList();
        insert(list, 10);
        insert(list, 20);
        insert(list, 30);

        reverse(list);

        print(list);
    }
}
