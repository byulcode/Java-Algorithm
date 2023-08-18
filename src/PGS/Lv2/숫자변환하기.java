import java.util.Arrays;

//dp 이용
class Solution {
    static final int MAX_NUM = 1000000;

    public int solution(int x, int y, int n) {
        Integer[] dp = new Integer[y + 1];  //x 값이 i가 될 때 까지의 연산 횟수를 저장하는 배열
        Arrays.fill(dp, MAX_NUM);   // 모든 필드 MAX_NUM으로 초기화
        dp[x] = 0;

        for (int i = x+1; i < y + 1; i++) {
            if(x <= i - n)
                dp[i] = Math.min(dp[i], dp[i - n] + 1);
            if(i % 2 == 0 && i / 2 >= x)
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            if(i % 3 == 0 && i / 3 >= x)
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
        }

        return dp[y] == MAX_NUM ? -1 : dp[y];
    }
}