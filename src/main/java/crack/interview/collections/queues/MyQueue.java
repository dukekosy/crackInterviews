package crack.interview.collections.queues;

import java.util.Stack;

public class MyQueue<T> {
/*
  5 4 3 2 1 push into stack1
  1 2 3 4 5 if empty and stack1 peek == null , pop all from stack1 push into stack2 pop from stack2
  handle stack2 still empty
  pop all
  peek
  push
  pop
  isempty
*/

    private final Stack<T> stack1 = new Stack<>();
    private final Stack<T> stack2 = new Stack<>();

    private boolean isEmptyStack1() {
        return (stack1.size() == 0); //note stack1.peek() will throw an exception
    }


    private boolean isEmptyStack2() {
        return (stack2.size() == 0);
    }

    public boolean isEmpty() {
        return (isEmptyStack1() && isEmptyStack2());
    }

    public void push(T t) {
        stack1.push(t);
    }

    public T pop() {
        popAll();
        return stack2.pop(); //already throws exception
    }

    private void popAll() {
        if (isEmptyStack2()) {
            int size = stack1.size();
            for (int i = 0; i < size; i++) { //stack size changes during the for loop
                stack2.push(stack1.pop());
            }
        }
    }

    public T peek() {
        popAll();
        return stack2.peek();
    }

    public static void main(String[] args) {

        MyQueue<Integer> myQueue = new MyQueue<>();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        myQueue.push(4);
        myQueue.push(5);
        System.out.println(myQueue.pop());
        myQueue.push(6);
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
    }

}
