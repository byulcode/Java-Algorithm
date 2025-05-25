import java.util.Arrays;
import java.util.Scanner;

class Main {

	static int n, k, result;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		n = scanner.nextInt();
		k = scanner.nextInt();
		int[] diffs = new int[n];

		for (int i = 0; i < n; i++) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			diffs[i] = b - a;
		}

		Arrays.sort(diffs);
		result = Math.max(diffs[k - 1], 0);
		System.out.println(result);
	}
}
