import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

	static int n, m;
	static int i,j,k;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		m = scanner.nextInt();

		Map<Integer, Integer> basket = new HashMap<>();

		for (int i = 1; i <= n; i++) {
			basket.put(i, 0);
		}

		for (int a = 0; a < m; a++) {
			i = scanner.nextInt();
			j = scanner.nextInt();
			k = scanner.nextInt();

			for (int w = i; w <= j; w++) {
				basket.put(w, k);
			}
		}

		for (Integer value : basket.values()) {
			System.out.print(value + " ");
		}
	}
}

