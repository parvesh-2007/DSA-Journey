class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        boolean[] visited = new boolean[V];
        boolean[] inRecurssion = new boolean[V];
        for(int i = 0; i<V; i++){
            if(!visited[i]){
            isCycleDFS( graph, i, visited,  inRecurssion);
            }
        }
        List<Integer> safenodes = new ArrayList<>();
            for(int i = 0; i<V; i++){
                if(inRecurssion[i]== false){
                    safenodes.add(i);
                }
            }
        return safenodes;
    
    }
    boolean isCycleDFS(int[][] graph, int u, boolean[] visited, boolean[] inRecurssion){
        visited[u] = true;
        inRecurssion[u] = true;
        for(int v : graph[u]){
            if(visited[v]== false && isCycleDFS( graph, v, visited,  inRecurssion )){
                return true;
            } else if(inRecurssion[v]== true){
                return true;
            }
        }
        inRecurssion[u] = false;
        return false;
    }
}