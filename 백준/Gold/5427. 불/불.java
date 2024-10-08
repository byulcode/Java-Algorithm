import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	static int w, h, startX, startY;
	static char[][] map;
	static Queue<Point> fire;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static boolean[][] visited;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());

		for (int t = 0; t < tc; t++) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			map = new char[h][w];
			fire = new LinkedList<>();

			for (int i = 0; i < h; i++) {
				String line = br.readLine();
				for (int j = 0; j < w; j++) {
					map[i][j] = line.charAt(j);
					if (map[i][j] == '@') {
						startX = i;
						startY = j;
					} else if (map[i][j] == '*') {
						fire.add(new Point(i, j));
					}
				}
			}
			escape();
		}
		System.out.println(sb.toString());
	}

	public static void escape() {
		Queue<Point> q = new LinkedList<>();
		visited = new boolean[h][w];
		visited[startX][startY] = true;
		q.offer(new Point(-1, -1));
		q.offer(new Point(startX, startY));
		int time = -1;

		while (!q.isEmpty()) {
			Point now = q.poll();

			if (now.x == -1 && now.y == -1) {
				burn();
				if (!q.isEmpty()) {
					q.offer(now); // 마커(-1, -1) 추가
				}
				time++;
				continue;
			}

			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];

				if (nx < 0 || nx >= h || ny < 0 || ny >= w) {
					sb.append(time + 1 + "\n"); // 탈출
					return;
				}
				if (map[nx][ny] == '.' && !visited[nx][ny]) {
					q.offer(new Point(nx, ny));
					visited[nx][ny] = true;
				}
			}
		}
		sb.append("IMPOSSIBLE\n");
	}

	public static void burn() {
		int size = fire.size();

		for (int s = 0; s < size; s++) {
			Point now = fire.poll();

			for (int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];

				if (nx >= 0 && ny >= 0 && nx < h && ny < w && (map[nx][ny] == '.' || map[nx][ny] == '@')) {
					fire.offer(new Point(nx, ny));
					map[nx][ny] = '*';
				}
			}
		}
	}
}

class Point {
	int x, y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
