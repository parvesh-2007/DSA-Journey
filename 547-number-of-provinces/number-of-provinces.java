
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, isConnected, visited);
                count++;
            }
        }

        return count;
    }

    public void dfs(int i, int[][] adj, boolean[] visited) {
        visited[i] = true;

        for (int j = 0; j < adj.length; j++) {
            if (adj[i][j] == 1 && !visited[j]) {
                dfs(j, adj, visited);
            }
        }
    }
}
