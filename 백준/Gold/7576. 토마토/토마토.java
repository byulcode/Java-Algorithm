import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int m,n, result;
	static int[][] map;
	static Queue<int[]> q = new LinkedList<>();
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split(" ");
		m = Integer.parseInt(arr[0]);
		n = Integer.parseInt(arr[1]);
		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1) {
					q.offer(new int[] {i, j});
				}
			}
		}

		bfs();
		if(result != 0)
			result--;

		for (int[] x : map) {
			for (int y : x) {
				if (y == 0)
					result = -1;
			}
		}

		System.out.println(result);
	}

	public static void bfs() {
		while (!q.isEmpty()) {
			int[] p = q.poll();
			int x = p[0];
			int y = p[1];

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] == 0) {
					map[nx][ny] = map[x][y] + 1;
					result = Math.max(map[nx][ny], result);
					q.offer(new int[] {nx, ny});
				}
			}
		}
	}
}

