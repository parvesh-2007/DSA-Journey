class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        ArrayList<ArrayList<double[]>> adj = new ArrayList<>();
        for(int i = 0; i< n; i++){
            adj.add(new ArrayList<>());
        }
        for(int  i = 0; i<edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            double prob = succProb[i];
            adj.get(u).add(new double[]{v,prob});
            adj.get(v).add(new double[]{u, prob});

        }
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[0], a[0]));
        double[] result = new double[n];
        result[start_node] = 1.0;
        pq.add(new double[]{1.0, start_node});
    while(!pq.isEmpty()){
        double[] curr = pq.poll();
        double Currpro = curr[0];
        int node = (int)(curr[1]);
        if(Currpro <result[node]){
                continue;
            }
        for(double[] neighbour: adj.get(node)){
            int adjNode = (int)neighbour[0];
            double probwt = neighbour[1];
            double newProb = Currpro * probwt;
            if(newProb > result[adjNode]){
                result[adjNode] = newProb;
                pq.add(new double[]{newProb, adjNode});
            }
        }
    }
    return result[end_node];
        
    }
}