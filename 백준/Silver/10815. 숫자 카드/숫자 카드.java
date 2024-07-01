import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static int m, n;
	static int[] result;
	static String[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = br.readLine().split(" ");
		Set<String> set = new HashSet<>();

		for (String s : arr) {
			set.add(s);
		}
		m = Integer.parseInt(br.readLine());
		result = new int[m];

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < m; i++) {
			if (set.contains(st.nextToken())) {
				result[i] = 1;
			} else {
				result[i] = 0;
			}
		}

		for (int r : result) {
			System.out.print(r + " ");
		}
	}
}

