package crack.interview.trees;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class SimplerSolution {

    private static class Node {

        private Node left = null;
        private Node right = null;
        private int data = 0;

        Node() {
            this.data = 0;
        }

        Node(int data) {
            this.data = data;
        }
    }
    
    Set<Integer> depthSet = new HashSet<>();
    void preOrder(Node n, int depth) {
        if (n!=null) {
            depth = visit(n, depth);
            preOrder(n.left, depth);
            preOrder(n.right, depth);
        }
    }

    int visit(Node node, int depth) {
        depthSet.add(depth);
        return ++depth;
    }
    private int visibleNodes(SimplerSolution.Node root) {
        // Write your code here
        preOrder(root, 0);
        return depthSet.size();
    }

    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    int test_case_number = 1;

    void check(int expected, int output) {
        boolean result = (expected == output);
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        } else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printInteger(expected);
            System.out.print(" Your output: ");
            printInteger(output);
            System.out.println();
        }
        test_case_number++;
    }

    void printInteger(int n) {
        System.out.print("[" + n + "]");
    }

    public void run() throws IOException {


        Node root_1 = new Node(8);
        root_1.left = new Node(3);
        root_1.right = new Node(10);
        root_1.left.left = new Node(1);
        root_1.left.right = new Node(6);
        root_1.right.right = new Node(14);
        root_1.left.right.left = new Node(4);
        root_1.left.right.right = new Node(7);
        root_1.right.right.left = new Node(13);
        int expected_1 = 4;
        int output_1 = visibleNodes(root_1);
        check(expected_1, output_1);

        Node root_2 = new Node(10);
        root_2.left = new Node(8);
        root_2.right = new Node(15);
        root_2.left.left = new Node(4);
        root_2.left.left.right = new Node(5);
        root_2.left.left.right.right = new Node(6);
        root_2.right.left = new Node(14);
        root_2.right.right = new Node(16);

        int expected_2 = 5;
        int output_2 = visibleNodes(root_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(String[] args) throws IOException {
        new SimplerSolution().run();
    }
}
