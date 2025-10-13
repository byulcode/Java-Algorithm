import java.util.Scanner;

public class Main {
	static int n, cnt;
	static final int MAX_NUM = 30;
	static boolean[] isUsed1 = new boolean[MAX_NUM];
	static boolean[] isUsed2 = new boolean[MAX_NUM];
	static boolean[] isUsed3 = new boolean[MAX_NUM];

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		func(0);
		System.out.println(cnt);
	}

	static void func(int x) {
		if (x == n) {
			cnt++;
			return;
		}

		for (int y = 0; y < n; y++) {
			if (!isUsed1[y] && !isUsed2[x + y] && !isUsed3[x - y + n - 1]) {
				isUsed1[y] = isUsed2[x + y] = isUsed3[x - y + n - 1] = true;
				func(x + 1);
				isUsed1[y] = isUsed2[x + y] = isUsed3[x - y + n - 1] = false;
			}
		}
	}
}
