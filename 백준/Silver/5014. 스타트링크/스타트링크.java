import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int f, s, g, u, d;
	static int[] direction;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		f = Integer.parseInt(st.nextToken());    // 총 층수
		s = Integer.parseInt(st.nextToken());    // 현재 층
		g = Integer.parseInt(st.nextToken());    // 스타트링크(목적지)
		u = Integer.parseInt(st.nextToken());    // 위로 U
		d = Integer.parseInt(st.nextToken());    // 아래로 D
		direction = new int[] {u, -d};
		visited = new boolean[f + 1];

		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {s, 0});
		int cnt = 0;
		visited[s] = true;
		boolean flag = false;
		while (!queue.isEmpty()) {
			int p[] = queue.poll();
			int cur = p[0];
			int count = p[1];

			if (cur == g) {
				flag = true;
				cnt = count;
				break;
			}

			for (int i = 0; i < 2; i++) {
				int next = cur + direction[i];
				if (next < 1 || next > f || visited[next])
					continue;
				visited[next] = true;
				queue.offer(new int[] {next, count + 1});
			}
		}

		if (!flag)
			System.out.println("use the stairs");
		else
			System.out.println(cnt);
	}
}
