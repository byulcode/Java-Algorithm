import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int n, m;
	static int[] arr = new int[10];
	static int[] input;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		m = scanner.nextInt();
		input = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			input[i] = scanner.nextInt();
		}

		Arrays.sort(input);
		backtracking(0);
		System.out.println(sb.toString());
	}

	static void backtracking(int k) {
		if (k == m) {
			for (int i = 0; i < m; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 1; i <= n; i++) {
			arr[k] = input[i];
			backtracking(k + 1);
		}
	}
}

