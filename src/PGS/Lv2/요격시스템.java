import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[][] targets) {

        Arrays.sort(targets, Comparator.comparingInt((int[] o) -> o[1]));
        int answer = 1;
        int start = targets[0][1];  // 첫 개구간 끝점
        for (int i = 1; i < targets.length; i++) {

            if (targets[i][0] < start)
                continue;

            start = targets[i][1];
            answer++;
        }

        return answer;
    }
}