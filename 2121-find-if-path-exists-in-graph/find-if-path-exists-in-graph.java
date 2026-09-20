

class Solution {

    static class Edge {
        int src;
        int dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {

        ArrayList<Edge>[] graph = new ArrayList[n];

        // Graph initialize
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Graph create
        for (int i = 0; i < edges.length; i++) {

            int u = edges[i][0];
            int v = edges[i][1];

            graph[u].add(new Edge(u, v));
            graph[v].add(new Edge(v, u));
        }

        boolean[] vis = new boolean[n];

        return dfs(graph, source, destination, vis);
    }

    public boolean dfs(ArrayList<Edge>[] graph, int src, int dest, boolean[] vis) {

        if (src == dest) {
            return true;
        }

        vis[src] = true;

        for (int i = 0; i < graph[src].size(); i++) {

            Edge e = graph[src].get(i);

            if (!vis[e.dest] && dfs(graph, e.dest, dest, vis)) {
                return true;
            }
        }

        return false;
    }
}