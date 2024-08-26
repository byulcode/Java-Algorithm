import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	static int t, n, m;
	static int[] results;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		results = new int[t];

		for (int i = 0; i < t; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
			Queue<int[]> q = new LinkedList<>();

			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < n; j++) {
				int num = Integer.parseInt(st.nextToken());
				q.add(new int[] {j, num});
				pq.add(num);
			}

			int printOrder = 0;
			while (!q.isEmpty()) {
				int[] current = q.poll();
				int currentIdx = current[0];
				int currentPriority = current[1];

				if (currentPriority == pq.peek()) {
					printOrder++;
					pq.poll();

					if (currentIdx == m) {
						results[i] = printOrder;
						break;
					}
				} else {
					q.offer(current);
				}
			}
		}
		for (int r : results) {
			System.out.println(r);
		}
	}

}
