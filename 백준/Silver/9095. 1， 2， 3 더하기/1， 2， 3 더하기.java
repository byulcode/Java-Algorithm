import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	static int t;
	static int[] arr = new int[11];
	static List<Integer> result = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine());

		for (int i = 0; i < 11; i++) {
			count(i, i);
		}

		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			result.add(arr[n]);
		}

		for (int r : result) {
			System.out.println(r);
		}
	}

	public static void count(int k, int now) {
		if (k == 0) {
			arr[now]++;
			return;
		}

		if (k - 1 >= 0) {
			count(k - 1, now);
		}

		if (k - 2 >= 0) {
			count(k - 2, now);
		}

		if (k - 3 >= 0) {
			count(k - 3, now);
		}
	}
}

