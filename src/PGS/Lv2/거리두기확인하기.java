import java.util.LinkedList;
import java.util.Queue;

class Solution {

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        for (int i = 0; i < places.length; i++) {
            String[] p = places[i];
            boolean flag = true;

            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if (p[j].charAt(k) == 'P') {
                        if (!bfs(j, k, p))
                            flag = false;
                    }
                }
            }
            answer[i] = flag ? 1 : 0;
        }
        return answer;
    }

    static boolean bfs(int x, int y, String[] p) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        while (!queue.isEmpty()) {
            int[] q = queue.poll();
            int px = q[0];
            int py = q[1];
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + px;
                int ny = dy[i] + py;
                if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5 || (x == nx && y == ny))
                    continue;

                int dist = Math.abs(nx - x) + Math.abs(ny - y);

                if (p[nx].charAt(ny) == 'P' && dist <= 2)
                    return false;
                else if (p[nx].charAt(ny) == 'O' && dist < 2)
                    queue.offer(new int[]{nx, ny});
            }
        }
        return true;
    }
}