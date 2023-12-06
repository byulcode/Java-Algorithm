import java.io.BufferedReader;
import java.io.InputStreamReader;

class Solution {

    static char[][] arr;
    static int curX, curY;
    static int[] dx = {0, 0, 1, -1}; // 서, 동, 남, 북
    static int[] dy = {-1, 1, 0, 0};

    public static int[] solution(String[] park, String[] routes) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = new char[park.length][park[0].length()];
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[0].length(); j++) {
                arr[i][j] = park[i].charAt(j);
                if (arr[i][j] == 'S') {
                    curX = i;
                    curY = j;
                }
            }
        }

        for (int i = 0; i < routes.length; i++) {
            boolean flag = true;
            String[] route = routes[i].split(" ");
            String direction = route[0];
            int cnt = Integer.parseInt(route[1]);
            int tmp_x = curX;
            int tmp_y = curY;

            for (int j = 0; j < cnt; j++) {
                switch (direction) {
                    case "W":
                        tmp_x += dx[0];
                        tmp_y += dy[0];
                        break;
                    case "E":
                        tmp_x += dx[1];
                        tmp_y += dy[1];
                        break;
                    case "S":
                        tmp_x += dx[2];
                        tmp_y += dy[2];
                        break;
                    case "N":
                        tmp_x += dx[3];
                        tmp_y += dy[3];
                        break;
                }
                if (tmp_x < 0 || tmp_x >= park.length || tmp_y < 0 || tmp_y >= park[0].length() || arr[tmp_x][tmp_y] == 'X') {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                curX = tmp_x;
                curY = tmp_y;
            }
        }
        return new int[]{curX, curY};
    }
}
