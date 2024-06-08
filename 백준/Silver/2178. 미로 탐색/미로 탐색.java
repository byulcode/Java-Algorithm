import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int n, m;
	static int[][] map, cnt;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		m = scanner.nextInt();
		map = new int[n][m];
		scanner.nextLine();

		for (int i = 0; i < n; i++) {
			String line = scanner.nextLine().trim();
			for (int j = 0; j < m; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
		System.out.println(bfs());
	}

	static int bfs() {
		boolean[][] visited = new boolean[n][m];
		visited[0][0] = true;
		cnt = new int[n][m];
		cnt[0][0] = 1;

		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {0, 0});

		while (!q.isEmpty()) {
			int[] p = q.poll();
			int x = p[0];
			int y = p[1];

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < 0 || nx >= n || ny < 0 || ny >= m
					|| visited[nx][ny] || map[nx][ny] == 0)
					continue;
				visited[nx][ny] = true;
				cnt[nx][ny] = cnt[x][y] + 1;
				q.offer(new int[] {nx, ny});
			}
		}
		return cnt[n-1][m-1];
	}
}

