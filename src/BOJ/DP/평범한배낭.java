import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int n = Integer.parseInt(arr[0]);
        int k = Integer.parseInt(arr[1]);
        int[][] wv = new int[n][2];
        int[][] d = new int[n][k+1];

        for (int i = 0; i < n; i++) {
            arr = br.readLine().split(" ");
            for (int j = 0; j < 2; j++) {
                wv[i][j] = Integer.parseInt(arr[j]);
            }
        }

        for (int i = 0; i <= k; i++) {
            if (i >= wv[0][0]) {
                d[0][i] = wv[0][1];
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < k + 1; j++) {
                int weight = wv[i][0];
                int value = wv[i][1];

                if (j < weight) {
                    d[i][j] = d[i - 1][j];
                } else {
                    d[i][j] = Math.max(value + d[i - 1][j - weight], d[i - 1][j]);
                }
            }
        }
        System.out.println(d[n-1][k]);
    }
}
