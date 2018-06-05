import java.util.Stack;
import java.util.TreeMap;

/**
 * @author Daniel
 * @date 04/06/2018
 */
public class MinStack {
    /**
     * initialize your data structure here.
     */

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(1);
        minStack.push(2);
        minStack.push(-3);
        minStack.push(0);
        minStack.pop();
        System.out.println(minStack.getMin());

    }

    private Stack stack;
    private TreeMap<Integer, Integer> treeMap;

    public MinStack() {
        stack = new Stack();
        treeMap = new TreeMap<>();
    }

    public void push(int x) {
        stack.push(x);
        if (treeMap.containsKey(x)) {
            treeMap.put(x, treeMap.get(x) + 1);
        } else {
            treeMap.put(x, 1);
        }
    }

    public void pop() {
        Integer x = (Integer) stack.pop();
        if (treeMap.get(x) == 1) {
            treeMap.remove(x);
        } else {
            treeMap.put(x, treeMap.get(x) - 1);
        }
    }

    public int top() {
        return (int) stack.peek();
    }

    public int getMin() {
        return treeMap.firstKey().intValue();
    }
}
