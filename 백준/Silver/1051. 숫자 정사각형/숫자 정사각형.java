import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
	static int n, m, maxSize;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		maxSize = 0;

		int[][] arr = new int[n][m];
		for (int i = 0; i < n; i++) {
			arr[i] = Arrays.stream(br.readLine().split(""))
				.mapToInt(Integer::parseInt)
				.toArray();
		}
		for (int size = 1; size < Math.min(n, m); size++) {
			for (int i = 0; i < n - size; i++) {
				for (int j = 0; j < m - size; j++) {
					if (arr[i][j] == arr[i][j + size] &&
						arr[i][j] == arr[i + size][j] &&
						arr[i][j] == arr[i + size][j + size]) {
						maxSize = Math.max(maxSize, size);
					}
				}
			}
		}
		maxSize++;
		System.out.println(maxSize * maxSize);
	}
}
