import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int sqrt = (int) Math.sqrt(n);
        List<Integer> arr = new ArrayList<>();

        for (int i = 1; i <= sqrt; i++) {
            if (n % i == 0) {
                arr.add(i);
                if (n / i != i) {// 약수 중 가장 큰 수 저장
                    arr.add(n / i);
                }
            }
        }
        Collections.sort(arr);

        if (arr.size() < k) {
            System.out.println(0);
        } else {
            System.out.println(arr.get(k - 1));
        }
    }
}
