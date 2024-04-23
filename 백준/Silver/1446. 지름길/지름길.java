import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// dp 이용
public class Main {

	static int n, d;
	static int[] dp;
	static List<Street> streets = new ArrayList<>();
	static final int MAX_NUM = 10001;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		n = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		dp = new int[MAX_NUM];
		Arrays.fill(dp, MAX_NUM);

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int length = Integer.parseInt(st.nextToken());

			streets.add(new Street(start, end, length));
		}

		dp[0] = 0;
		for (int i = 1; i < dp.length; i++) {
			for (Street street : streets) {
				if (i == street.end) { // 고속도로 있는 경우
					dp[i] = Math.min(dp[i], Math.min(dp[i-1] + 1, dp[street.start] + street.length));
				}else { // 고속도로 없는 경우
					dp[i] = Math.min(dp[i], dp[i-1] +1);
				}
			}
		}
		System.out.println(dp[d]);
	}
}

class Street {
	int start;
	int end;
	int length;

	public Street(int start, int end, int length) {
		this.start = start;
		this.end = end;
		this.length = length;
	}
}
