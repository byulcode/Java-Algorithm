import java.util.PriorityQueue;
import java.util.Scanner;

class Main {
	static int n;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < n; i++) {
			int num = scanner.nextInt();
			if (num == 0) {
				int k = !pq.isEmpty() ? pq.poll() : 0;
				System.out.println(k);
			} else {
				pq.add(num);
			}
		}
	}
}
