class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int num: nums){
            if(!hm.containsKey(num)) hm.put(num, 1);
            else hm.put(num, hm.get(num) +1);
        }
        node[] arr = new node[hm.size()];
        int arrIterator = 0;
        for(Integer n: hm.keySet()){
            int val = (int) n;
            int freq = (int) hm.get(n);
            node temp = new node(val , freq);
            arr[arrIterator++] = temp;
        }
        Arrays.sort(arr, new NodeComparator());
        int a = 0;
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].freq; j++) nums[a++] = arr[i].val;
        }
        return nums;
    }
    class NodeComparator implements Comparator<node>{
        public int compare(node n1, node n2){
            if(n1.freq > n2.freq) return 1;
            else if(n1.freq < n2.freq) return -1;
            else{
                if(n1.val > n2.val) return -1;
                else if(n1.val < n2.val) return 1;
            }
            return 0;
        }
    }
    class node{
        int val;
        int freq;
        public node(int v, int f){
            this.val = v;
            this.freq = f;
        }
    }
}