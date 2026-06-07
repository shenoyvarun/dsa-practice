class MinStack {
    Stack<Integer> s; 
    Stack<Integer> m;
    public MinStack() {
        s = new Stack<>();
        m = new Stack<>();
    }
    
    public void push(int val) {
        s.push(val);
        if(m.empty() || m.peek() >= val)
            m.push(val);
    }
    
    public void pop() {
        int curr = s.pop();
        if(m.peek().equals(curr))
            m.pop();
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        return m.peek();
    }
}
