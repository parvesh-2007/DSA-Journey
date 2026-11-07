class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int V = numCourses;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] indegree = new int[V];
        for(int i = 0; i<V; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i< prerequisites.length ; i++ ){
            int a = prerequisites[i][0];
            int b = prerequisites[i][1];
            adj.get(b).add(a);
            indegree[a]++;
        }
        Queue<Integer>q = new LinkedList<>();
        for(int i = 0; i < V; i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        ArrayList<Integer> result = new ArrayList<>();
        while(!q.isEmpty()){
            int u = q.poll();
            result.add(u);
            
            for(int v : adj.get(u)){
                indegree[v]--;
                if(indegree[v]==0){
                    q.add(v);
                }
            }
        }
        if(result.size()!= V){
                return new int[0];
            }
            int ans[] = new int[V];
            for(int i = 0; i<V; i++){
                ans[i] = result.get(i);
            }
            return ans;

    
    }
}