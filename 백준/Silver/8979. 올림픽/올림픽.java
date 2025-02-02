import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Main {

	static int n, k;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		k = Integer.parseInt(input[1]);

		List<Score> scores = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int[] team = Arrays.stream(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
			scores.add(new Score(team[0], team[1], team[2], team[3]));
		}
		Collections.sort(scores);

		int rank = 1, cnt = 1;
		for (int i = 0; i < n; i++) {
			Score tmpScore = scores.get(i);
			if (i > 0 && tmpScore.compareTo(scores.get(i - 1)) != 0) {
				rank = cnt;
			}

			if (tmpScore.teamNum == k) {
				System.out.println(rank);
				return;
			}
			cnt++;
		}
	}
}

class Score implements Comparable<Score> {
	int teamNum, gold, silver, bronze;

	public Score(int teamNum, int gold, int silver, int bronze) {
		this.teamNum = teamNum;
		this.gold = gold;
		this.silver = silver;
		this.bronze = bronze;
	}

	@Override
	public int compareTo(Score o) {
		int goldDiff = Integer.compare(o.gold, this.gold);
		if (goldDiff != 0) {
			return goldDiff;
		}

		int silverDiff = Integer.compare(o.silver, this.silver);
		if (silverDiff != 0) {
			return silverDiff;
		}

		return Integer.compare(o.bronze, this.bronze);
	}
}
