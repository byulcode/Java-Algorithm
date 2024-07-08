import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		List<Integer> results = new ArrayList<>();

		for (int i = 0; i < t; i++) {
			String[] arr = br.readLine().split(" ");
			int n = Integer.parseInt(arr[0]);
			int m = Integer.parseInt(arr[1]);
			results.add(nCr(m, n));
		}

		for (int i : results) {
			System.out.println(i);
		}
	}

	public static int nCr(int n, int r) {
		int[][] c = new int[n + 1][r + 1];

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= Math.min(i, r); j++) {
				if (j == 0 || j == i) {
					c[i][j] = 1;
				} else {
					c[i][j] = c[i - 1][j - 1] + c[i - 1][j];
				}
			}
		}
		return c[n][r];
	}
}

