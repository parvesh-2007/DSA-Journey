class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;
        int source = 0;
        int target = n-1;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(graph, source, target,result, temp);
        return result;
        
    }
    void dfs(int[][] graph, int source, int target, List<List<Integer>> result, List<Integer>temp){
        temp.add(source);
        if(source== target){
         result.add(new ArrayList<>(temp));
        } else{
            for(int v : graph[source]){
                dfs(graph, v, target, result, temp);
            }
        }
         temp.remove(temp.size() - 1);

    }
}