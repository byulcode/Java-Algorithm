import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split(" ");
		int m = Integer.parseInt(arr[0]);
		int n = Integer.parseInt(arr[1]);

		for (int i = m; i <= n; i++) {
			if (isPrime(i)) {
				System.out.println(i);
			}
		}
	}

	static boolean isPrime(int num) {
		if (num <= 1)
			return false;
		if (num <= 3)
			return true;

		if (num % 2 == 0 || num % 3 == 0)
			return false;

		for (long i = 5; i * i <= num; i+= 6) {
			if (num % i == 0 || num % (i + 2) == 0)
				return false;
		}
		return true;
	}
}
