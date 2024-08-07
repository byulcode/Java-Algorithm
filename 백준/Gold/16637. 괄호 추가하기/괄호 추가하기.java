import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

	static int n;
	static int result = Integer.MIN_VALUE;

	static char[] input;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		input = br.readLine().toCharArray();
		solve(2, input[0] - '0');

		System.out.println(result);
	}

	static void solve(int idx, int total) {
		if (idx >= n) {
			result = Math.max(result, total);
			return;
		}

		if (idx + 2 < n) {
			// 오른쪽 수 연산
			int right = operation(input[idx] - '0', input[idx + 2] - '0', input[idx + 1]);
			// 지금까지의 수와 오른쪽 수 연산
			int sum = operation(total, right, input[idx - 1]);
			solve(idx + 4, sum);
		}

		// (지금까지의 결과값) & (현재 숫자)를 계산
		solve(idx + 2, operation(total, input[idx] - '0', input[idx - 1]));
	}

	static int operation(int x, int y, char op) {
		if (op == '+')
			return x + y;
		else if (op == '-')
			return x - y;
		else
			return x * y;
	}
}
