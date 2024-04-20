import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	static int n, ans;
	static int[][] arr;
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		dp = new int[n];
		arr = new int[n][2];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));

		lis();

		System.out.println(n - ans);
	}

	static void lis() {
		int[] lis = new int[n];
		Arrays.fill(lis, Integer.MAX_VALUE);

		for (int i = 0; i < n; i++) {
			int idx = Arrays.binarySearch(lis, arr[i][1]);
			if (idx < 0) {
				idx = -(idx + 1);
			}
			lis[idx] = arr[i][1];
			dp[i] = idx + 1;
			ans = Math.max(ans, dp[i]);
		}
	}
}
