import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static int l, c;
	static char[] input, arr;
	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	static Set<String> set = new LinkedHashSet<>();
	static List<Character> vList = List.of('a', 'e', 'i', 'o', 'u');

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		l = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		String a = br.readLine().replaceAll(" ", "");

		input = a.toCharArray();
		arr = new char[l];
		visited = new boolean[c];

		Arrays.sort(input);
		backtracking(0, 0);

		for (String s : set) {
			System.out.println(s);
		}
	}

	static void backtracking(int k, int start) {
		if (k == l) {
			int vCnt = 0, cCnt = 0;
			for (char ch : arr) {
				if (vList.contains(ch)) {
					vCnt++;
				} else {
					cCnt++;
				}
			}

			if (vCnt >= 1 && cCnt >= 2) {
				for (char a : arr) {
					sb.append(a);
				}
				set.add(sb.toString());
			}
			sb.setLength(0);
			return;
		}

		for (int i = start; i < c; i++) {
			if (k > 0 && arr[k - 1] > input[i])
				continue;
			if (!visited[i]) {
				arr[k] = input[i];
				visited[i] = true;
				backtracking(k + 1, start + 1);
				visited[i] = false;
			}
		}
	}
}
