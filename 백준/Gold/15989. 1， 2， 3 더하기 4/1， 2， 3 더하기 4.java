import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {

	static int t;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		dp = new int[10001];

		Arrays.fill(dp, 1);
		for (int i = 2; i < 10001; i++) {
			dp[i] += dp[i - 2];
		}

		for (int i = 3; i < 10001; i++) {
			dp[i] += dp[i - 3];
		}

		for (int i = 0; i < t; i++) {
			int num = Integer.parseInt(br.readLine());
			System.out.println(dp[num]);
		}
	}
}
