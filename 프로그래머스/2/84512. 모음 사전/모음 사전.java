import java.util.*;
class Solution {
    List<String> possible = new ArrayList<>();
    String[] alpha = {"A", "E", "I", "O", "U"};

    public int solution(String word) {
        int answer = 0;
        dfs("");

        answer = possible.indexOf(word) + 1;
        return answer;
    }

    void dfs(String str) {
        if (str.length() > 0)
         possible.add(str);
        if (str.length() == 5) return;

        for (int i = 0; i < 5; i++) {
            dfs(str + alpha[i]);
        }
    }
}