import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 4 : 2, 4 : 3, 3 : 2
class Solution {
	public long solution(int[] weights) {
		long answer = 0;
		Map<Integer, Long> map = new HashMap<>();
		for (int weight : weights) {
			map.put(weight, map.getOrDefault(weight, 0L) + 1);
		}

		for (long value : map.values()) {
			if (value >= 2)
				answer += value * (value - 1) / 2;
		}

		for (int weight1 : map.keySet()) {
			for (int weight2 : map.keySet()) {
				if (weight2 != weight1) {
					if (weight2 * 2 == weight1 * 3) {
						answer += map.get(weight1) * map.get(weight2);
					} else if (weight2 * 2 == weight1 * 4) {
						answer += map.get(weight1) * map.get(weight2);
					} else if (weight2 * 3 == weight1 * 4) {
						answer += map.get(weight1) * map.get(weight2);
					}
				}
			}
		}
		return answer;
	}
}
