import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int n, h;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split(" ");
		n = Integer.parseInt(arr[0]);
		h = Integer.parseInt(arr[1]);

		int[] down = new int[n / 2];
		int[] up = new int[n / 2];

		for (int i = 0; i < n; i++) {
			if (i % 2 != 0) {
				down[i / 2] = Integer.parseInt(br.readLine());
			} else {
				up[i / 2] = Integer.parseInt(br.readLine());
			}
		}
		Arrays.sort(down);
		Arrays.sort(up);

		int sum = Integer.MAX_VALUE;
		int cnt = 0;
		for (int i = 1; i <= h; i++) {
			int downCnt = down.length - findLower(down, i);
			int upCnt = up.length - findLower(up, h - i + 1);
			int newSum = downCnt + upCnt;
			if (newSum < sum) {
				sum = newSum;
				cnt = 1;
			} else if (sum == newSum) {
				cnt++;
			}
		}
		System.out.println(sum + " " + cnt);
	}

	static int findLower(int[] arr, int target) {
		int left = 0;
		int right = arr.length;

		while (left < right) {
			int mid = (left + right) / 2;
			if (target <= arr[mid]) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}
}
