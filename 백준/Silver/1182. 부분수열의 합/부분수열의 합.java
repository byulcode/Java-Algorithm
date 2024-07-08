import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, s;
	static int cnt;
	static int[] input;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		input = new int[n];

		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}

		backtracking(0, 0);

		if (s == 0) {
			cnt--; // 공집합 제외
		}
		System.out.println(cnt);
	}

	static void backtracking(int sum, int index) {
		if(index == n){
			if (sum == s) {
				cnt++;
			}
			return;
		}

		// 현재 수 선택
		backtracking(sum + input[index], index + 1);

		// 현재 수 선택X
		backtracking(sum, index + 1);
	}
}
