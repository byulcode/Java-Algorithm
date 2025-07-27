import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
	static int n, m, result;
	static int r, c, d;
	static int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	static int[][] map;
	static boolean[][] cleaned;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		cleaned = new boolean[n][m];

		st = new StringTokenizer(br.readLine(), " ");
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while (true) {
			// 현재 칸 청소
			if (isCleanable(r, c)) {
				cleaned[r][c] = true;
				result++;
			}

			// 4칸 중 청소 가능하면?
			if (hasCleanableSpace()) {
				d = (d + 3) % 4;
				int nx = r + direction[d][0];
				int ny = c + direction[d][1];
				if (isCleanable(nx, ny)) {
					r = nx;
					c = ny;
				}
			} else {
				// 후진! 후진 불가능할 경우 멈추기
				int bx = r - direction[d][0];
				int by = c - direction[d][1];
				if (map[bx][by] == 1) {
					break;
				} else {
					r = bx;
					c = by;
				}
			}
		}

		System.out.println(result);
	}


	// 4칸 중 청소 가능한 곳이 있는지
	static boolean hasCleanableSpace() {

		for (int i = 0; i < 4; i++) {
			int nx = r + direction[i][0];
			int ny = c + direction[i][1];
			if (isCleanable(nx, ny))
				return true;
		}
		return false;
	}

	static boolean isCleanable(int r1, int c1) {
		return map[r1][c1] == 0 && !cleaned[r1][c1];
	}
}
