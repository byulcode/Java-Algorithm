import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int n, m;
	static int[] input, array;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		m = scanner.nextInt();

		input = new int[n];
		array = new int[m];

		for (int i = 0; i < n; i++) {
			input[i] = scanner.nextInt();
		}
		Arrays.sort(input);

		backtracking(0, 0);
		System.out.println(sb.toString());
	}

	static void backtracking(int k, int start) {
		if (k == m) {
			for (int i = 0; i < m; i++) {
				sb.append(array[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = start; i < n; i++) {
			array[k] = input[i];
			backtracking(k + 1, i);
		}
	}
}
