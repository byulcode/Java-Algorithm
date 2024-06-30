import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

	static int n;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		for (int i = 0; i < n; i++) {
			String[] arr = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				pq.add(Integer.parseInt(arr[j]));
			}
		}

		for (int i = 0; i < n-1; i++) {
			pq.poll();
		}
		System.out.println(pq.poll());
	}
}

