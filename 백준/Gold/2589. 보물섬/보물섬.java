import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Main {

	static int r, c, max;
	static String[][] map;
	static int[][] dist;
	static boolean[][] visited;
	static int[] dx = {0, 0, -1, 1};
	static int[] dy = {-1, 1, 0, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split(" ");
		r = Integer.parseInt(arr[0]);
		c = Integer.parseInt(arr[1]);
		map = new String[r][c];
		dist = new int[r][c];
		visited = new boolean[r][c];

		for (int i = 0; i < r; i++) {
			map[i] = br.readLine().split("");
		}

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (map[i][j].equals("L")) {
					visited = new boolean[r][c];
					bfs(i, j, 0);
				}
			}
		}
		System.out.println(max);
	}

	static void bfs(int x, int y, int length) {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {x, y, length});
		visited[x][y] = true;

		while (!queue.isEmpty()) {
			int[] p = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = p[0] + dx[i];
				int ny = p[1] + dy[i];
				length = p[2];

				if (nx >= 0 && nx < r && ny >= 0 && ny < c && map[nx][ny].equals("L") && !visited[nx][ny]) {
					visited[nx][ny] = true;
					queue.offer(new int[] {nx, ny, length + 1});
					max = Math.max(max, length + 1);
				}
			}
		}
	}
}
