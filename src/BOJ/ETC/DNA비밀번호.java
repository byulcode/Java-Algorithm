import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main1 {

    static char[] arr;
    static int[] checkArr = new int[4];
    static int[] curArr = new int[4];
    static int check = 0; // 4가 될 경우 result++

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int s = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        int result = 0;

        arr = br.readLine().toCharArray();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
            if (checkArr[i] == 0) {
                check++;
            }
        }

        // 처음 p까지의 세팅
        for (int i = 0; i < p; i++) {
            add(arr[i]);
        }

        if (check == 4) {
            result++;
        }

        for (int i = p; i < s; i++) {
            int j = i - p;
            add(arr[i]);
            minus(arr[j]);
            if (check == 4) {
                result++;
            }
        }
        System.out.println(result);
    }

    private static void minus(char dna) {
        switch (dna) {
            case 'A':
                if (curArr[0] == checkArr[0]) check--;
                curArr[0]--;
                break;
            case 'C':
                if (curArr[1] == checkArr[1]) check--;
                curArr[1]--;
                break;
            case 'G':
                if (curArr[2] == checkArr[2]) check--;
                curArr[2]--;
                break;
            case 'T':
                if (curArr[3] == checkArr[3]) check--;
                curArr[3]--;
                break;
        }
    }

    private static void add(char dna) {
        switch (dna) {
            case 'A':
                curArr[0]++;
                if (curArr[0] == checkArr[0]) check++;
                break;
            case 'C':
                curArr[1]++;
                if (curArr[1] == checkArr[1]) check++;
                break;
            case 'G':
                curArr[2]++;
                if (curArr[2] == checkArr[2]) check++;
                break;
            case 'T':
                curArr[3]++;
                if (curArr[3] == checkArr[3]) check++;
                break;
        }
    }
}
