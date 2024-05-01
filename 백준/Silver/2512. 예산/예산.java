import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int n, m, max, cur, divide;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();
		m = Integer.parseInt(br.readLine());
		cur = m;

		Arrays.sort(arr);

		for (int i = 0; i < n; i++) {
			divide = cur / (n - i);
			if (divide >= arr[i]) {
				cur -= arr[i];
				max = arr[i];
				continue;
			}
			max = divide;
			break;
		}

		System.out.println(max);
	}
}
