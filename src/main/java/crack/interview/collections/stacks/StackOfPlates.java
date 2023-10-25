package crack.interview.collections.stacks;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class StackOfPlates<T> {

    private Integer currentStack = 0;
    private final Map<Integer, Stack<T>> map = new HashMap<>();

    public void push(T t) {
        Stack<T> stack;
        /*
    High
    Hashmap <1, List<Node>>
    Push if(current stack.size()>=) new current stack push else push current stack
    Pop current stack. If current stack empty. Move to previous
    */
        int high = 5;
        if (map.get(currentStack) == null) {
            stack = new Stack<>();
            stack.push(t);
            map.put(currentStack, stack);
        } else if (map.get(currentStack).size() == high) {
            currentStack++;
            stack = new Stack<>();
            stack.push(t);
            map.put(currentStack, stack);
        } else {
            stack = map.get(currentStack);
            stack.push(t);
            map.put(currentStack, stack);
        }
    }

    public T pop() {
        if (map.get(currentStack).size() == 0) {
            currentStack--;

        }
        return map.get(currentStack).pop();

    }

    public T popAtIndex(int index) {
        return map.get(index).pop();

    }

    public static void main(String[] args) {

        StackOfPlates<Integer> s = new StackOfPlates<>();
        s.push(1);
        s.push(2);
        s.push(3);
        s.push(4);
        s.push(5);
        s.push(6);
        s.push(7);
        System.out.println(s.pop());
        System.out.println(s.popAtIndex(0));
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());


    }


}
