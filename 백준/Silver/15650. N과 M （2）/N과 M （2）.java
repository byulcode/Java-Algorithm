import java.util.Scanner;

public class Main {

	static int n, m;
	static int[] arr = new int[10];	// 수열을 저장할 배열
	static boolean[] isChecked = new boolean[10]; // 해당 숫자가 수열에 포함되었는지 체크 여부

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		m = scanner.nextInt();

		printNums(0);
	}

	// 현재 k개까지 수를 택한 상황에서 arr[k]를 정하는 함수
	static void printNums(int k) {
		if (k == m) {
			for (int i = 0; i < m; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = 1; i <= n; i++) {
			if (!isChecked[i]) { // 만약 arr배열에 아직 들어가있지 않다면
				if (k > 0 && arr[k-1] >= i) {
					continue;
				}
				arr[k] = i;
				isChecked[i] = true;
				printNums(k + 1);
				isChecked[i] = false;
			}
		}
	}
}

