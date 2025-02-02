import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

	static int b, n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		b = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		String[] low = new String[b];
		String[] high = new String[b];

		for (int i = 0; i < b; i++) {//낮음
			low[i] = br.readLine();
		}
		for (int i = 0; i < b; i++) {//높음
			high[i] = br.readLine();
		}

		n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			String data = br.readLine();
			int lowCnt = 0, highCnt = 0;

			for (int j = 0; j < b; j++) {
				String lowTarget = low[j];
				String highTarget = high[j];

				int index = 0;
				while (data.indexOf(lowTarget, index) != -1) {
					lowCnt++;
					index = data.indexOf(lowTarget, index) + 1;
				}

				index = 0;
				while (data.indexOf(highTarget, index) != -1) {
					highCnt++;
					index = data.indexOf(highTarget, index) + 1;
				}
			}

			int c = highCnt - lowCnt;
			if (c < 0) {
				sb.append("HIGH ").append(Math.abs(c)).append("\n");
			} else if (c > 0) {
				sb.append("LOW ").append(Math.abs(c)).append("\n");
			} else {
				sb.append("GOOD\n");
			}
		}
		System.out.println(sb);
	}
}
