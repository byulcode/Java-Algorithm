import java.util.Scanner;

public class Main {

	static int n, m;
	static int[] arr = new int[10];    // 수열을 저장할 배열
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		m = scanner.nextInt();

		printNums(0, 1);
		System.out.println(sb.toString());
	}

	static void printNums(int k, int start) {
		if (k == m) {
			for (int i = 0; i < m; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = start; i <= n; i++) {
			arr[k] = i;
			printNums(k + 1, i);
		}
	}
}

