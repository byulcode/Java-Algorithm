import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Solution {
	public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
		List<int[]> answer = new ArrayList<>();
		int idx = returnNum(ext);
		int sortNum = returnNum(sort_by);

		for (int i = 0; i < data.length; i++) {
			if (data[i][idx] < val_ext) {
				answer.add(data[i]);
			}
		}

		answer.sort(Comparator.comparingInt(a -> a[sortNum]));
		return answer.stream().toArray(int[][]::new);
	}

	int returnNum(String string) {
		switch (string) {
			case "code":
				return 0;
			case "date":
				return 1;
			case "maximum":
				return 2;
			case "remain":
				return 3;
		}
		return 5;
	}
}
