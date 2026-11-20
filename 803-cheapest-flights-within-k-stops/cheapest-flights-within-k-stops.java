class Solution {
    public int findCheapestPrice(int n, int[][] flights,
                                 int src, int dst, int k) {

        int[] distance = new int[n];

        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[src] = 0;

        // k stops = k+1 flights
        for (int i = 0; i <= k; i++) {

            int[] temp = distance.clone();

            for (int[] edge : flights) {

                int u = edge[0];
                int v = edge[1];
                int w = edge[2];

                if (distance[u] != Integer.MAX_VALUE &&
                    distance[u] + w < temp[v]) {

                    temp[v] = distance[u] + w;
                }
            }

            distance = temp;
        }

        if (distance[dst] == Integer.MAX_VALUE) {
            return -1;
        }

        return distance[dst];
    }
}