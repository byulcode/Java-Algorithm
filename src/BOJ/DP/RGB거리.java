import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] color = new int[n][3];
        int[][] d = new int[n][3];

        for (int i = 0; i < n; i++) {
            String[] tmp = br.readLine().split(" ");
            for (int j = 0; j < 3; j++) {
                color[i][j] = Integer.parseInt(tmp[j]);
            }
        }
        d[0][0] = color[0][0];
        d[0][1] = color[0][1];
        d[0][2] = color[0][2];

        for (int i = 1; i < n; i++) {
            d[i][0] = Math.min(d[i - 1][1], d[i - 1][2]) + color[i][0];
            d[i][1] = Math.min(d[i - 1][0], d[i - 1][2]) + color[i][1];
            d[i][2] = Math.min(d[i - 1][0], d[i - 1][1]) + color[i][2];
        }
        int result = Math.min(Math.min(d[n - 1][0], d[n - 1][1]), d[n - 1][2]);
        System.out.println(result);
    }
}
