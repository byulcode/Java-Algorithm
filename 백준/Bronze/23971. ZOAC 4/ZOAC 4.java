import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split(" ");
		int h = Integer.parseInt(arr[0]);
		int w = Integer.parseInt(arr[1]);
		int n = Integer.parseInt(arr[2]);
		int m = Integer.parseInt(arr[3]);

		int hCnt = (h + n) / (n + 1);
		int wCnt = (w + m) / (m + 1);

		System.out.println(hCnt * wCnt);
	}
}

