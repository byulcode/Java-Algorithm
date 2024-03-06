import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int n, k, twoN, step;
	static int upIdx, downIdx;
	static int[] belt;
	static boolean[] robot;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		step = 0;
		twoN = 2 * n;
		upIdx = 0;
		downIdx = n - 1;
		belt = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();
		robot = new boolean[n];

		while (!isEndCondition()) {
			step++;

			// 1단계
			shiftBelt();
			shiftRobot();

			// 2단계
			for (int i = n - 1; i > 0; i--) {
				if (robot[i - 1] && !robot[i] && belt[i] > 0) {
					robot[i-1] = false;
					robot[i] = true;
					belt[i]--;
				}
			}

			// 3단계
			if (belt[upIdx] > 0) {
				robot[upIdx] = true;
				belt[upIdx]--;
			}
		}
		System.out.println(step);
	}

	static void shiftBelt() {
		int temp = belt[twoN - 1];
		for (int i = twoN - 1; i > 0; i--) {
			belt[i] = belt[i - 1];
		}
		belt[0] = temp;
	}

	static void shiftRobot() {
		for (int i = n - 1; i > 0; i--) {
			robot[i] = robot[i - 1];
		}
		robot[0] = false;
		robot[n-1] = false;
	}

	static boolean isEndCondition() { // 4단계
		int count = (int)Arrays.stream(belt)
			.filter(e -> e == 0)
			.count();
		if(count >= k) return true;
		return false;
	}
}
