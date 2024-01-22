import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int[] h, dpUp, dpDown;
	static int N, ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		h = new int[N];
		dpUp = new int[N];
		dpDown = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			h[i] = Integer.parseInt(st.nextToken());
		}
		dpIncrease();
		dpDecrease();

		for (int i = 0; i < N; i++) {
			ans = Math.max(ans, dpUp[i] + dpDown[i]);
		}

		System.out.println(ans - 1);
	}

	// LIS
	static void dpIncrease() {
		int[] lis = new int[N];
		Arrays.fill(lis, Integer.MAX_VALUE);

		for (int i = 0; i < N; i++) {
			int idx = Arrays.binarySearch(lis, h[i]);
			if (idx < 0) {
				idx = -(idx + 1);
			}
			lis[idx] = h[i];
			dpUp[i] = idx + 1;
		}
	}

	// LDS
	static void dpDecrease() {
		int[] lis = new int[N];
		Arrays.fill(lis, Integer.MAX_VALUE);
		for (int i = N - 1; i >= 0; i--) {
			int idx = Arrays.binarySearch(lis, h[i]);
			if (idx < 0) {
				idx = -(idx + 1);
			}
			lis[idx] = h[i];
			dpDown[i] = idx + 1;
		}
	}
}
