import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Map<Integer, Integer> map = new HashMap<>();

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}
		Arrays.sort(arr);

		// 산술평균
		int sum = Arrays.stream(arr).sum();
		System.out.println(Math.round((double)sum / n));

		// 중앙값
		System.out.println(arr[n / 2]);

		// 최빈값
		int maxCount = map.values().stream().mapToInt(v -> v).max().orElse(0);
		PriorityQueue<Integer> queue = new PriorityQueue<>();

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() == maxCount) {
				queue.add(entry.getKey());
			}
		}
		if (queue.size() >= 2)
			queue.poll();
		System.out.println(queue.poll());

		// 범위
		System.out.println(arr[n - 1] - arr[0]);
	}
}
