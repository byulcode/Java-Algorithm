import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Santa {
	int r;
	int c;
	int point;

	public Santa(int r, int c) {
		this.r = r;
		this.c = c;
		this.point = 0;
	}
}

public class Main {

	static int N, M, P, C, D;
	static int ru_r, ru_c;
	static int[][] map;
	static int[] wake_turn;
	static boolean[] dead;
	static Santa[] santas;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1}; //상우하좌

	static void ruMove(int turn) {
		int dist = N * N * 2;
		int dr = 0;    // 루 이동방향
		int dc = 0;
		int index = 0; // 산타 인덱스

		for (int i = 1; i <= P; i++) {
			if (dead[i])
				continue;
			// 가장 가까운 산타 고르기
			int curDist = calculateDistance(ru_r, ru_c, santas[i].r, santas[i].c);
			if (curDist < dist) { // 거리
				dist = curDist;
				index = i;
			}
			if (curDist == dist) {
				if (santas[index].r < santas[i].r) // 거리 같, r
					index = i;
				else if (santas[index].r == santas[i].r && santas[index].c < santas[i].c) // 거리&r 같
					index = i;
			}
		}

		// 루돌프 이동 방향
		if (santas[index].r < ru_r)
			dr = -1;
		else if (santas[index].r > ru_r)
			dr = 1;

		if (santas[index].c < ru_c)
			dc = -1;
		else if (santas[index].c > ru_c)
			dc = 1;

		map[ru_r][ru_c] = 0;
		ru_r += dr;
		ru_c += dc;
		map[ru_r][ru_c] = -1;
		// 만약 산타가 있으면 충돌! 그 가장 가까운 산타랑만 하면됨
		if (ru_r == santas[index].r && ru_c == santas[index].c) {
			wake_turn[index] = turn + 2;
			santas[index].point += C;
			crashAndMoveSanta(index, dr, dc, C);
		}
	}

	static void santaMove(int turn) {
		for (int i = 1; i <= P; i++) {
			if (dead[i])
				continue;
			if (wake_turn[i] > turn)
				continue;
			int dr = 0;
			int dc = 0;

			int minDist = calculateDistance(santas[i].r, santas[i].c, ru_r, ru_c);
			// 4방향 돌려가며 체크, 이동 방향 구하기
			for (int d = 0; d < 4; d++) {
				int nr = santas[i].r + dx[d];
				int nc = santas[i].c + dy[d];
				if (!isInMap(nr, nc))
					continue;
				if (map[nr][nc] > 0)
					continue;
				int curDist = calculateDistance(nr, nc, ru_r, ru_c);
				if (curDist < minDist) {
					dr = dx[d];
					dc = dy[d];
					minDist = curDist;
				}
			}
			map[santas[i].r][santas[i].c] = 0; // 이동 전 위치 0으로
			santas[i].r += dr;
			santas[i].c += dc;

			// 루돌프와 같다면 충돌!
			if (santas[i].r == ru_r && santas[i].c == ru_c) {
				santas[i].point += D;
				wake_turn[i] = turn + 2;
				crashAndMoveSanta(i, -dr, -dc, D);
			} else {
				map[santas[i].r][santas[i].c] = i;
			}
		}
	}

	static void crashAndMoveSanta(int idx, int dr, int dc, int mul) { // idx 산타를 (dr, dc) 방향으로 mul만큼 이동
		int nr = santas[idx].r + dr * mul;
		int nc = santas[idx].c + dc * mul;
		if (!isInMap(nr, nc)) {
			dead[idx] = true;
			return;
		}
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {idx, nr, nc});

		while (!queue.isEmpty()) {
			int[] p = queue.poll();
			idx = p[0];
			nr = p[1];
			nc = p[2];

			if (!isInMap(nr, nc)) {
				dead[p[0]] = true;
				return;
			}

			if (map[nr][nc] == 0) {
				map[nr][nc] = idx;
				santas[idx].r = nr;
				santas[idx].c = nc;
				return;
			}

			if (map[nr][nc] > 0) {
				int nextIdx = map[nr][nc];
				map[nr][nc] = idx;
				santas[idx].r = nr;
				santas[idx].c = nc;
				queue.offer(new int[] {nextIdx, nr + dr, nc + dc});
			}
		}
	}

	static boolean isInMap(int r, int c) {
		return r > 0 && r <= N && c > 0 && c <= N;
	}

	static int calculateDistance(int r1, int c1, int r2, int c2) {
		return (r1 - r2) * (r1 - r2) + (c1 - c2) * (c1 - c2);
	}

	static int bonus() {
		int count = 0;
		for (int i = 1; i <= P; i++) {
			if (dead[i])
				continue;
			santas[i].point += 1;
			count++;
		}
		return count;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		ru_r = Integer.parseInt(st.nextToken());
		ru_c = Integer.parseInt(st.nextToken());

		map = new int[N + 1][N + 1];
		santas = new Santa[P + 1];
		wake_turn = new int[P + 1];
		dead = new boolean[P + 1];

		map[ru_r][ru_c] = -1;
		for (int i = 0; i < P; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int num = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			santas[num] = new Santa(r, c);
			map[r][c] = num;
		}

		for (int turn = 1; turn <= M; turn++) {
			// 루돌프 이동
			ruMove(turn);

			// 산타 이동
			santaMove(turn);

			// 살아남은 자 체크
			if (bonus() == 0) {
				break;
			}
		}
		for (int i = 1; i <= P; i++) {
			System.out.print(santas[i].point + " ");
		}
	}
}
