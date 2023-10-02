import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[][] arr;
    static int[] result = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            String[] tmp = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(tmp[j]);
            }
        }
        func(0, 0, n);
        for (int i = 0; i < 3; i++) {
            System.out.println(result[i]);
        }
    }

    static void func(int row, int col, int n) {
        int check = arr[row][col];
        for (int i = row; i < row + n; i++) {
            for (int j = col; j < col + n; j++) {
                if (arr[i][j] != check) {
                    check = -2;
                    break;
                }
            }
        }

        if (check == -2) {
            n /= 3;
            func(row, col, n);
            func(row + n, col, n);
            func(row, col + n, n);
            func(row + n, col + n, n);
            func(row + 2 * n, col, n);
            func(row + 2 * n, col + n, n);
            func(row, col + 2 * n, n);
            func(row + n, col + 2 * n, n);
            func(row + 2 * n, col + 2 * n, n);
        } else if (check == -1) {
            result[0]++;
        } else if (check == 0) {
            result[1]++;
        } else {
            result[2]++;
        }
    }
}
