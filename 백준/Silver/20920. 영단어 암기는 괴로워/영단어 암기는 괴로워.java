import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Main {
	static int n, m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split(" ");
		n = Integer.parseInt(arr[0]);
		m = Integer.parseInt(arr[1]);
		Map<String, Integer> words = new HashMap<>();

		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			if (line.length() < m)
				continue;
			words.put(line, words.getOrDefault(line, 0) + 1);
		}

		// PriorityQueue를 사용한 정렬
		PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
			(e1, e2) -> {
				// 내림차순
				int valueCompare = e2.getValue().compareTo(e1.getValue());
				if (valueCompare != 0)
					return valueCompare;

				// 키 길이 기준
				int lengthCompare = Integer.compare(e2.getKey().length(), e1.getKey().length());
				if (lengthCompare != 0)
					return lengthCompare;

				// 사전순
				return e1.getKey().compareTo(e2.getKey());
			}
		);

		pq.addAll(words.entrySet());

		StringBuilder sb = new StringBuilder();
		while (!pq.isEmpty()) {
			Map.Entry<String, Integer> entry = pq.poll();
			sb.append(entry.getKey()).append("\n");
		}
		System.out.print(sb.toString());
	}
}
