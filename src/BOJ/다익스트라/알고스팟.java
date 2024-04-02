import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N, M;
	static int[][] dist;
	static char[][] arr;
	static int[] dx = {0, 0, 1, -1};
	static int[] dy = {1, -1, 0, 0};
	static int MAX_WALL = 10000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		dist = new int[N][M];
		arr = new char[N][M]; // 함 없애보기

		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine().toCharArray();
			Arrays.fill(dist[i], MAX_WALL);
		}
		dijkstra();

		System.out.println(dist[N-1][M-1]);
	}

	static void dijkstra() {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		dist[0][0] = 0;
		pq.offer(new Node(0, 0, 0));

		while (!pq.isEmpty()) {
			Node current = pq.poll();
			for (int i = 0; i < 4; i++) {
				int nx = current.x + dx[i];
				int ny = current.y + dy[i];
				int nWalls = current.walls;

				if(nx < 0 || nx >= M || ny < 0 || ny >= N)
					continue;
				if(arr[ny][nx] == '1')
					nWalls++;
				if (dist[ny][nx] > nWalls) {
					dist[ny][nx] = nWalls;
					pq.offer(new Node(nx, ny, dist[ny][nx]));
				}
			}
		}
	}
}

class Node implements Comparable<Node> {
	int x;
	int y;
	int walls;

	public Node(int x, int y, int walls) {
		this.x = x;
		this.y = y;
		this.walls = walls;
	}

	@Override
	public int compareTo(Node o) {
		return Integer.compare(this.walls, o.walls);
	}
}
