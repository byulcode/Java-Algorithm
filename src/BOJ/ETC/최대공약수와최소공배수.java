import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int gcm = gcm(Math.max(a, b), Math.min(a, b));
        System.out.println(gcm);
        System.out.println(a * b / gcm);
    }

    public static int gcm(int a, int b) {
        int r = a % b;
        if (r == 0) {
            return b;
        }
        return gcm(b, r);
    }
}
