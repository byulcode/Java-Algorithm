import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static int N, M, start, end;
	static int[] dist, prev;
	static boolean[] visited;
	static ArrayList<Node>[] graph;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());

		graph = new ArrayList[N + 1];
		for (int i = 1; i < N+1; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			graph[s].add(new Node(e, w));
		}
		st = new StringTokenizer(br.readLine(), " ");
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());

		dijkstra();

		Stack<Integer> stack = new Stack<>();
		int cur = end;
		while (cur != start) {
			stack.push(cur);
			cur = prev[cur];
		}
		stack.push(start);

		System.out.println(dist[end]);
		System.out.println(stack.size());
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}

	static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		visited = new boolean[N + 1];
		dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		prev = new int[N + 1];

		Arrays.fill(prev, -1);
		dist[start] = 0;
		pq.offer(new Node(start, 0));

		while (!pq.isEmpty()) {
			Node current = pq.poll();
			if(visited[current.nextCity]) continue;
			visited[current.nextCity] = true;

			for (Node next : graph[current.nextCity]) {
				if (dist[next.nextCity] > dist[current.nextCity] + next.weight) {
					dist[next.nextCity] = dist[current.nextCity] + next.weight;
					prev[next.nextCity] = current.nextCity;
					pq.offer(new Node(next.nextCity, dist[next.nextCity]));
				}
			}
		}
	}
}

class Node implements Comparable<Node> {
	int nextCity;
	int weight;

	public Node(int nextCity, int weight) {
		this.nextCity = nextCity;
		this.weight = weight;
	}

	@Override
	public int compareTo(Node o) {
		return Integer.compare(this.weight, o.weight);
	}
}
