import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split(" ");

		int a = Integer.parseInt(arr[0]);
		int b = Integer.parseInt(arr[1]);
		int c = Integer.parseInt(arr[2]);
		int d = Integer.parseInt(arr[3]);
		int e = Integer.parseInt(arr[4]);
		int f = Integer.parseInt(arr[5]);

		int x = (c * e - b * f) / (a * e - b * d);
		int y = (c * d - f * a) / (d * b - a * e);

		System.out.println(x + " " + y);
	}
}

