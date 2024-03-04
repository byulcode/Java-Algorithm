import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int n, k;
	static char[] hamburger;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split(" ");
		n = Integer.parseInt(arr[0]);
		k = Integer.parseInt(arr[1]);
		hamburger = new char[n];
		hamburger = br.readLine().toCharArray();
		int cnt = 0;

		for (int i = 0; i < n; i++) {
			if (hamburger[i] == 'P') {
				for (int j = Math.max(i - k, 0); j <= Math.min(i + k, n - 1); j++) {
					if (hamburger[j] == 'H'){
						hamburger[j] = 'X';
						hamburger[i] = 'X';
						cnt++;
						break;
					}
				}
			}
		}
		System.out.println(cnt);
	}
}
