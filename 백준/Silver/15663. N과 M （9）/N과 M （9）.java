import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {

	static int n, m;
	static int[] input, array;
	static boolean[] check = new boolean[10];
	static StringBuilder sb = new StringBuilder();
	static Set<String> hashSet = new LinkedHashSet<>();

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

		backtracking(0);

		for (String answer : hashSet) {
			System.out.println(answer);
		}
	}

	static void backtracking(int k) {
		if (k == m) {
			for (int i = 0; i < m; i++) {
				sb.append(array[i]).append(" ");
			}
			hashSet.add(sb.toString());
			sb.setLength(0);
			return;
		}

		for (int i = 0; i < n; i++) {
			if (!check[i]) {
				array[k] = input[i];
				check[i] = true;
				backtracking(k + 1);
				check[i] = false;
			}
		}
	}
}
