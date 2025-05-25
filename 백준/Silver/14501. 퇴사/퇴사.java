import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	static int n;
	static int[] time, price, dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		time = new int[n];
		price = new int[n];
		dp = new int[n + 1];

		for (int i = 0; i < n; i++) {
			String[] arr = br.readLine().split(" ");
			time[i] = Integer.parseInt(arr[0]);
			price[i] = Integer.parseInt(arr[1]);
		}

		for (int i = 0; i < n; i++) {
			int idx = i + time[i];

			if (idx <= n) {
				dp[idx] = Math.max(dp[idx], dp[i] + price[i]);
			}
			dp[i + 1] = Math.max(dp[i + 1], dp[i]);
		}
		System.out.println(dp[n]);
	}
}
