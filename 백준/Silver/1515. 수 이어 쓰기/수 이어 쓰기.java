import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static String s;
	static int n;
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s = br.readLine();
		sb = new StringBuilder(s);

		backtracking(1);
		System.out.println(n);
	}

	static void backtracking(int k) {
		if (sb.length() == 0) {
			n = k - 1;
			return;
		}

		String num = Integer.toString(k);
		for (int i = 0; i < num.length(); i++) {
			if (sb.length() > 0 && sb.charAt(0) == num.charAt(i)) {
				sb.deleteCharAt(0);
			}
		}
		backtracking(k + 1);
	}
}
