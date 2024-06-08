import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int n, m;
	static int[] input;
	static int[] arr = new int[10];    // 수열을 저장할 배열
	static boolean[] isChecked = new boolean[10];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		m = scanner.nextInt();

		input = new int[n];
		for (int i = 0; i < n; i++) {
			input[i] = scanner.nextInt();
		}
		Arrays.sort(input);

		printNums(0);
		System.out.println(sb.toString());
	}

	static void printNums(int k) {
		if (k == m) {
			for (int i = 0; i < m; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
		}

		for (int i = 0; i < n; i++) {
			if (!isChecked[i]) {
				arr[k] = input[i];
				isChecked[i] = true;
				printNums(k + 1);
				isChecked[i] = false;
			}
		}
	}
}

