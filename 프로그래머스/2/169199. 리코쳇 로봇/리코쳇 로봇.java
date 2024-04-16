import java.util.LinkedList;
import java.util.Queue;

class Solution {
	static int[] dx = {1, -1, 0, 0};
	static int[] dy = {0, 0, 1, -1};

	public int solution(String[] board) {
		int answer = 0;
		int x = 0;
		int y = 0;
		char map[][] = new char[board.length][board[0].length()];
		for (int i = 0; i < board.length; i++) {
			map[i] = board[i].toCharArray();
			for (int j = 0; j < board[0].length(); j++) {
				if (map[i][j] == 'R') {
					x = i;
					y = j;
				}
			}
		}
		answer = bfs(x, y, map);
		return answer;
	}

	int bfs(int x, int y, char[][] board) {
		int[][] visited = new int[board.length][board[0].length];
		visited[x][y] = 1;
		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] {x, y});

		while (!queue.isEmpty()) {
			int[] p = queue.poll();

			if (board[p[0]][p[1]] == 'G') {
				return visited[p[0]][p[1]] - 1;
			}
			
			for (int i = 0; i < 4; i++) {
				int nx = p[0] + dx[i];
				int ny = p[1] + dy[i];

				while (true){
					if (nx < 0 || nx >= board.length || ny < 0 || ny >= board[0].length || board[nx][ny] == 'D') {
						nx -= dx[i];
						ny -= dy[i];
						break;
					}else{// 벽이 아니면 계속 가기
						nx += dx[i];
						ny += dy[i];
					}
				}
				if (visited[nx][ny] == 0) {
					queue.add(new int[] {nx, ny});
					visited[nx][ny] = visited[p[0]][p[1]] + 1;
				}
			}
		}
		return -1;
	}
}
