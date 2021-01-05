class Solution {
    public double averageWaitingTime(int[][] customers) {
        int noOfCustomers = customers.length;
        long waitingTime = 0;
        int start = customers[0][0];
        for(int[] customer: customers){
            int end = 0;
            if(customer[0] <= start) end = start + customer[1];
            else end = customer[0] + customer[1];
            waitingTime += (end - customer[0]);
            start = end;
        }
        double avgWaitingTime = (double)( (waitingTime*1.0)/(noOfCustomers*1.0));
        return avgWaitingTime;
    }
}