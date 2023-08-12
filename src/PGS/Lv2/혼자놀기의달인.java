import java.util.*;
class Solution {

    static boolean[] visited;
    public int solution(int[] cards) {

        visited = new boolean[cards.length];
        List<Integer> list = new ArrayList<>();

        for(int i=0;i<cards.length;i++){
            if(visited[i])
                continue;
            visited[i] = true;
            list.add(operate(cards[i], cards));
        }

        if(list.size() < 2)
            return 0;

        list.sort(Collections.reverseOrder());

        return list.get(0) * list.get(1);
    }

    static int operate(int x, int[] cards){
        int cnt = 1;
        int i = x-1;
        while (!visited[i]) {
            visited[i] = true;
            cnt++;
            i = cards[i] - 1;
        }
        return cnt;
    }
}