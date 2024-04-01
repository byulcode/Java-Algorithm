import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N, E, V1, V2;
	static int[][] dist;
	static ArrayList<Node>[] graph;
	static int INF = 200000000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		dist = new int[3][N+1];
		for (int i = 0; i < 3; i++) {
			Arrays.fill(dist[i], INF);
		}

		graph = new ArrayList[N+1];
		for (int i = 0; i < N+1; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			graph[u].add(new Node(v, c));
			graph[v].add(new Node(u, c));
		}
		st = new StringTokenizer(br.readLine(), " ");
		V1 = Integer.parseInt(st.nextToken());
		V2 = Integer.parseInt(st.nextToken());

		dijkstra(1, 0);
		dijkstra(V1, 1);
		dijkstra(N, 2);

		int result = Math.min(dist[0][V1] + dist[1][V2] + dist[2][V2], dist[0][V2] + dist[1][V2] + dist[2][V1]);

		if (result >= INF) {
			result = -1;
		}
		System.out.println(result);
	}

	static void dijkstra(int start, int index) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		dist[index][start] = 0;

		while (!pq.isEmpty()) {
			Node current = pq.poll();
			for (Node next : graph[current.to]) {
				if (dist[index][next.to] > dist[index][current.to] + next.cost) {
					dist[index][next.to] = dist[index][current.to] + next.cost;
					pq.offer(new Node(next.to, dist[index][next.to]));
				}
			}
		}
	}
}

class Node implements Comparable<Node> {
	int to;
	int cost;

	public Node(int to, int cost) {
		this.to = to;
		this.cost = cost;
	}

	@Override
	public int compareTo(Node o) {
		return Integer.compare(this.cost, o.cost);
	}
}
