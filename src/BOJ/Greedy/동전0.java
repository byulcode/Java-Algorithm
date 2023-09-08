import java.util.*;
import java.io.*;
// 백준 동전 0. Greedy로 풀이
public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        long n = Integer.parseInt(st.nextToken());
        long k = Integer.parseInt(st.nextToken());
        int cnt = 0;

        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(br.readLine()));
        }

        int idx = arr.size() - 1;
        while (k != 0) {
            int num = arr.get(idx);
            if (k < num) {
                idx--;
                continue;
            }
            k -= num;
            cnt++;
        }
        System.out.println(cnt);
    }
}