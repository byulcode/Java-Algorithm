class Solution {

    static int totalSubs, totalCost;
    static int[] discount = {10, 20, 30, 40};

    public int[] solution(int[][] users, int[] emoticons) {
        dfs(0, users, emoticons, new int[emoticons.length]);
        return new int[]{totalSubs, totalCost};
    }

    // 유저마다, 이모티콘 마다 4가지 할인율 전부 적용해보는 완전탐색
    static void dfs(int idx, int[][]users, int[] emoticons, int[] curDis) {
        int sub = 0;
        int cost = 0;
        if (idx == emoticons.length) {
            for (int i = 0; i < users.length; i++) {
                int sum = 0;
                for (int j = 0; j < emoticons.length; j++) {
                    if (curDis[j] >= users[i][0]) {
                        sum += emoticons[j] * (100 - curDis[j]) / 100;
                    }
                }
                if (sum >= users[i][1]) {
                    sub++;
                } else {
                    cost += sum;
                }
            }
            if (sub > totalSubs) {
                totalSubs = sub;
                totalCost = cost;
            } else if (totalSubs == sub) {
                totalCost = Math.max(totalCost, cost);
            }
        } else {
            for (int i = 0; i < 4; i++) {
                curDis[idx] = discount[i];
                dfs(idx + 1, users, emoticons, curDis);
            }
        }
    }
}
