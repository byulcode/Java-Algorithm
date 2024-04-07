import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int N, ans;
	static int[][] arr;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visited = new boolean[N];
		ans = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			arr[i] = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		}

		dfs(0,0);
		System.out.println(ans);
	}

	static void dfs(int num, int startIdx) {
		if (num == N / 2) {
			calculateDifference();
			return;
		}

		for (int i = startIdx; i < N; i++) {
			visited[i] = true;
			dfs(num + 1, i + 1);
			visited[i] = false;
		}
	}

	static void calculateDifference() {
		int start = 0;
		int link = 0;

		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				if (visited[i] && visited[j]) {
					start += arr[i][j] + arr[j][i];
				} else if (!visited[i] && !visited[j]) {
					link += arr[i][j] + arr[j][i];
				}
			}
		}
		int diff = Math.abs(start - link);
		ans = Math.min(ans, diff);
	}
}
