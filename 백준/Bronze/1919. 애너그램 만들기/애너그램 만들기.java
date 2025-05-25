import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] aCnt = count(br.readLine());
		int[] bCnt = count(br.readLine());

		int sum = 0;
		for (int i = 0; i < 26; i++) {
			sum += Math.abs(aCnt[i] - bCnt[i]);
		}
		System.out.println(sum);
	}

	static int[] count(String s) {
		int[] alphabet = new int[26];
		for (int i = 0; i < s.length(); i++) {
			alphabet[s.charAt(i) - 'a']++;
		}
		return alphabet;
	}
}
