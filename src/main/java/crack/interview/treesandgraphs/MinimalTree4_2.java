package crack.interview.treesandgraphs;

import java.security.InvalidParameterException;
import java.util.Arrays;

public class MinimalTree4_2 {
/*Given a sorted (increasing order) array with unique integer elements, write an algorithm to create a binary search
tree with minimal height*/

//1) go left if < n.value and go right if it's > n.value

//2) keep splitting array by 2 recursively and distribute to left and right node
    //if i Arrays.copyOfRange, I will be 2^n * n/2 as n/2 is reducing 2^n
    // 1 2 3 4
    // 2
    //1  3
    //     4
    // 1 2 3 4 5
    //  3
    // 1    4
    //2   5

    static class Node {
        Node left = null, right = null;
        final int value;

        Node(int value) {
            this.value = value;
        }
    }

    private static Node createTree(int[] array) throws InvalidParameterException {
        if (array.length != 0) {
            int middle = array.length / 2;
            Node root = new Node(array[middle]);//1
            if (array.length != 1) {
                root.left = new Node(array[0]);
                root.right = new Node(array[middle + 1]);
                insert(root.left, Arrays.copyOfRange(array, 1, middle));
                insert(root.right, Arrays.copyOfRange(array, middle + 2, array.length));
            }
            return root;
        } else
            throw new InvalidParameterException("invalid array");
    }

    private static void insert(Node n, int[] array) {// 1
        int middle = (array.length) / 2;//0
        n.left = new Node(array[0]);//1
        n.right = new Node(array[middle]);//1
        if (array.length > 2) {
            insert(n.left, Arrays.copyOfRange(array, 1, middle));
            insert(n.right, Arrays.copyOfRange(array, middle + 1, array.length));
        }
    }

    private static void traverseInOrder(Node node) {
        if (node != null) {
            traverseInOrder(node.left);
            System.out.print(" " + node.value);
            traverseInOrder(node.right);
        }
    }

    public static void main(String[] args) {

        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7};
        traverseInOrder(createTree(array));
        System.out.println("");

        int[] array1 = new int[]{1};
        traverseInOrder(createTree(array1));
        System.out.println("");

        try {
            int[] array2 = new int[]{};
            traverseInOrder(createTree(array2));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        int[] array3 = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21,
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21,
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21,
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21,
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21,
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21,
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21,
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21,
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21,
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21
        };
        traverseInOrder(createTree(array3));

    }
}
