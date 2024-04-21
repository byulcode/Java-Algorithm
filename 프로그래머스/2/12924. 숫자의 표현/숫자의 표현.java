import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        int half = n / 2 + 1;
        Queue<Integer> q = new LinkedList<>();
        int sum = 0;
        for(int i=1;i<n;i++){
            sum += i;
            q.offer(i);
            while(sum > n){
                sum -= q.poll();
            }
            if(sum == n){
                answer++;
            }
        }
        
        return answer+1;
    }
}