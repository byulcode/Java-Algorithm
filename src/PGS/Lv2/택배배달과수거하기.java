class Solution {
	public long solution(int cap, int n, int[] deliveries, int[] pickups) {
		int d = 0;
		int p = 0;
		int ans = 0;

		for (int i = n - 1; i >= 0; i--) {
			d -= deliveries[i];
			p -= pickups[i];
			int cnt = 0;

			while (d < 0 || p < 0) {
				d += cap;
				p += cap;
				cnt++;
			}
			ans += (i + 1) * 2 * cnt;
		}
		return ans;
	}
}
