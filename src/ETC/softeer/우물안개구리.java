import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static int[] weights;
	static List<List<Integer>> people = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		weights = new int[n + 1];

		st = new StringTokenizer(br.readLine(), " ");
		people.add(new ArrayList<>());
		for (int i = 1; i <= n; i++) {
			weights[i] = Integer.parseInt(st.nextToken());
			people.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			people.get(a).add(b);
			people.get(b).add(a);
		}

		int result = 0;
		for (int i = 1; i <= n; i++) {
			boolean flag = true;
			for (int j = 0; j < people.get(i).size(); j++) {
				int p = people.get(i).get(j);
				if (weights[i] <= weights[p]) {
					flag = false;
					break;
				}
			}
			if (flag)
				result++;
		}
		System.out.println(result);
	}
}
