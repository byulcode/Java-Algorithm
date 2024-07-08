import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

	static int n, m;
	static int[] input, array;
	static boolean[] isChecked = new boolean[10];
	static StringBuilder sb = new StringBuilder();
	static Set<String> stringSet = new LinkedHashSet<>();

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

		for (String s : stringSet) {
			System.out.println(s);
		}
	}

	static void backtracking(int k, int start) {
		if (k == m) {
			for (int i = 0; i < m; i++) {
				sb.append(array[i] + " ");
			}
			stringSet.add(sb.toString());
			sb.setLength(0);
			return;
		}

		for (int i = start; i < n; i++) {
			if (!isChecked[i]) {
				isChecked[i] = true;
				array[k] = input[i];
				backtracking(k + 1, i);
				isChecked[i] = false;
			}
		}
	}
}
