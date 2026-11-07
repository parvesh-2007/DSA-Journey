class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int V = numCourses;
        ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
        int[] indegree = new int[V];
        for(int i = 0; i< V; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i<prerequisites.length; i++ ){
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            
            adj.get(b).add(a);
            indegree[a]++;
        }
        Queue<Integer> q =  new LinkedList<>();
        for(int i = 0; i<V; i++){
            if(indegree[i]== 0){
                q.add(i);
            }
        }
        int count = 0;
        while(!q.isEmpty()){
            int u = q.poll();
            count++;

            for(int v : adj.get(u)){
                indegree[v]--;
                if(indegree[v]==0){
                    q.add(v);
                }
            }
        }
        if(count==V){
            return true;
        }
        return false;
        
    }
}