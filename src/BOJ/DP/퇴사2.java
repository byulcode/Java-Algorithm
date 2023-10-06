import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] t = new int[n];
        int[] p = new int[n];
        int[] d = new int[n + 1];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        int max_value = 0;
        for (int i = n-1; i >= 0; i--) {
            if (i + t[i] <= n) {
                d[i] = Math.max(max_value, p[i] + d[i + t[i]]);
            } else {
                d[i] = max_value;
            }
            max_value = d[i];
        }
        System.out.println(max_value);
    }
}
