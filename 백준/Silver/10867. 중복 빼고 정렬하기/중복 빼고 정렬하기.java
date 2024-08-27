import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

class Main {
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		Set<Integer> tree = new TreeSet<>();
		String[] arr = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			tree.add(Integer.parseInt(arr[i]));
		}

		for (int num : tree) {
			System.out.print(num + " ");
		}
	}
}
