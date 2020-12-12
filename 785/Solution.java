class Solution {
    public boolean isBipartite(int[][] graph) {
        if(graph.length == 0) return false;
        boolean[] visited = new boolean[graph.length];
        Queue<Integer> q = new ArrayDeque<>();
        
        int[] color = new int[graph.length];
        for(int i = 0; i < graph.length; i++){
            if(!visited[i]){
                q.add(i);
                color[i] = 10;
            }
            //if(graph[i].length == 0) return false;
            while(q.size() != 0){
                int cr_node = q.remove();
                visited[cr_node] = true;
                //if(graph[cr_node].length == 0) return false; 
                for(int v: graph[cr_node]){
                    if(!visited[v]){
                        if(color[v] != 0 && color[v] == color[cr_node]) return false;
                        else{
                            if(color[cr_node] == 10) color[v] = 12;
                            else color[v] = 10;
                        }
                        q.add(v);
                    }
                }
            }
        }
        return true;
    }
}