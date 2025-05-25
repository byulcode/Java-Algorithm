import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		PriorityQueue<Pair> pq = new PriorityQueue<>();


		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			pq.add(new Pair(x, y));
		}

		for (int i = 0; i < n; i++) {
			Pair pair = pq.poll();
			System.out.println(pair.x + " " + pair.y);
		}
	}
}

class Pair implements Comparable<Pair>{
	int x, y;

	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Pair o) {
		return this.x != o.x ? Integer.compare(this.x, o.x) : Integer.compare(this.y, o.y);
	}
}
