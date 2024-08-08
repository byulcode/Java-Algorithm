import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	static int n, result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		while (n <= 1000000) {
			if (isPrime(n) && isBalanced(String.valueOf(n))) {
				result = n;
				break;
			}
			n++;
		}

		if(result == 0)
			result = 1003001;
		System.out.println(result);
	}

	static boolean isBalanced(String num) {
		int half = num.length() / 2;
		for (int i = 0; i < half; i++) {
			if (num.charAt(i) != num.charAt(num.length() - i - 1))
				return false;
		}
		return true;
	}

	static boolean isPrime(int num) {
		if (num <= 1)
			return false;
		if (num <= 3)
			return true;
		if (num % 2 == 0 || num % 3 == 0)
			return false;

		for (int i = 5; i * i <= num; i += 6) {
			if (num % i == 0 || num % (i + 2) == 0) {// 홀수인 경우만 고려
				return false;
			}
		}
		return true;
	}
}
