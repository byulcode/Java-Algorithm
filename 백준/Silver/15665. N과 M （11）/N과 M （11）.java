import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static int[] input, arr;
	static StringBuilder sb = new StringBuilder();
	static Set<String> set = new LinkedHashSet<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		input = new int[n];
		arr = new int[m];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(input);
		backtracking(0);

		for (String s : set) {
			System.out.println(s);
		}

		System.out.println(sb.toString());
	}

	static void backtracking(int now) {
		if (now == m) {
			for (int i = 0; i < m; i++) {
				sb.append(arr[i]).append(" ");
			}
			set.add(sb.toString());
			sb.setLength(0);
			return;
		}

		for (int i = 0; i < n; i++) {
			arr[now] = input[i];
			backtracking(now + 1);
		}
	}
}
