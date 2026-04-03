class MyQueue {

    Deque<Integer> inStack;         // q.push =  1,2,3
    Deque<Integer> outStack;        // q.pop  =  1,2,3

    public MyQueue() {
        this.inStack = new ArrayDeque<>();
        this.outStack = new ArrayDeque<>();
    }

    // O(1)
    public void push(int x) {
        inStack.push(x);
    }

    public int pop() {
        if(outStack.isEmpty()) {
        while (!inStack.isEmpty()) {
            int x = inStack.pop();
            outStack.push(x);
        }
        }

        int y = outStack.pop();
        return y;
    }

    public int peek() {
        if(outStack.isEmpty()) {
        while (!inStack.isEmpty()) {
            int x = inStack.pop();
            outStack.push(x);
        }
    }

        int top = outStack.peek();
        return top;
    }

    // O(1)
    public boolean empty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }
}