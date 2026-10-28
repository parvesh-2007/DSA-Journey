class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        dfs(rooms, 0, visited);
        for(int i = 0; i< n; i++){
            if(!visited[i]){
                return false;
            }

        }
        return true;
        
    }
    public static void dfs(List<List<Integer>> rooms, int source, boolean[] visited ){
        visited[source] = true;
        for(int key : rooms.get(source)){
            if(!visited[key]){
                dfs(rooms, key, visited);
            }
        }
    }
}