import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] arr = scanner.nextLine().split(" ");

		String a = arr[0];
		String b = arr[1];
		int max = 0;

		for (int i = 0; i <= b.length() - a.length(); i++) {
			int cnt = 0;
			for (int j = i; j < i + a.length(); j++) {
				if (a.charAt(j - i) == b.charAt(j))
					cnt++;
			}
			max = Math.max(max, cnt);
		}

		int result = a.length() - max;
		System.out.println(result);
	}
}

