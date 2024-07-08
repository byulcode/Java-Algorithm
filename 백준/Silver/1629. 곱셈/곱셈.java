import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] nums = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();

		long result = rec(nums[0], nums[1], nums[2]);
		System.out.println(result);
	}

	static long rec(int a, int b, int c) {
		if (b == 0)
			return 1;

		long value = rec(a, b / 2, c);

		if (b % 2 == 1) {
			return (value * value % c) * a % c;
		}
		return value * value % c;
	}
}

