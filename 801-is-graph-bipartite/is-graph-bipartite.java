class Solution {
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int[] color = new int[V];
        // Initially all nodes are uncolored (-1)
        for(int i = 0; i< V; i++){
            color[i] = -1;
        }
        // Check all components
        for(int i = 0; i<V; i++){
            if(color[i]== -1){
                if(CheckBipartieDFS(graph, i, color, 1)== false)
                return false;

            }
        }
        return true;
        
    }
    boolean CheckBipartieDFS(int[][] graph,int curr, int[] color, int currColor ){
        color[curr] = currColor; // color kardiya curr node ko
        // ab jate adjacent/neigh pe
        for( int v : graph[curr]){
            if(color[v]== color[curr] && color[v] != -1){
                return false;
            }
                if(color[v] == -1 ) {     // never colored (nevervisited) collor Nikal lo
                  int colorOfV = 1-currColor;
                  if(CheckBipartieDFS(graph,v, color, colorOfV)== false)
                  return false;

                }
            }
        return true;
    

    }
}