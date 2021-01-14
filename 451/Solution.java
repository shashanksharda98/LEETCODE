class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(!hm.containsKey(ch)) hm.put(ch, 1);
            else hm.put(ch, hm.get(ch) + 1);
        }
        PriorityQueue<node> pq = new PriorityQueue<>(new nodeComparator());
        for(Character c: hm.keySet()){
            char ch = (char) c;
            int frequency = (int)hm.get(c);
            node temp = new node(ch, frequency);
            pq.add(temp);
        }
        String ans = "";
        while(pq.size() != 0){
            node curr = pq.poll();
            for(int i = 0; i < curr.freq; i++) ans = "" + curr.ch + ans;
        }
        return ans;
    }
    class nodeComparator implements Comparator<node>{
        public int compare(node n1, node n2){
            if(n1.freq > n2.freq) return 1;
            else if(n1.freq < n2.freq) return -1;
            return 0;
        }
    }
    
    class node{
        char ch;
        int freq;
        public node(char ch, int f){
            this.ch = ch;
            this.freq = f;
        }
    }
}