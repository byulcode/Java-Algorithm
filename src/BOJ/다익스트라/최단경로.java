import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int V, E, K;
	static int[] dist;
	static boolean[] visited;
	static ArrayList<Node>[] graph;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());

		graph = new ArrayList[V + 1];
		for (int i = 1; i < V+1; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 1; i < E+1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			graph[u].add(new Node(v, w));
		}

		dijkstra();
	}

	static void dijkstra() {
		visited = new boolean[V + 1];
		dist = new int[V + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[K] = 0;

		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(K, 0));

		while (!pq.isEmpty()) {
			int nowVertex = pq.poll().index;
			if(visited[nowVertex]) continue;

			for (Node next : graph[nowVertex]) {
				visited[nowVertex] = true;
				if (dist[next.index] > dist[nowVertex] + next.cost) {
					dist[next.index] = dist[nowVertex] + next.cost;

					pq.offer(new Node(next.index, dist[next.index]));
				}
			}
		}

		for (int i=1;i<dist.length;i++) {
			if(dist[i] == Integer.MAX_VALUE)
				System.out.println("INF");
			else System.out.println(dist[i]);
		}
	}

}
class Node implements Comparable<Node> {
	int index;
	int cost;

	public Node(int index, int cost) {
		this.index = index;
		this.cost = cost;
	}

	@Override
	public int compareTo(Node o) {// cost기준 오름차순 정렬
		return Integer.compare(this.cost, o.cost);
	}
}
