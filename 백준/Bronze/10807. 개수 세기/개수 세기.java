import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Map<Integer, Integer> map = new HashMap<>();
		int n = scan.nextInt();

		for (int i = 0; i < n; i++) {
			int num = scan.nextInt();
			map.put(num, map.getOrDefault(num, 0) + 1);
		}

		int result = map.getOrDefault(scan.nextInt(), 0);
		System.out.println(result);
	}
}
