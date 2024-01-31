import java.util.*;

class Solution {
	int[][] land, oil;
	int n, m, ans;
	boolean[][] visited;
	int[] dx = {0, 0, 1, -1};
	int[] dy = {1, -1, 0, 0};

	public int solution(int[][] land) {
		this.land = land;
		n = land.length;
		m = land[0].length;
		visited = new boolean[n][m];
		oil = new int[n][m];
		Map<Integer, Integer> oilCounts = new HashMap<>();

		// 각 구간당 크기 저장
		int oilLevel = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (land[i][j] == 1 && !visited[i][j]) {
					int sum = bfs(i, j, oilLevel);
					oilCounts.put(oilLevel, sum);
					oilLevel++;
				}
			}
		}

		for (int j = 0; j < m; j++) {
			Set<Integer> oilSet = new HashSet<>();
			int sum = 0;
			for (int i = 0; i < n; i++) {
				if (oil[i][j]>0) {
					oilSet.add(oil[i][j]);
				}
			}
			for (int key : oilSet) {
				sum += oilCounts.get(key);
			}
			ans = Math.max(ans, sum);
		}
		return ans;
	}

	int bfs(int x, int y, int oilLevel) {
		int cnt = 1;
		Queue<int[]> queue = new LinkedList<>();
		visited[x][y] = true;
		queue.offer(new int[] {x, y});
		oil[x][y] = oilLevel;

		while (!queue.isEmpty()) {
			int[] p = queue.poll();
			x = p[0];
			y = p[1];
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];

				if (nx < n && nx >= 0 && ny >= 0 && ny < m && !visited[nx][ny] && land[nx][ny] == 1) {
					queue.offer(new int[] {nx, ny});
					cnt++;
					visited[nx][ny] = true;
					oil[nx][ny] = oilLevel;
				}
			}
		}
		return cnt;
	}
}
