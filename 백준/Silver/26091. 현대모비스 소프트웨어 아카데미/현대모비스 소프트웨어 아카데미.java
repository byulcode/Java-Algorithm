import java.util.Arrays;
import java.util.Scanner;

class Main {

	static int n, m, result = 0;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		n = scanner.nextInt();
		m = scanner.nextInt();

		scanner.nextLine();
		int[] arr = Arrays.stream(scanner.nextLine().split(" "))
			.mapToInt(Integer::parseInt)
			.sorted()
			.toArray();

		for (int i = 0; i < n / 2; i++) {
			int sum = arr[i] + arr[n - i - 1];
			if(sum >= m) result++;
		}

		System.out.println(result);
	}
}
