import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

class Main {
	static int n, maxArea;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {1, -1, 0, 0,};
	static int[] dy = {0, 0, 1, -1};
	static Set<Integer> heights = new TreeSet<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			String[] line = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(line[j]);
				heights.add(map[i][j]);
			}
		}

		for (int height : heights) {
			visited = new boolean[n][n];
			int area = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (!visited[i][j] && map[i][j] >= height) {
						bfs(i, j, height);
						area++;
					}
				}
			}
			maxArea = Math.max(area, maxArea);
		}

		System.out.println(maxArea);
	}

	static void bfs(int x, int y, int height) {
		visited[x][y] = true;
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {x, y});

		while (!queue.isEmpty()) {
			int[] p = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nx = dx[i] + p[0];
				int ny = dy[i] + p[1];

				if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny] && map[nx][ny] >= height) {
					visited[nx][ny] = true;
					queue.offer(new int[] {nx, ny});
				}
			}
		}
	}
}
