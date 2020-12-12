class Solution {
    public int fib(int N) {
        int a = 0, b = 1, c = 0;
    
        if(N == 0) return 0;
        if(N == 1) return 1;
        
        for(int i = 2; i<= N; i++){
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}