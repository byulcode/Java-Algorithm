import java.util.*;
class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        col -= 1;
        row_begin -=1;

        int column = col;
        Arrays.sort(data, (o1, o2) -> {
            if(o1[column] == o2[column]) return o2[0] - o1[0];    //내림차순
            return o1[column] - o2[column]; //오름차순
        });

        for(int i=row_begin; i<row_end; i++){
            int s_i = i + 1;

            int total = Arrays.stream(data[i])
                    .map(j -> j % s_i)
                    .sum();

            answer = (answer ^ total);
        }

        return answer;
    }
}