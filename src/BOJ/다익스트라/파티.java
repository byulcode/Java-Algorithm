import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, X;
	static boolean[] visited;
	static int[][] dist;
	static ArrayList<Street>[][] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		dist = new int[2][N + 1];
		for (int i = 0; i < 2; i++) {
			Arrays.fill(dist[i], Integer.MAX_VALUE);
		}

		graph = new ArrayList[2][N + 1];
		for (int i = 0; i < N+1; i++) {
			graph[0][i] = new ArrayList<>();
			graph[1][i] = new ArrayList<>();
		}

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());

			graph[0][start].add(new Street(end, time));
			graph[1][end].add(new Street(start, time));  // 역으로 입력받기 (모든 정점 -> X까지의 거리를 구하기 위함!)
		}

		dijkstra(0); // X에서부터 모든 정점의 거리
		dijkstra(1); // 모든 정점으로부터 X까지의 거리

		int result = 0;
		for (int i = 1; i <= N; i++) {
			result = Math.max(result, dist[0][i] + dist[1][i]);
		}

		System.out.println(result);
	}

	static void dijkstra(int k) {
		visited = new boolean[N + 1];
		PriorityQueue<Street> pq = new PriorityQueue<>();
		dist[k][X] = 0;
		pq.offer(new Street(X, 0));

		while (!pq.isEmpty()) {
			Street current = pq.poll();
			if(visited[current.to]) continue;
			visited[current.to] = true;

			for (Street s : graph[k][current.to]) {
				if (dist[k][s.to] > dist[k][current.to] + s.time) {
					dist[k][s.to] = dist[k][current.to] + s.time;
					pq.offer(new Street(s.to, dist[k][s.to]));
				}
			}
		}
	}
}

class Street implements Comparable<Street> {
	int to;
	int time;

	public Street(int to, int time) {
		this.to = to;
		this.time = time;
	}

	@Override
	public int compareTo(Street o) {
		return Integer.compare(this.time, o.time);
	}
}
