import java.util.HashMap;
import java.util.Map;
// Collections 사용했다가 시간 초과 이슈로 HashMap 사용
class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }

        for (String call : callings) {
            int idx = map.get(call);
            String forward = players[idx - 1];

            map.put(call, idx - 1);
            players[idx - 1] = call;

            map.put(forward, idx);
            players[idx] = forward;
        }
        return players;
    }
}