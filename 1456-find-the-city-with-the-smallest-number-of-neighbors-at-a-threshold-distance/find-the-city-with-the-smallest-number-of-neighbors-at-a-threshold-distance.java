
import java.util.*;

class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {

        // Step 1: Create adjacency list
        List<int[]>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            graph[u].add(new int[]{v, w});
            graph[v].add(new int[]{u, w});
        }

        int result = -1;
        int minCount = Integer.MAX_VALUE;

        // Step 2: Run Dijkstra from every city
        for (int src = 0; src < n; src++) {

            int[] dist = new int[n];
            Arrays.fill(dist, Integer.MAX_VALUE);

            dist[src] = 0;

            PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(a[1], b[1])
            );

            pq.offer(new int[]{src, 0});

            while (!pq.isEmpty()) {

                int[] curr = pq.poll();

                int node = curr[0];
                int distance = curr[1];

                if (distance > dist[node]) {
                    continue;
                }

                for (int[] neighbor : graph[node]) {

                    int nextNode = neighbor[0];
                    int weight = neighbor[1];

                    int newDist = distance + weight;

                    if (newDist < dist[nextNode]) {

                        dist[nextNode] = newDist;

                        pq.offer(new int[]{nextNode, newDist});
                    }
                }
            }

            // Step 3: Count reachable cities
            int count = 0;

            for (int i = 0; i < n; i++) {
                if (i != src && dist[i] <= distanceThreshold) {
                    count++;
                }
            }

            // Step 4: Find city with minimum count
            if (count <= minCount) {
                minCount = count;
                result = src;
            }
        }

        return result;
    }
}
