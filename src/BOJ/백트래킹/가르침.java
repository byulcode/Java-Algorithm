import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, k;
	static int answer = 0;
	static String[] word;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		word = new String[n];
		visited = new boolean[26];

		if (k < 5) {
			System.out.println(0);
			return;
		} else if (k == 26) {
			System.out.println(n);
			return;
		}

		visited['a' - 'a'] = true;
		visited['n' - 'a'] = true;
		visited['t' - 'a'] = true;
		visited['i' - 'a'] = true;
		visited['c' - 'a'] = true;

		for (int i = 0; i < n; i++) {
			word[i] = br.readLine().replaceAll("anta|tica", "");
		}
		check(0, 0);
		System.out.println(answer);
	}

	static void check(int alpha, int count) {
		if (count == k - 5) {
			int temp = 0;
			for (int i = 0; i < n; i++) {
				boolean flag = true;
				for (int j = 0; j < word[i].length(); j++) {
					if (!visited[word[i].charAt(j) - 'a']) {
						flag = false;
						break;
					}
				}
				if (flag) {
					temp++;
				}
			}
			answer = Math.max(temp, answer);
			return;
		}

		for (int i = alpha; i < 26; i++) {
			if (!visited[i]) {
				visited[i] = true;
				check(i, count + 1);
				visited[i] = false;
			}
		}
	}
}
