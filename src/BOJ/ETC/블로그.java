import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int n, x;
	static int[] arr;
	static Integer[] p;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());

		arr = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();

		int m = n - x + 1;
		p = new Integer[m];
		p[0] = Arrays.stream(arr, 0, x).sum();

		for (int i = 1; i < m; i++) {
			p[i] = p[i - 1] - arr[i - 1] + arr[i - 1 + x];
		}

		Arrays.sort(p);
		int max = p[m - 1];
		int count = 0;

		for (int i = m - 1; i >= 0; i--) {
			if (p[i] == max) {
				count++;
			}else break;
		}

		if (p[0] == 0) {
			System.out.println("SAD");
		} else {
			System.out.println(max);
			System.out.println(count);
		}
	}
}
