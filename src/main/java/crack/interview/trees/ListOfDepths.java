package crack.interview.trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ListOfDepths {

    //1 inorder depth first, d * ll, keeping depth in mind add to the correct link list n^2

    //2 pre order
    // node, level
    // visit this node
    // trans left level++
    // trans right level++

    //2 breath first search

    //2re each re new depth add to ll   n^2

    private static class Node {
        private final int value;
        private Node left;
        private Node right;

        Node(int value) {
            this.value = value;
        }
    }

    private static void transverse(Node n, int l) {
        if (n != null) {
            visit(n, l);
            l++;
            transverse(n.left, l);
            transverse(n.right, l);
        }
    }

    private static final Map<Integer, List<Node>> dl = new HashMap<>();

    private static void visit(Node n, int l) {
        List<Node> list = new LinkedList<>();
        if (dl.get(l) != null) {
            list = dl.get(l);
        }
        list.add(n);
        dl.put(l, list);
    }

    //The rest of this code is for testing

    // 2 4 8 6 7 3 9 // insertion
    //5
    //l2                  //r8
    //r4              //l6     //r9
    //l3                   //r7
// 5 2 4 3 8 6 7 9 // output

    private static void insert(Node node, int value) {
        if(value < node.value) {//go left
            if (node.left != null)
                insert(node.left, value);
            else
                node.left = new Node(value);
        }
        else {//go right
            if (node.right != null)
                insert(node.right, value);
            else
                node.right = new Node(value);
        }
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        insert(root,2);
        insert(root,4);
        insert(root,8);
        insert(root,6);
        insert(root,7);
        insert(root,3);
        insert(root,9);
        transverse(root, 0);

        System.out.println(dl.get(0).size());
        System.out.println(dl.get(1).size());
        System.out.println(dl.get(2).size());
        System.out.println(dl.get(3).size());

    }

}
