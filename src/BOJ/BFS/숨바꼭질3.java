import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n, k, ans = Integer.MAX_VALUE;
	static final int MAX_NUM = 100000;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		visited = new boolean[MAX_NUM + 1];

		bfs();
		System.out.println(ans);
	}

	static void bfs() {
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {n, 0});

		while (!queue.isEmpty()) {
			int[] p = queue.poll();
			int x = p[0];
			int t = p[1];
			visited[x] = true;
			if (x == k) {
				ans = Math.min(ans, t);
			}

			if (x * 2 >= 0 && x * 2 <= MAX_NUM && !visited[x * 2])
				queue.add(new int[] {x * 2, t});
			if (x - 1 >= 0 && x - 1 <= MAX_NUM && !visited[x - 1])
				queue.add(new int[] {x - 1, t + 1});
			if (x + 1 >= 0 && x + 1 <= MAX_NUM && !visited[x + 1])
				queue.add(new int[] {x + 1, t + 1});
		}
	}
}
