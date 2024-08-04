import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Main {

	static int r, c, sheep, wolf;
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split(" ");
		r = Integer.parseInt(arr[0]);
		c = Integer.parseInt(arr[1]);
		map = new char[r][c];
		visited = new boolean[r][c];
		for (int i = 0; i < r; i++) {
			map[i] = br.readLine().toCharArray();
		}

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (!visited[i][j] && map[i][j] != '#')
					bfs(i, j);
			}
		}
		System.out.println(sheep + " " + wolf);
	}

	static void bfs(int x, int y) {
		Queue<int[]> queue = new LinkedList<>();
		visited[x][y] = true;
		queue.offer(new int[] {x, y});
		int w = 0;
		int s = 0;

		if (map[x][y] == 'v')
			w++;
		else if (map[x][y] == 'k')
			s++;

		while (!queue.isEmpty()) {
			int[] p = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = p[0] + dx[i];
				int ny = p[1] + dy[i];

				if (nx < 0 || nx >= r || ny < 0 || ny >= c || map[nx][ny] == '#' || visited[nx][ny])
					continue;
				if (map[nx][ny] == 'v')
					w++;
				else if (map[nx][ny] == 'k')
					s++;
				visited[nx][ny] = true;
				queue.offer(new int[] {nx, ny});
			}
		}

		if (w >= s)
			wolf += w;
		else
			sheep += s;
	}
}
