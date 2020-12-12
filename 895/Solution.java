class FreqStack {
    
    HashMap<Integer, Integer> freq_check;
    HashMap<Integer, Stack<Integer>> stack;
    int max;

    public FreqStack() {
        this.max = 0;
        this.freq_check = new HashMap<Integer, Integer>();
        this.stack = new HashMap<>();
    }
    
    public void push(int x) {
        if(!this.freq_check.containsKey(x)){
            this.freq_check.put(x, 1);
            if(!this.stack.containsKey(1)){
                Stack<Integer> st = new Stack<>();
                st.push(x);
                stack.put(1, st);
            }else{
                this.stack.get(1).push(x);
            }
        }else{
            this.freq_check.put(x, this.freq_check.get(x) + 1);
            if(!this.stack.containsKey(this.freq_check.get(x))){
                Stack<Integer> st = new Stack<>();
                st.push(x);
                stack.put(this.freq_check.get(x), st);
            }else{
                this.stack.get(this.freq_check.get(x)).push(x);
            }
        }
        this.max = this.max < this.freq_check.get(x)? this.freq_check.get(x) : this.max;
    }
    
    public int pop() {
        int ret = this.stack.get(this.max).pop();
        if(this.freq_check.get(ret) == 1) this.freq_check.remove(ret);
        else this.freq_check.put(ret, this.freq_check.get(ret) - 1);
        
        if(this.stack.get(this.max).size() == 0) this.stack.remove(this.max--);
        return ret;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */