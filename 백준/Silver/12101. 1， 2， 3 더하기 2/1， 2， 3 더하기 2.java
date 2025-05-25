import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Main {

	static int n, k;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split(" ");
		n = Integer.parseInt(arr[0]);
		k = Integer.parseInt(arr[1]);
		List<String>[] allList = new ArrayList[11];

		for (int i = 0; i < 11; i++) {
			allList[i] = new ArrayList<>();
		}

		allList[1].add("1");
		allList[2].add("1+1");
		allList[2].add("2");
		allList[3].add("1+1+1");
		allList[3].add("1+2");
		allList[3].add("2+1");
		allList[3].add("3");

		for (int i = 4; i <= n; i++) {
			for (String one : allList[i - 1]) {
				allList[i].add(one + "+" + 1);
			}

			for (String two : allList[i - 2]) {
				allList[i].add(two + "+" + 2);
			}

			for (String three : allList[i - 3]) {
				allList[i].add(three + "+" + 3);
			}
		}

		List<String> results = allList[n];
		Collections.sort(results);

		if (results.size() >= k-1) {
			System.out.println(results.get(k - 1));
		} else {
			System.out.println(-1);
		}
	}
}
