import java.util.Scanner;

public class Main {

	static int n, m;
	static int[] arr = new int[10];    // 수열을 저장할 배열
	static int[] isChecked = new int[10]; // 해당 숫자가 수열에 포함되었는지 체크 여부
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		m = scanner.nextInt();

		printNums(0);
		System.out.println(sb.toString());
	}

	// 현재 k개까지 수를 택한 상황에서 arr[k]를 정하는 함수
	static void printNums(int k) {
		if (k == m) {
			for (int i = 0; i < m; i++) {
				sb.append(arr[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		for (int i = 1; i <= n; i++) {
			arr[k] = i;
			printNums(k + 1);    // 중복을 허용함
		}
	}
}

