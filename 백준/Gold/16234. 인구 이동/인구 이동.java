import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Main {
	static int n, l, r, result;
	static int[][] map;
	static boolean[][] visited;
	static boolean isMoved = false;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split(" ");
		n = Integer.parseInt(arr[0]);
		l = Integer.parseInt(arr[1]);
		r = Integer.parseInt(arr[2]);
		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			map[i] = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		}

		while (true) {
			visited = new boolean[n][n];
			isMoved = false;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (!visited[i][j]) {
						bfs(i, j);
					}
				}
			}

			if (isMoved)
				result++;
			else
				break;
		}

		System.out.println(result);
	}

	static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		List<int[]> list = new ArrayList<>();
		list.add(new int[] {x, y});
		queue.offer(new int[] {x, y});
		visited[x][y] = true;
		int sum = map[x][y];

		while (!queue.isEmpty()) {
			int[] p = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nx = p[0] + dx[i];
				int ny = p[1] + dy[i];

				if (nx >= 0 && nx < n && ny >= 0 && ny < n && Math.abs(map[p[0]][p[1]] - map[nx][ny]) >= l
					&& Math.abs(map[p[0]][p[1]] - map[nx][ny]) <= r && !visited[nx][ny]) {
					sum += map[nx][ny];
					queue.add(new int[] {nx, ny});
					list.add(new int[] {nx, ny});
					visited[nx][ny] = true;
				}
			}
		}

		// 연합이 있다면
		if (list.size() > 1) {
			isMoved = true;
			sum = sum / list.size();
			for (int[] pair : list) {
				map[pair[0]][pair[1]] = sum;
			}
		}
		list.clear();
	}
}
