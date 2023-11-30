import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int wSum = 0, bSum = 0;
    static int n, m;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[m][n];
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    int cnt = bfs(i, j);

                    if (map[i][j] == 'W') {
                        wSum += cnt * cnt;
                    } else {
                        bSum += cnt * cnt;
                    }
                }
            }
        }
        System.out.printf("%d %d", wSum, bSum);
    }

    public static int bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        int cnt = 1;
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int p[] = queue.poll();
            x = p[0];
            y = p[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny] && map[x][y] == map[nx][ny]) {
                    queue.offer(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
