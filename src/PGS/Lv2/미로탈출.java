import java.util.LinkedList;
import java.util.Queue;

class Solution {

    static String[][] miro;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static int solution(String[] maps) {
        miro = new String[maps.length][maps[0].length()];
        int[] start = new int[2];
        int[] lever = new int[2];

        for (int i = 0; i < maps.length; i++) {
            String[] tmp = maps[i].split("");

            for (int j = 0; j < maps[0].length(); j++) {
                miro[i][j] = tmp[j];

                if (miro[i][j].equals("S")) {
                    start = new int[]{i, j};
                }
                if (miro[i][j].equals("L")) {
                    lever = new int[]{i, j};
                }
            }
         }
        int res1 = bfs(start[0], start[1], "L");
        int res2 = bfs(lever[0], lever[1], "E");
        if(res1 == -1 || res2 == -1)
            return -1;

        return res1 + res2;
    }

    static int bfs(int x, int y, String target) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y, 0});
        boolean[][] visited = new boolean[miro.length][miro[0].length];
        while (!queue.isEmpty()) {
            int[] q = queue.poll();
            int qx = q[0];
            int qy = q[1];
            int cnt = q[2];
            visited[qx][qy] = true;
            if (miro[qx][qy].equals(target)) {
                return cnt;
            }

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + qx;
                int ny = dy[i] + qy;
                if (nx >= 0 && nx < miro.length && ny >= 0 && ny < miro[0].length && !visited[nx][ny]) {

                    if (!miro[nx][ny].equals("X")) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny, cnt + 1});
                    }

                }
            }
        }
        return -1;
    }
}