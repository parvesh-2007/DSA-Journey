class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        int[][] direc = {
            {-1,0},
            {0,-1},
            {0,1},
            {1,0}
        };
        int[][] result = new int[m][n];
        for(int i = 0; i< m; i++){
            for(int j= 0; j< n; j++){
                result[i][j] = Integer.MAX_VALUE;
            }
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> Integer.compare(a[0],b[0]));
        pq.offer(new int[]{0,0,0});
        result[0][0] = 0;
        while(!pq.isEmpty()){
            int[] top = pq.poll();
            int diff = top[0];
            int x = top[1];
            int y = top[2];
            if(x==m-1 && y== n-1){
                return diff;
            }
            for(int i = 0; i<4; i++){
                int x_ = x+direc[i][0];
                int y_ = y + direc[i][1];
                if(x_>=0 && x_ < m && y_>= 0 && y_<n){
                    int newDiff = Math.max(diff, Math.abs(heights[x][y]-heights[x_][y_]));
                    if(result[x_][y_]> newDiff){
                    result[x_][y_] = newDiff;
                    pq.offer(new int[]{result[x_][y_], x_,y_});
                    } 
                }
                
            }
        }
        return result[m-1][n-1];
        
    }
}