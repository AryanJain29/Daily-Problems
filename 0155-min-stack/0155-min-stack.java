import java.util.Stack;

class MinStack {
    Stack<Long> stack;
    long mini;

    public MinStack() {
        stack = new Stack<>();
        mini = Long.MAX_VALUE;
    }

    public void push(int val) {
        long value = (long) val;
        if (stack.isEmpty()) {
            mini = value;
            stack.push(value);
        } else {
            if (value >= mini) {
                stack.push(value);
            } else {
                stack.push(2 * value - mini);
                mini = value;
            }
        }
    }

    public void pop() {
        if (stack.isEmpty()) return;

        long top = stack.pop();
        if (top < mini) {
            mini = 2 * mini - top;
        }
    }

    public int top() {
        if (stack.isEmpty()) return -1;

        long top = stack.peek();
        if (top < mini) {
            return (int) mini;
        } else {
            return (int) top;
        }
    }

    public int getMin() {
        return (int) mini;
    }
}
