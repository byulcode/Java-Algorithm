import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
	static int l, n;
	static int low = 0;
	static int high = 1000;
	static int[] nums;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		l = Integer.parseInt(br.readLine());
		nums = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();
		n = Integer.parseInt(br.readLine());

		for (int i = 0; i < l; i++) {
			if (nums[i] == n) {
				System.out.println(0);
				return;
			} else if (nums[i] < n && nums[i] > low)
				low = nums[i];
			else if (nums[i] > n && nums[i] < high)
				high = nums[i];
		}

		int cnt = 0;
		for (int i = (low + 1); i <= n; i++) {
			for (int j = n; j < high; j++) {
				cnt++;
			}
		}
		System.out.println(cnt - 1);
	}
}
