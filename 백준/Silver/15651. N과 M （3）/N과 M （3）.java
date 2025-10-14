import java.util.Scanner;

public class Main {
	static int n, m;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		m = scanner.nextInt();
		arr = new int[m];

		func(0);
		System.out.println(sb.toString());
	}

	static void func(int k) {
		if (k == m) {
			for (int a : arr) {
				sb.append(a).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 1; i <= n; i++) {
			arr[k] = i;
			func(k + 1);
		}
	}
}