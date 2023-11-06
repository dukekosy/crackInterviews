package crack.interview.trees;

public class PreOrder {

    private static final class Node {
        private final int value;
        Node left = null;
        Node right = null;
        Node(int value) {
            this.value = value;
        }
    }

    private void insert(Node node, int value) {
        //if not null value < go left
        //if left == null
        // left = new node value
        // else insert (node left value)
        //value > go right
        if (node != null) {
            if (value < node.left.value) {
                if (node.left == null) {
                    node.left = new Node(value);
                } else {
                    insert(node.left, value);
                }
            } else {
                if (node.right == null) {
                    node.right = new Node(value);
                } else {
                    insert(node.right, value);
                }
            }
        }
    }

    private void traversePreOrder(Node node) {
        if (node != null) {
            visit(node);
            traversePreOrder(node.left);
            traversePreOrder(node.right);
        }
    }

    private void visit(Node root) {

    }

    public static void main(String[] args) {
        PreOrder tree = new PreOrder();
        Node root = new Node(5);
        System.out.println("Binary Tree Example");
        System.out.println("Building tree with root value " + root.value);
        tree.insert(root, 2);
        tree.insert(root, 4);
        tree.insert(root, 4);
        tree.insert(root, 8);
        tree.insert(root, 6);
        tree.insert(root, 7);
        tree.insert(root, 3);
        tree.insert(root, 9);
        System.out.println("Traversing tree in order");
        tree.traversePreOrder(root);

    }

}
