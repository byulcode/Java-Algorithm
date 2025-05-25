import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	static int n, m, k;
	static int[][] map;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			map[i] = Arrays.stream(br.readLine().split(""))
				.mapToInt(Integer::parseInt)
				.toArray();
		}

		int result = bfs();
		System.out.println(result);
	}

	static int bfs() {
		Queue<int[]> queue = new LinkedList<>();
		int[][][] visited = new int[n][m][k + 1];
		queue.offer(new int[] {0, 0, 0});
		visited[0][0][0] = 1;

		while (!queue.isEmpty()) {
			int[] p = queue.poll();
			int x = p[0];
			int y = p[1];
			int wall = p[2];
			if (x == n - 1 && y == m - 1) {
				return visited[n - 1][m - 1][wall];
			}

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
					// 다음단계 벽, 부순 횟수 < k
					if (map[nx][ny] == 1 && wall < k) {
						if (visited[nx][ny][wall + 1] == 0) {
							visited[nx][ny][wall + 1] = visited[x][y][wall] + 1;
							queue.offer(new int[] {nx, ny, wall + 1});
						}
					}
					// 다음단계 벽X, 방문한 적X
					else if (map[nx][ny] == 0 && visited[nx][ny][wall] == 0) {
						visited[nx][ny][wall] = visited[x][y][wall] + 1;
						queue.offer(new int[] {nx, ny, wall});
					}
				}
			}
		}
		return -1;
	}
}
