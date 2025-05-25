import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Main {
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		String arr[] = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			pq.add(Integer.parseInt(arr[i]));
		}

		int time = 0;
		int result = 0;
		while (!pq.isEmpty()) {
			time +=  pq.poll();
			result += time;
		}

		System.out.println(result);
	}
}
