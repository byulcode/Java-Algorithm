import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int n;
	static int[] w, h, orders;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		w = new int[n];
		h = new int[n];
		orders = new int[n];

		for (int i = 0; i < n; i++) {
			String[] arr = br.readLine().split(" ");
			w[i] = Integer.parseInt(arr[0]);
			h[i] = Integer.parseInt(arr[1]);
			orders[i] = 1;
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(w[i] < w[j] && h[i] < h[j]) orders[i]++;
			}
		}

		for (int o : orders) {
			System.out.print(o + " ");
		}
	}

}
