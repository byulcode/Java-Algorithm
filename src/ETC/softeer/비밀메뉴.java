import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String secretBtn = br.readLine().replaceAll(" ", "");
        String userBtn = br.readLine().replaceAll(" ", "");

        if (userBtn.contains(secretBtn)) {
            System.out.println("secret");
        } else {
            System.out.println("normal");
        }
    }
}