import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class Main {

	public static void main(String[] args)  {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int newNum = scanner.nextInt();
		int p = scanner.nextInt();

		Integer[] arr = new Integer[n];
		for(int i=0; i<n; i++){
			arr[i] = scanner.nextInt();
		}
		Arrays.sort(arr, Collections.reverseOrder());

		if (n == p && newNum <= arr[arr.length - 1]) {
			System.out.println(-1);
		} else {
			int rank = 1;
			for (int num : arr) {
				if (newNum < num)
					rank++;
				else
					break;
			}
			System.out.println(rank);
		}
	}
}
