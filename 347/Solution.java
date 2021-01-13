class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        //frequency map of all elements
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int val: nums){
            if(!hm.containsKey(val)) hm.put(val, 1);
            else hm.put(val, hm.get(val) +1);
        }
        //final solution array and array pointer declaration
        int[] arr = new int[k];
        int arrCounter = 0;

        //priority queue with compartor based on frequency of the element(Min priority queue)
        PriorityQueue<ele> pq = new PriorityQueue<ele>(new NC());
        for(Integer number: hm.keySet()){
            if(pq.size() < k){
                int val = (int)number;
                int f = (int)hm.get(number);
                ele temp = new ele(val, f);
                pq.add(temp);
            }
            else{
                int f = (int)hm.get(number);
                if(f > pq.peek().freq){
                    pq.poll();
                    int val = (int)number;
                    ele temp = new ele(val, f);
                    pq.add(temp);
                }
            }
        }
        //removing elements from the queue after it contains the K highest frequency elements and adding to the solution array
        while(pq.size() != 0){
            arr[arrCounter++] = pq.poll().number;
        }
        return arr;
        
    }
    public class ele{
        int number;
        int freq;
        public ele(int n, int f){
            this.number = n;
            this.freq = f;
        }
    }
    
    class NC implements Comparator<ele>{
        public int compare(ele e1, ele e2){
            if(e1.freq > e2.freq) return 1;
            else if(e1.freq < e2.freq) return -1;
            return 0;
        }
    }
    
}
