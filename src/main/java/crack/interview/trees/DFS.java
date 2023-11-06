package crack.interview.trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//https://www.youtube.com/watch?v=Urx87-NMm6c
public class DFS {

    private class Node {
        int data;
        List<Node> nodes = new ArrayList<>();

        Node(int data) {
            this.data = data;
        }
    }

    void dfsSearch(Node node) {
        Stack<Node> stack = new Stack<>();
        List<Node> visited = new ArrayList<>();

        stack.push(node);
        visited.add(node);

        while (!stack.isEmpty()) {
            for (Node child : stack.pop().nodes) {
                if(!visited.contains(child)) {
                    visited.add(child); // 1 visited first before pushing and at some point poping from stack
                    stack.push(child);  // 2 put in stack planning to pop when it's turn commes
                }
            }
        }

    }
}
