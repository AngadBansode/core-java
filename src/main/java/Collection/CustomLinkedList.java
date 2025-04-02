package Collection;

//  1->2->3->4->null
// Node -- data, next
public class CustomLinkedList {

    Node head;

    static class Node {

        int data;
        Node next;

        Node(int d) {
            this.data = d;
            this.next = null;
        }
    }

    //1->2->3->4->null
    public static CustomLinkedList insert(CustomLinkedList list, int data) {

        Node newNode = new Node(data);
        if (list.head == null) {
            list.head = newNode;
        } else {
            Node last = list.head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = newNode;
        }
        return list;
    }

    public static void print(CustomLinkedList list) {

        Node currentNode = list.head;
        while (currentNode != null) {
            System.out.println(currentNode.data);
            currentNode = currentNode.next;
        }
    }

    public static void printReverse(CustomLinkedList list) {

        Node currentNode = list.head;
        StringBuilder builder = new StringBuilder();
        while (currentNode != null) {
              builder.append(currentNode.data);
            currentNode = currentNode.next;
        }
        System.out.println(Integer.parseInt(builder.reverse().toString()  ));
    }

    public static void main(String[] args) {

        CustomLinkedList customLinkedList = new CustomLinkedList();
        insert(customLinkedList,1);
        insert(customLinkedList,2);
        insert(customLinkedList,3);
        insert(customLinkedList,4);
        insert(customLinkedList,5);

        printReverse(customLinkedList);
    }

}
