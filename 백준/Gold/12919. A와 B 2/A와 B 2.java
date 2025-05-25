import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// t에서 제거하면서 s구하기
class Main {
	static String s, t;
	static int result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s = br.readLine();
		t = br.readLine();

		change(t);
		System.out.println(result);
	}

	static void change(String str) {
		if (str.equals(s)) {
			result = 1;
			return;
		}

		if (str.length() < s.length()) {
			return;
		}

		if (str.charAt(str.length() - 1) == 'A') {
			change(str.substring(0, str.length() - 1));
		}

		if (str.charAt(0) == 'B') {
			String reverse = new StringBuilder(str.substring(1, str.length()))
				.reverse()
				.toString();
			change(reverse);
		}
	}
}
