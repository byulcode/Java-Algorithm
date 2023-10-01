import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int n, m;
    static int[][][] visited;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        n = Integer.parseInt(arr[0]);
        m = Integer.parseInt(arr[1]);
        visited = new int[n][m][2];
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] tmp = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(tmp[j]);
            }
        }
        System.out.println(bfs());
    }

    static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0});
        visited[0][0][0] = 1;

        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            int x = p[0];
            int y = p[1];
            int wall = p[2];
            if (x == n - 1 && y == m - 1) {
                return visited[x][y][wall];
            }

            for (int i = 0; i < 4; i++) {
                int nx = p[0] + dx[i];
                int ny = p[1] + dy[i];

                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    // 다음 방문할 곳이 벽이고, 아직 벽을 부순 적 없음
                    if (map[nx][ny] == 1 && wall == 0) {
                        visited[nx][ny][1] = visited[x][y][0] + 1;
                        queue.offer(new int[]{nx, ny, 1});

                        // 다음 방문할 곳이 벽이 아니고, 아직 방문한 적 없음
                    } else if (map[nx][ny] == 0 && visited[nx][ny][wall] == 0) {
                        visited[nx][ny][wall] = visited[x][y][wall] + 1;
                        queue.offer(new int[]{nx, ny, wall});
                    }
                }
            }
        }
        return -1;
    }
}
