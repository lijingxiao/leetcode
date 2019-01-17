package leetcode;

import java.util.Stack;

/**
 * Created by lijingxiao on 2019/1/7.
 */
class MinStack {
//
//     MinStack obj = new MinStack();
//     obj.push(x);
//     obj.pop();
//     int param_3 = obj.top();
//     int param_4 = obj.getMin();

    Stack<Long> stack;
    private long min = Integer.MAX_VALUE;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        if (stack.isEmpty())
            min = x;
        stack.push(x - min);

        if (x < min)
            min = x;
    }

    public void pop() {
        if (stack.isEmpty()) return;
        Long pop = stack.pop();
        if (pop < 0) {
            min = min - pop;
        }
    }

    public int top() {
        //当栈顶元素为负时，说明当前元素入栈的时候是最小元素（比它入栈之前的元素小）
        Long peek = stack.peek();
//        return (int)(peek + min);
        if (peek < 0) return (int)min;
        else return (int)(peek + min);
    }

    public int getMin() {
        return (int)min;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.push(-9);
//        minStack.getMin();   //--> 返回 -3.
        System.out.println(minStack.getMin());
        minStack.pop();
//        minStack.top();      //--> 返回 0.
        System.out.println(minStack.top());
//        minStack.getMin();   //--> 返回 -2.
        System.out.println(minStack.getMin());
    }
}
