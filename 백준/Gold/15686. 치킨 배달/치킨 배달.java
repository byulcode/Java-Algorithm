import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static int N, M, ans;
	static String[][] arr;
	static boolean[][] visited;
	static List<int[]> homeList, chickenList;
	static int MAX_NUM = 1500;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new String[N][N];
		visited = new boolean[N][N];
		ans = MAX_NUM;
		chickenList = new ArrayList<>();
		homeList = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			arr[i] = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				if (arr[i][j].equals("2")) {
					chickenList.add(new int[] {i, j});
				} else if (arr[i][j].equals("1")) {
					homeList.add(new int[] {i, j});
				}

			}
		}

		dfs(new ArrayList<>(), 0, 0);
		System.out.println(ans);
	}

	static void dfs(List<int[]> selected, int idx, int count) {
		if (count == M) {
			calculateDistance(selected);
			return;
		}

		if (idx >= chickenList.size())
			return;

		// 치킨 집을 고르는 경우
		selected.add(chickenList.get(idx));
		dfs(selected, idx + 1, count + 1);
		selected.remove(selected.size() - 1);

		// 이번 치킨 집을 고르지 않고 넘어가는 경우
		dfs(selected, idx + 1, count);
	}

	static void calculateDistance(List<int[]> chickenList) {
		int dist = 0;

		for (int[] hList : homeList) {
			int hr = hList[0];
			int hc = hList[1];
			int curDist = MAX_NUM;
			for (int[] cList : chickenList) {
				int cr = cList[0];
				int cc = cList[1];
				int calDist = Math.abs(hr - cr) + Math.abs(hc - cc);
				curDist = Math.min(calDist, curDist);
			}
			dist += curDist;
		}
		ans = Math.min(ans, dist);
	}
}
