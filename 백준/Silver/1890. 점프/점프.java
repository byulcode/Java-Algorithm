import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {

	static int n;
	static int[][] map;
	static long[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		dp = new long[n][n];
		dp[0][0] = 1;
		for (int i = 0; i < n; i++) {
			map[i] = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 0 || dp[i][j] == 0)
					continue;

				int down = i + map[i][j];
				int right = j + map[i][j];

				if (down < n)
					dp[down][j] += dp[i][j];
				if (right < n) {
					dp[i][right] += dp[i][j];
				}
			}
		}
		System.out.println(dp[n - 1][n - 1]);
	}
}
