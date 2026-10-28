class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        dfs(rooms, 0, visited);
        for(boolean x : visited){
            if(x==false){
                return false;
            }
        }
        return true;


        
    }
    public static void dfs(List<List<Integer>> rooms, int source, boolean[] visited){
        visited[source] = true;
        for(int node : rooms.get(source)){
            if(!visited[node]){
                dfs(rooms, node, visited);
            }
        }

    }
}