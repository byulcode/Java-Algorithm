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
		arr = new int[m];

		input = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();

		Arrays.sort(input);
		backtracking(0);

		for (String s : set) {
			System.out.println(s);
		}
	}

	static void backtracking(int k) {
		if (k == m) {
			for (int a : arr) {
				sb.append(a).append(" ");
			}
			set.add(sb.toString());
			sb.setLength(0);
			return;
		}

		for (int i = 0; i < n; i++) {
			if(k > 0 && arr[k-1] > input[i])
				continue;
			arr[k] = input[i];
			backtracking(k + 1);
		}
	}
}
