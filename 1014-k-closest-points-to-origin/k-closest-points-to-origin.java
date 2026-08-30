class Solution {
    public class Point{
        int x;
        int y;
        int distSq;
        public Point(int x, int y, int distSq){
            this.x = x ; 
            this.y = y;
            this.distSq= distSq;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
    PriorityQueue<Point>pq = new PriorityQueue<>((a,b)-> b.distSq-a.distSq);
     for(int i = 0; i< points.length; i++){
        int x = points[i][0];
        int y = points[i][1];
        int distSq = x * x + y * y;
        pq.add(new Point( x, y, distSq));
        if(pq.size() > k){
            pq.remove();
        }


     }
     int[][] ans = new int[k][2];
     for(int i = 0; i<k; i++){
       Point p = pq.remove();
       ans[i][0] = p.x;
       ans[i][1] = p.y;
     }
     return ans;
        
    }
}