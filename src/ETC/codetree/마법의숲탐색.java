import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 코드트리 마법의 숲 탐색
// https://www.codetree.ai/ko/frequent-problems/samsung-sw/problems/magical-forest-exploration/description
public class Main {

	static int R, C, K;
	static int result = 0;
	static int map[][];
	static boolean[][] exitMap;
	static int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 상, 우, 하, 좌

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken()) + 3; // 골렘 처음 위치를 고려. 정령 위치 구할때 -3
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		exitMap = new boolean[R][C];

		for (int k = 1; k <= K; k++) {
			st = new StringTokenizer(br.readLine(), " ");
			int ci = Integer.parseInt(st.nextToken()) - 1;
			int di = Integer.parseInt(st.nextToken());
			Golem nowGolem = new Golem(1, ci, k, di);

			while (true) { // 이동이 불가능할 때까지!
				// 이동할 방향 파악
				int dir = findMoveDirection(nowGolem);

				// 이동 불가? 벗어나기!
				if (dir == 0) {
					break;
				}

				// 이동!
				move(dir, nowGolem);
			}

			// 범위 밖이라면 => map 싹 비우기. 정렬 계산X
			if (nowGolem.r < 4) {
				for (int i = 0; i < R; i++) {
					Arrays.fill(map[i], 0);
					Arrays.fill(exitMap[i], false);
				}
				continue;
			}
			// 만약 범위 내라면 => 정령 열 계산
			int maxRow = bfs(nowGolem);
			result += maxRow;
		}

		System.out.println(result);
	}

	static int bfs(Golem golem) {
		boolean[][] visited = new boolean[R][C];
		Queue<int[]> queue = new LinkedList<>();
		visited[golem.r][golem.c] = true;
		queue.add(new int[] {golem.r, golem.c});
		int maxR = golem.r;

		while (!queue.isEmpty()) {
			int[] p = queue.poll();

			for (int i = 0; i < 4; i++) {
				int nx = p[0] + direction[i][0];
				int ny = p[1] + direction[i][1];

				if (isInMap(nx, ny) && !visited[nx][ny] &&
					(map[nx][ny] == map[p[0]][p[1]] || (map[nx][ny] != 0 && exitMap[p[0]][p[1]]))) {
					queue.add(new int[] {nx, ny});
					maxR = Math.max(maxR, nx);
					visited[nx][ny] = true;
				}
			}
		}
		return maxR - 2;
	}

	static void move(int dir, Golem golem) {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == golem.num) {
					map[i][j] = 0;
					exitMap[i][j] = false;
				}
			}
		}

		switch (dir) {
			case 1: // 아래로 이동
				golem.r += 1;
				setNewMap(golem);
				break;
			case 2:
				golem.r += 1;
				golem.c -= 1;
				golem.d = (golem.d - 1 + 4) % 4;
				setNewMap(golem);
				break;
			case 3:
				golem.r += 1;
				golem.c += 1;
				golem.d = (golem.d + 1) % 4;
				setNewMap(golem);
				break;
		}
	}

	static void setNewMap(Golem golem) {
		int r = golem.r;
		int c = golem.c;
		map[r][c] = golem.num;

		for (int i = 0; i < 4; i++) {
			map[r + direction[i][0]][c + direction[i][1]] = golem.num;
		}

		int exitR = golem.r + direction[golem.d][0];
		int exitC = golem.c + direction[golem.d][1];
		exitMap[exitR][exitC] = true;
	}

	static boolean isInMap(int r, int c) {
		return r >= 0 && r < R && c >= 0 && c < C;
	}

	static int findMoveDirection(Golem golem) { // 1 : 아래. 2: -90도(서쪽), 3: +90도 동쪽, 0:불가능
		int r = golem.r;
		int c = golem.c;
		if (isInMap(r + 2, c) &&
			map[r + 2][c] == 0 &&
			map[r + 1][c - 1] == 0 &&
			map[r + 1][c + 1] == 0) {
			return 1;
		} else if (isInMap(r, c - 2) && isInMap(r + 2, c - 1) &&
			map[r - 1][c - 1] == 0 &&
			map[r][c - 2] == 0 &&
			map[r + 1][c - 1] == 0 &&
			map[r + 2][c - 1] == 0 &&
			map[r + 1][c - 2] == 0) {
			return 2;
		} else if (isInMap(r, c + 2) && isInMap(r + 2, c + 1) &&
			map[r - 1][c + 1] == 0 &&
			map[r][c + 2] == 0 &&
			map[r + 1][c + 1] == 0 &&
			map[r + 2][c + 1] == 0 &&
			map[r + 1][c + 2] == 0
		) {
			return 3;
		} else
			return 0;
	}
}

class Golem {
	int r, c; // 중앙 좌표
	int num; // 삽입된 순서
	int d; // 출구 방향

	public Golem(int r, int c, int num, int d) {
		this.r = r;
		this.c = c;
		this.num = num;
		this.d = d;
	}
}
