import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Main {

	static int n, m, result;
	static int[][] map;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static List<int[]> virusPositions = new ArrayList<>();
	static List<int[]> selectedVirus = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split(" ");
		n = Integer.parseInt(arr[0]);
		m = Integer.parseInt(arr[1]);
		result = Integer.MAX_VALUE;
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			map[i] = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(map[i][j] == 2){
					virusPositions.add(new int[] {i, j});
					map[i][j] = 0;
				}
			}
		}

		backtracking(0, 0);
		if (result == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(result);
		}
	}

	static void backtracking(int start, int k) {
		if (k == m) {
			bfs();
			return;
		}

		for (int i = start; i < virusPositions.size(); i++) {
			selectedVirus.add(virusPositions.get(i));
			backtracking(i + 1, k + 1);
			selectedVirus.remove(selectedVirus.size() -1);
		}
	}

	static void bfs() {
		Queue<int[]> queue = new LinkedList<>();
		int[][] time = new int[n][n];
		boolean[][] visited = new boolean[n][n];
		for (int[] p : selectedVirus) {
			time[p[0]][p[1]] = 0;
			visited[p[0]][p[1]] = true;
			queue.offer(p);
		}

		int maxTime = 0;
		while (!queue.isEmpty()) {
			int[] p = queue.poll();
			for (int i = 0; i < 4; i++) {
				int nx = p[0] + dx[i];
				int ny = p[1] + dy[i];

				if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny] && map[nx][ny] != 1) {
					time[nx][ny] = time[p[0]][p[1]] + 1;
					visited[nx][ny] = true;
					queue.offer(new int[] {nx, ny});
					maxTime = Math.max(maxTime, time[nx][ny]);
				}
			}
		}

		boolean allInfected = true;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 0 && !visited[i][j]) { // 수정된 부분
					allInfected = false;
					break;
				}
			}
			if (!allInfected) break;
		}

		if (allInfected) {
			result = Math.min(result, maxTime);
		}
	}
}
