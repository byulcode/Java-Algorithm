import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N, ans;
	static char[][] array;
	static int[][][] dp; // 0 : 가로, 1 : 세로, 2 : 대각선

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		array = new char[N][N];
		dp = new int[3][N][N];

		dp[0][0][1] = 1;

		for (int i = 0; i < N; i++) {
			String[] arr = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				array[i][j] = arr[j].charAt(0);
			}
		}

		for (int i = 2; i < N; i++) {
			if (array[0][i] == '0') {
				dp[0][0][i] += dp[0][0][i - 1];
			}
		}

		for (int r = 1; r < N; r++) {
			for (int c = 1; c < N; c++) {

				// 가로 or 세로
				if (array[r][c] == '0') {
					dp[0][r][c] = dp[0][r][c - 1] + dp[2][r][c - 1];
					dp[1][r][c] = dp[1][r - 1][c] + dp[2][r - 1][c];
				}

				if (array[r][c] == '0' && array[r - 1][c] == '0' && array[r][c - 1] == '0') {
					dp[2][r][c] = dp[0][r-1][c - 1] + dp[1][r - 1][c-1] + dp[2][r - 1][c - 1];
				}
			}
		}
		for (int i = 0; i < 3; i++) {
			ans += dp[i][N - 1][N - 1];
		}
		System.out.println(ans);
	}
}
