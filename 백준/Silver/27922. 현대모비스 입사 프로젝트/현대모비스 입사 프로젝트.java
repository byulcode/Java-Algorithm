import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Main {

	static int n, k, result;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		n = scanner.nextInt();
		k = scanner.nextInt();

		List<Integer> sum_12 = new ArrayList<>();
		List<Integer> sum_23 = new ArrayList<>();
		List<Integer> sum_13 = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			int c = scanner.nextInt();

			sum_12.add(a + b);
			sum_23.add(b + c);
			sum_13.add(a + c);
		}

		int s1 = sum_12.stream()
			.sorted(Comparator.reverseOrder())
			.limit(k)
			.mapToInt(Integer::intValue)
			.sum();

		int s2 = sum_23.stream()
			.sorted(Comparator.reverseOrder())
			.limit(k)
			.mapToInt(Integer::intValue)
			.sum();

		int s3 = sum_13.stream()
			.sorted(Comparator.reverseOrder())
			.limit(k)
			.mapToInt(Integer::intValue)
			.sum();

		result = Math.max(s1, Math.max(s2, s3));
		System.out.println(result);
	}
}
