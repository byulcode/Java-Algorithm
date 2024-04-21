import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int work : works){
            pq.add(work);
        }
        
        while(n>0){
            n--;
            int num = pq.poll();
            if(num == 0)
                return 0;
            pq.offer(num -1);
        }
        
        while(!pq.isEmpty()){
            answer += (Math.pow(pq.poll(), 2));
        }
        
        return answer;
    }
}