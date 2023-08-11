import java.util.*;

class Solution {

    static String[][] travel;
    static boolean[][] visited;
    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, 1, -1};

    public int[] solution(String[] maps) {
        travel = new String[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < maps.length; i++) {
            travel[i] = maps[i].split("");
        }

        for (int i = 0; i < travel.length; i++) {
            for (int j = 0; j < travel[0].length; j++) {
                if (!travel[i][j].equals("X") && !visited[i][j]) {
                    result.add(bfs(i, j));
                }
            }
        }
        Collections.sort(result);
        if (result.size() == 0)
            result.add(-1);
        return result.stream()
                .mapToInt(Integer::intValue)
                .toArray();

    }

    static int bfs(int x, int y) {
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{x, y});
        visited[x][y] = true;
        int total = Integer.parseInt(travel[x][y]);

        while (!que.isEmpty()) {
            int[] q = que.poll();
            int a = q[0];
            int b = q[1];

            for (int i = 0; i < 4; i++) {
                int nx = a + dx[i];
                int ny = b + dy[i];
                if (nx < 0 || nx >= travel.length || ny < 0 || ny >= travel[0].length || travel[nx][ny].equals("X") || visited[nx][ny])
                    continue;
                visited[nx][ny] = true;
                que.offer(new int[]{nx, ny});
                total += Integer.parseInt(travel[nx][ny]);
            }
        }
        return total;
    }
}