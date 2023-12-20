import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int min_num = Integer.MAX_VALUE;
    static int max_num = Integer.MIN_VALUE;
    static int[] nums;
    static int[] operators;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        nums = new int[n];
        operators = new int[4];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(st.nextToken());
        }

        back(nums[0], 1);

        System.out.println(max_num);
        System.out.println(min_num);
    }

    public static void back(int num, int idx) {
        if (idx == n) {
            max_num = Math.max(num, max_num);
            min_num = Math.min(num, min_num);
        }

        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                operators[i]--;
                switch (i) {
                    case 0:
                        back(num + nums[idx], idx + 1);
                        break;
                    case 1:
                        back(num - nums[idx], idx + 1);
                        break;
                    case 2:
                        back(num * nums[idx], idx + 1);
                        break;
                    case 3:
                        back(num / nums[idx], idx + 1);
                        break;
                }
                operators[i]++;
            }
        }
    }
}
