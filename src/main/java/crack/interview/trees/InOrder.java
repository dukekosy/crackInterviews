package crack.interview.trees;

/* transversing a binary tree in-order depth first */
// https://www.youtube.com/watch?v=6oL-0TdVy28&list=PL5tcWHG-UPH2fmYC6kgey1RIxP2iK9EEL&index=2&t=1s

public class InOrder {

    private static final class Node {
        private final int value;
        private Node left, right;

        Node(int value) {
            this.value = value;
            left = null;
            right = null;
        }

    }

    //2 4 8 6 7 3 9
    //5
    //l2                //r8
    //r4            //l6    //r9
    //l3                 //r7

//2 3 4 5 6 7 8 9
    // inserting data into the tree recursively
    // the value of each node in the tree to the left is always less than the value to the right.
    private void insert(Node node, int value) {
        if (value <= node.value) {//go left
            if (node.left != null) {//go 1 level deeper
                insert(node.left, value);
            } else {
                System.out.println(" Inserted " + value + " to left of " + node.value);
                node.left = new Node(value);
            }
        } else {//go right
            if (node.right != null) {//go 1 level deeper
                insert(node.right, value);
            } else {
                System.out.println("  Inserted " + value + " to right of "
                                           + node.value);
                node.right = new Node(value);
            }
        }
    }

    private int traverseInOrder(int ret, Node node) {
        if (ret == 7)
            return ret;
        if (node != null) {
            traverseInOrder(ret, node.left);
            ret = visit(node);
            if (ret == 7)
                return ret;
            traverseInOrder(ret, node.right);
        }
        return ret;
    }

    private int visit(Node node) {
        System.out.print(" " + node.value);
        return node.value;
    }

    public static void main(String[] args) {
        InOrder tree = new InOrder();
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
        System.out.println(tree.traverseInOrder(7, root));

    }
}