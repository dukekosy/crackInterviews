package crack.interview.queuesandstacks;

import java.util.EmptyStackException;

public class Stack<T> {

    private static class StackNode<T> {
        private final T data;
        private StackNode<T> next;

        StackNode(T data) {
            this.data = data;
        }
    }

    private StackNode<T> top;

    public T pop() {
        if (top == null) throw new EmptyStackException();
        T data = top.data;
        top = top.next;
        return data;
    }

    public void push(T data) {
        StackNode<T> item = new StackNode<>(data);
        item.next = top;
        top = item;
    }

    public T peek() {
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }

}

