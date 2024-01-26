import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int n, dpResult;
	static int[] arr, dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		dp = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		operation();
		System.out.println(n - dpResult);
	}

	static void operation() {
		int[] lis = new int[n];
		Arrays.fill(lis, Integer.MAX_VALUE);

		for (int i = 0; i < n; i++) {
			int idx = Arrays.binarySearch(lis, arr[i]);
			if (idx < 0) {
				idx = -(idx + 1);
			}
			lis[idx] = arr[i];
			dp[i] = idx + 1;
			dpResult = Math.max(dpResult, dp[i]);
		}
	}
}
