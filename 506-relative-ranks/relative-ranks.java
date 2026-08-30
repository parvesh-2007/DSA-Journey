class Solution {
    static class Athlete{
        int score; 
        int index;
     public Athlete(int score, int index){
        this.score = score;
        this.index = index;
     }
    }
    public String[] findRelativeRanks(int[] score) {
        String[] answer = new String[score.length];
        PriorityQueue<Athlete> pq = new PriorityQueue<>((a,b)-> b.score-a.score);
        for(int i = 0; i<score.length; i++){
            pq.add( new Athlete(score[i],i));
        }
        int rank = 1;
        while(!pq.isEmpty()){
            Athlete a = pq.remove();

            if(rank==1){
                answer[a.index] ="Gold Medal";
            } else if(rank == 2){
                answer[a.index] ="Silver Medal";
            } else if(rank==3){
                answer[a.index]="Bronze Medal";
            }else{
                answer[a.index] = String.valueOf(rank);
            }
            rank++;
        }
        return answer;
        
    }
}