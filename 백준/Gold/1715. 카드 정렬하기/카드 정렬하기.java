import java.util.PriorityQueue;
import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 0; i < n; i++) {
			pq.offer(scan.nextInt());
		}

		int minComp = 0;
		while (pq.size() > 1) {
			int compare = pq.poll() + pq.poll();
			minComp += compare;
			pq.offer(compare);
		}

		System.out.println(minComp);
	}
}
