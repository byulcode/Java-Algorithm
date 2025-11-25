import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

public class Main {
	static int n, sec = 0;
	static int[][] map;
	static Fish shark;
	static List<Fish> fishList = new ArrayList<>();
	static int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];

		for (int i = 0; i < n; i++) {
			String[] arr = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(arr[j]);
				if (map[i][j] == 9) {
					shark = new Fish(i, j, 2);
					map[i][j] = 0;
				} else if (map[i][j] > 0) {
					fishList.add(new Fish(i, j, map[i][j]));
				}
			}
		}

		// 먹을 수 있는 고기 모두 찾기(크기로)
		int cnt = 0;
		while (true) {
			List<Fish> edible = findEdible();
			if (edible.isEmpty()) break;

			PriorityQueue<Fish> pq = new PriorityQueue<>((a, b) -> {
				if (a.dist == b.dist) {
					if (a.x == b.x)
						return a.y - b.y;
					 else
						 return a.x - b.x;
				}
				return a.dist - b.dist;
			});

			for (Fish fish : edible) {
				// 먹을 수 있는 애들로 거리찾기(bfs)
				bfs(fish);
				if (fish.dist != -1) {
					pq.offer(fish);
				}
			}
			if (pq.isEmpty()) break;

			// 가장 거리 가까운 애 찾기. x작거나, y작거나
			Fish target = pq.poll();

			// 물고기 냠
			sec += target.dist;
			cnt++;
			map[target.x][target.y] = 0;
			shark.x = target.x;
			shark.y = target.y;
			fishList.remove(target);
			if (cnt == shark.size) {
				cnt = 0;
				shark.size++;
			}
		}

		System.out.println(sec);
	}

	public static void bfs(Fish target) {
		boolean[][] visited = new boolean[n][n];
		int[][] distMap = new int[n][n];
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {target.x, target.y});
		visited[target.x][target.y] = true;
		while (!queue.isEmpty()) {
			int[] p = queue.poll();
			int x = p[0];
			int y = p[1];
			if (x == shark.x && y == shark.y) {
				target.dist = distMap[x][y];
				return;
			}

			for (int i = 0; i < 4; i++) {
				int nx = x + dir[i][0];
				int ny = y + dir[i][1];

				if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny] && map[nx][ny] <= shark.size) {
					queue.offer(new int[] {nx, ny});
					visited[nx][ny] = true;
					distMap[nx][ny] = distMap[x][y] + 1;
				}
			}
		}
		target.dist = -1; // 못닿음
	}

	public static List<Fish> findEdible() {
		return fishList.stream()
			.filter(f -> f.size < shark.size)
			.collect(Collectors.toList());
	}
}

class Fish {
	int x, y, size, dist;

	public Fish(int x, int y, int size) {
		this.x = x;
		this.y = y;
		this.size = size;
	}
}
