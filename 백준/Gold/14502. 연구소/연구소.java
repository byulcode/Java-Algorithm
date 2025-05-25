import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Main {

	static int n, m, result;
	static int[][] map;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split(" ");
		n = Integer.parseInt(arr[0]);
		m = Integer.parseInt(arr[1]);
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			map[i] = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		}

		backtracking(0);
		System.out.println(result);
	}

	static void backtracking(int k) {
		if (k == 3) {
			bfs();
			return;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0) {
					map[i][j] = 1;
					backtracking(k + 1);
					map[i][j] = 0;
				}
			}
		}
	}

	static void bfs() {
		int[][] curMap = new int[n][m];
		for (int i = 0; i < n; i++) {
			curMap[i] = map[i].clone();
		}
		Queue<int[]> q = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (curMap[i][j] == 2)
					q.offer(new int[] {i, j});
			}
		}

		while (!q.isEmpty()) {
			int[] p = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = p[0] + dx[i];
				int ny = p[1] + dy[i];
				if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
					if (curMap[nx][ny] == 1 || curMap[nx][ny] == 2)
						continue;
					curMap[nx][ny] = 2;
					q.offer(new int[] {nx, ny});
				}
			}
		}

		int cnt = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (curMap[i][j] == 0)
					cnt++;
			}
		}
		result = Math.max(cnt, result);
	}
}
