import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	static int n, m;
	static char[][] map;
	static int result = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split(" ");
		n = Integer.parseInt(arr[0]);
		m = Integer.parseInt(arr[1]);
		map = new char[n][m];

		for (int i = 0; i < n; i++) {
			map[i] = br.readLine().toCharArray();
		}

		for (int i = 0; i <= n - 8; i++) {
			for (int j = 0; j <= m - 8; j++) {
				check(i, j);
			}
		}
		System.out.println(result);
	}

	static void check(int x, int y) {
		int cnt1 = 0;
		int cnt2 = 0;
		for (int i = x; i < x + 8; i++) {
			for (int j = y; j < y + 8; j++) {
				if ((i + j) % 2 == 0) {
					if (map[i][j] != 'B')
						cnt1++;
					if (map[i][j] != 'W')
						cnt2++;
				} else {
					if (map[i][j] != 'W')
						cnt1++;
					if (map[i][j] != 'B')
						cnt2++;
				}
			}
		}
		result = Math.min(result, Math.min(cnt1, cnt2));
	}
}
