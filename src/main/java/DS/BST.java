package DS;

public class BST {

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(8);
        tree.insert(7);
        tree.insert(12);
        tree.insert(15);
        tree.insert(2);
        tree.insert(5);

        tree.inOrder();
    }
}

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
    }
}

class BinaryTree {
    Node root;

    public void insert(int data) {

        root = insertRec(root, data);

    }

    public Node insertRec(Node root, int data) {
        if (root == null)
            root = new Node(data);
        else if (data < root.data)
            root.left = insertRec(root.left, data);
        else if (data > root.data)
            root.right = insertRec(root.right, data);

        return root;
    }

    public void inOrder() {

        inOrderRec(root);
    }

    private void inOrderRec(Node root) {

        if (root != null) {
            inOrderRec(root.left);
            System.out.print(root.data + "\t");
            inOrderRec(root.right);
        }

    }
}

