class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> mainS;
    Stack<Integer> minS;
    public MinStack() {
        mainS = new Stack<>();
        minS = new Stack<>();
        
    }
    
    public void push(int x) {
        
        if(mainS.size() == 0){
            mainS.push(x);
            minS.push(x);
        }else{
            mainS.push(x);
            if(x <= minS.peek()) minS.push(x);
        }
    }
    
    public void pop() {
        int cr = mainS.pop();
        if(cr == minS.peek()){
            minS.pop();
        }
    }
    
    public int top() {
        return mainS.peek();
    }
    
    public int getMin() {
        return minS.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */