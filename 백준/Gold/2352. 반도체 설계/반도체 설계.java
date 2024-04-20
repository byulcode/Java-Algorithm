import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int[] m, dp;
	static int n, ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = new int[n];
		dp = new int[n];

		String[] arr = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			m[i] = Integer.parseInt(arr[i]);
		}

		dpIncrease();
		System.out.println(ans);
	}

	// LIS
	static void dpIncrease() {
		int[] lis = new int[n];
		Arrays.fill(lis, Integer.MAX_VALUE);

		for (int i = 0; i < n; i++) {
			int idx = Arrays.binarySearch(lis, m[i]);

			if (idx < 0) {
				idx = -(idx + 1);
			}
			lis[idx] = m[i];
			dp[i] = idx + 1;
			ans = Math.max(ans, dp[i]);
		}
	}
}
