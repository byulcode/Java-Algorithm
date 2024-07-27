import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Main {

	static int n, result;
	static int[] aArr, bArr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		aArr = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();

		bArr = Arrays.stream(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();

		// b 배열의 순위
		Arrays.sort(aArr);
		Arrays.sort(bArr);
		Map<Integer, Integer> rankMap = new HashMap<>();
		for (int i = 0; i < bArr.length; i++) {
			rankMap.put(bArr.length - i, bArr[i]);
		}

		result = 0;
		for (int i = 1; i <= aArr.length; i++) {
			result += aArr[i - 1] * rankMap.get(i);
		}

		System.out.println(result);
	}
}
