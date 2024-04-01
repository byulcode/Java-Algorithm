import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, startX, startY;
	static boolean[][] visited;
	static int[][] array, dist;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		array = new int[N][M];
		dist = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < M; j++) {
				array[i][j] = Integer.parseInt(st.nextToken());
				if (array[i][j] == 2) {
					startX = i;
					startY = j;
				}
			}
		}

		bfs(startX, startY);

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (dist[i][j] == 0 && array[i][j] == 1) {
					dist[i][j] = -1;
				}
				System.out.print(dist[i][j] + " ");
			}
			System.out.println();
		}
	}

	static void bfs(int x, int y) {
		visited[x][y] = true;
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {x, y});

		while (!queue.isEmpty()) {
			int[] p = queue.poll();
			x = p[0];
			y = p[1];

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 0 || nx >= N || ny < 0 || ny >= M || array[nx][ny] == 0 || visited[nx][ny])
					continue;
				dist[nx][ny] = dist[x][y] + 1;
				visited[nx][ny] = true;
				queue.offer(new int[] {nx, ny});
			}
		}
	}
}

