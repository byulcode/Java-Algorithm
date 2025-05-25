import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Main {
	static int n;
	static char[][] colors, blindColors;
	static boolean[][] visited;
	static int[] result = new int[2];
	static int[] dx = {1, -1, 0, 0,};
	static int[] dy = {0, 0, 1, -1};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		colors = new char[n][n];
		blindColors = new char[n][n];
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < n; j++) {
				colors[i][j] = line.charAt(j);
				blindColors[i][j] = (colors[i][j] == 'G') ? 'R' : colors[i][j];
			}
		}

		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j]) {
					bfs(i, j, colors);
					result[0]++;
				}
			}
		}

		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j]) {
					bfs(i, j, blindColors);
					result[1]++;
				}
			}
		}
		System.out.println(result[0] + " " + result[1]);
	}

	static void bfs(int x, int y, char[][] colors) {
		char area = colors[x][y];
		visited[x][y] = true;
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {x, y});

		while (!queue.isEmpty()) {
			int[] p = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nx = p[0] + dx[i];
				int ny = p[1] + dy[i];

				if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny] && colors[nx][ny] == area) {
					visited[nx][ny] = true;
					queue.offer(new int[] {nx, ny});
				}
			}
		}
	}
}
