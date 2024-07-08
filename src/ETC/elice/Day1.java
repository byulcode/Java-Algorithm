import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static char[] arr;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		arr = scanner.nextLine().toCharArray();

		int i = arr.length - 2;
		while (arr[i] >= arr[i + 1]) {
			i--;
		}

		int j = arr.length - 1;
		while (arr[j] <= arr[i]) {
			j--;
		}

		swap(i, j);

		Arrays.sort(arr, i+1, arr.length);

		for (char c : arr) {
			System.out.print(c - '0');
		}
	}

	static void swap(int i, int j) {
		char tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
