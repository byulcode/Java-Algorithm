import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n, m;
	static int[] arr;
	static List<Integer> results = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n + 1];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			calculate(start, end, k);
		}

		for (int result : results) {
			System.out.println(result);
		}
	}

	public static void calculate(int start, int end, int k) {
		int[] subArray = Arrays.copyOfRange(arr, start, end + 1);
		Arrays.sort(subArray);
		results.add(subArray[k - 1]);
	}
}
