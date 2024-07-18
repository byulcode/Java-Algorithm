import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

	static int t;
	static String[] result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());
		result = new String[t];

		for (int i = 0; i < t; i++) {
			String line = br.readLine();
			int[] nums = line.chars()
				.map(c -> c == '(' ? 1 : -1)
				.toArray();

			int sum = 0;
			for (int n : nums) {
				sum += n;
				if (sum < 0) {
					break;
				}
			}
			if (sum != 0) {
				result[i] = "NO";
			} else {
				result[i] = "YES";
			}
		}

		for (String s : result) {
			System.out.println(s);
		}
	}
}
