import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static int n, k;
	static final int MAX_NUM = 100001;
	static int[] dist = new int[MAX_NUM];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] a = br.readLine().split(" ");
		n = Integer.parseInt(a[0]);
		k = Integer.parseInt(a[1]);
		dist = new int[MAX_NUM];

		System.out.println(bfs() - 1);
	}

	static int bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.offer(n);
		dist[n] = 1;

		while (!q.isEmpty()) {
			int x = q.poll();

			if (x == k) {
				return dist[x];
			}

			for (int i = 0; i < 3; i++) {
				int next = operation(x, i);
				if (next < 0 || next > MAX_NUM - 1 || dist[next] > 0)
					continue;
				q.offer(next);
				dist[next] = dist[x] + 1;
			}
		}
		return 0;
	}

	static int operation(int x, int i) {
		switch (i) {
			case 0:
				return x + 1;
			case 1:
				return x - 1;
			case 2:
				return x * 2;
		}
		return x;
	}
}
