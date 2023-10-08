import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static boolean[] num = new boolean[1000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        for (int i = 123; i < 1000; i++) {
            String checkNum = Integer.toString(i);
            if (checkNum.charAt(0) == '0' || checkNum.charAt(1) == '0'
                || checkNum.charAt(2) == '0') {
                continue;
            }
            if (checkNum.charAt(0) == checkNum.charAt(1) || checkNum.charAt(0) == checkNum.charAt(2)
                || checkNum.charAt(1) == checkNum.charAt(2)) {
                continue;
            }
            num[i] = true;
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String checkNum = st.nextToken();
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            for (int j = 123; j < 1000; j++) {
                if (num[j]) {// 비교 가능한 숫자인 경우
                    int sNum = 0;
                    int bNum = 0;
                    for (int k = 0; k < 3; k++) {
                        char check = checkNum.charAt(k);
                        for (int m = 0; m < 3; m++) {
                            char tmpNum = Integer.toString(j).charAt(m);

                            if (check == tmpNum && k == m) {
                                sNum++;
                            } else if (check == tmpNum && k != m) {
                                bNum++;
                            }
                        }
                    }
                    if (sNum == s && bNum == b) num[j] = true;
                    else num[j] = false;
                }
            }
        }
        int cnt = 0;
        for (int i = 0; i < 1000; i++) {
            if (num[i]) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
