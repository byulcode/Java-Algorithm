import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {

	static int n, m, result, level;
	static boolean[] visited;
	static LinkedList<Integer>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		list = new LinkedList[n + 1];
		visited = new boolean[n + 1];

		for (int i = 0; i <= n; i++) {
			list[i] = new LinkedList<>();
		}

		for (int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}

		Queue<Integer> q = new LinkedList<>();
		q.add(1);
		visited[1] = true;

		while (!q.isEmpty() && level < 2) { // bfs
			int size = q.size();
			level++;
			for (int i = 0; i < size; i++) {
				int cur = q.poll();
				for (int friend : list[cur]) {
					if (!visited[friend]) {
						visited[friend] = true;
						result++;
						q.add(friend);
					}
				}
			}
		}
		System.out.println(result);
	}
}
