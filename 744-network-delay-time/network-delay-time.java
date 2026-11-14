class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i = 0; i<=n; i++){
            adj.add(new ArrayList<>());
        }
        for(int[] vec : times){
            int u = vec[0];
            int v = vec[1];
            int w = vec[2];
            adj.get(u).add(new int[]{v,w});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> Integer.compare(a[0],b[0]));
        int[] result = new int[n+1];
        for(int i = 0; i<= n; i++){
            result[i] = Integer.MAX_VALUE;
        }
        result[k] = 0;
        pq.add(new int[]{0, k});
        while(!pq.isEmpty()){
            int d = pq.peek()[0];
            int node = pq.peek()[1];
            pq.poll();
            for(int[] vec : adj.get(node)){
                int adjNode = vec[0];
                int wt = vec[1];
                if(d+ wt < result[adjNode]){
                    result[adjNode] = d+wt;
                    pq.add(new int[]{d+wt, adjNode});
                }
            }
        }
        int ans = Integer.MIN_VALUE;
        for(int i = 1; i<= n; i++){
            ans = Math.max(ans, result[i]);
        }
        return ans==  Integer.MAX_VALUE  ? -1 : ans;

        
    }
}