import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int x = 0;
		int y = 0;
		char[][] map = new char[n][n];

		for (int i = 0; i < n; i++) {
			String s = br.readLine();
			int area = 0;
			for (int j = 0; j < n; j++) {
				map[i][j] = s.charAt(j);
				if (map[i][j] == 'X') {
					area = 0;
				} else {
					area++;
					if (area == 2) {
						x++;
					}
				}
			}
		}

		for (int j = 0; j < n; j++) {
			int area = 0;
			for (int i = 0; i < n; i++) {
				if (map[i][j] == '.') {
					area++;
					if (area == 2) {
						y++;
					}
				} else {
					area = 0;
				}
			}
		}

		System.out.println(x + " " + y);
	}
}

