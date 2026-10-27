class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i<n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        boolean[] visited = new boolean[n];
        return dfs(source, destination, graph, visited);

        
    }
    public boolean dfs(int source, int destination,ArrayList<ArrayList<Integer>> graph, boolean[]visited){
        if(source== destination){
            return true;
        }
        visited[source]= true;
        for(int i = 0; i<graph.get(source).size(); i++){
            int neighbour = graph.get(source).get(i);
            if(!visited[neighbour]){
                if(dfs(neighbour,destination, graph, visited)){
                    return true;
                }
            }
        }
        return false;
    }
}