package crack.interview.queuesandstacks;

import java.util.EmptyStackException;

public class Queue<T> {

    private static class Node<T> {
        private final T data;
        private Node<T> next;

        Node(T data) {
            this.data = data;
        }

    }

    private Node<T> first;
    private Node<T> last;

    public void enqueue(T data) {
        Node<T> node = new Node<>(data);
        Node<T> oldLast = last;
/*        if (last != null) {
            last.next = node;
        }*/
        last = node; //new last from data
        if (first == null) {
            first = last;
        } else {
            oldLast.next = last;
        }
    }

    public T dequeue() {
        if (first == null) throw new EmptyStackException();
        T data = first.data;
        first = first.next;
        return data;
    }

    public T peek() {
        if (first == null) throw new EmptyStackException();
        return first.data;
    }

    public boolean isEmpty() {
        return first == null;
    }


}