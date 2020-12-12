class MyQueue {

    /** Initialize your data structure here. */
    private Stack<Integer> st;
    public MyQueue() {
         this.st = new Stack<>();
        //return st;
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        this.st.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return this.pop_help(st);
    }
    
    /** Get the front element. */
    public int peek() {
        return this.peek_help(st);
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return this.st.empty();
    }
    
    public int pop_help(Stack<Integer> s){
        if(s.size() == 1){
            int ans = s.peek();
            s.pop();
            return ans;
        }
        int cr = s.peek();
        s.pop();
        int ret = pop_help(s);
        s.push(cr);
        return ret;
    }
     public int peek_help(Stack<Integer> s){
        if(s.size() == 1){
            return s.peek();
        }
        int cr = s.peek();
        s.pop();
        int ret = peek_help(s);
        s.push(cr);
        return ret;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */