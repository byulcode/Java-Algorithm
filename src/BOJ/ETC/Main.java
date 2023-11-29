import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int groupCnt = 0;

        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
            if (check(arr[i])) groupCnt++;
        }
        System.out.println(groupCnt);
    }

    public static boolean check(String str) {
        boolean[] check = new boolean[26];
        int prev = 0;

        for (int i = 0; i < str.length(); i++) {
            int now = str.charAt(i);

            if (prev != now) {
                if (check[now - 'a'] == false) {
                    check[now - 'a'] = true;
                    prev = now;
                }else return false;
            }
        }
        return true;
    }
}
