class Solution {
    public int numberOfSteps (int num) {
        int steps = 0;
        while(num != 0){
            if((num & 1) != 1) num = (num >> 1);
            else num = ((num << 1) + (~num));
            steps++;
        }
        return steps;
    }
}