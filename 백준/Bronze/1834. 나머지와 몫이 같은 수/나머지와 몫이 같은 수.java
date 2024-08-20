import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Integer.parseInt(br.readLine());

		long sum = 0;
		for (int i = 0; i < n; i++) {
			long num = i * n + i;
			sum += num;
		}

		System.out.println(sum);
	}
}
