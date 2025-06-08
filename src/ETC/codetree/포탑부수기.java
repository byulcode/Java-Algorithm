import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
// 코드트리 포탑부수기
// https://www.codetree.ai/ko/frequent-problems/samsung-sw/problems/destroy-the-turret/description
public class Main {
	static int n, m, k;
	static int[][] map;
	static int[][] direction = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 }, { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 } };
	static List<Top> tops = new ArrayList();
	static List<Node> damagedPath;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] > 0) {
					tops.add(new Top(i, j, map[i][j], 0));
				}
			}
		}

		for (int i = 1; i <= k; i++) {
			// 공격자 선정
			Top attacker = findAttacker(i);
			// 공격
			attack(attacker);
			// 포탑 정비
			clean();

			if (tops.size() <= 1) break;
		}

		Comparator<Top> priority = (a, b) -> {
			return b.score - a.score;
		};
		Collections.sort(tops, priority);

		System.out.println(tops.get(0).score);
	}

	static void clean() {
		for (Top top : tops) {
			if (!top.isWorked) {
				top.score++;
				map[top.r][top.c] = top.score;
			}
			top.isWorked = false;
		}
	}

	static void attack(Top attacker) {
		Top target = findTarget(attacker);
		if (target == null) return;

		boolean flag = lazer(attacker, target);

		if (!flag) {
			bomb(attacker, target);
		}

		// 데미지 받을 곳들 + target 점수 까기. 영향 여부 체크.
		target.isWorked = true;
		target.score -= attacker.score;
		map[target.r][target.c] = target.score;
		if (target.score <= 0 ) tops.remove(target);
		int damage = attacker.score / 2;

		for (Node path : damagedPath) {
			Top top = findTop(path.x, path.y);
			if (top == null) continue;
			top.score -= damage;
			top.isWorked = true;
			map[top.r][top.c] = top.score;
			if (top.score <= 0) tops.remove(top);
		}
	}

	static Top findTop(int r, int c) {
		for (Top top : tops) {
			if (top.r == r && top.c == c)
				return top;
		}
		return null;
	}

	static void bomb(Top attacker, Top target) {
		damagedPath = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			int nx = (target.r + direction[i][0] + n) % n;
			int ny = (target.c + direction[i][1] + m) % m;
			if (map[nx][ny] <= 0 || (attacker.r == nx && attacker.c == ny)) continue;
			damagedPath.add(new Node(nx, ny, null));
		}
	}

	static boolean lazer(Top attacker, Top target) {
		int endX = target.r;
		int endY = target.c;

		boolean[][] visited = new boolean[n][m];
		Queue<Node> queue = new LinkedList<>();

		Node startNode = new Node(attacker.r, attacker.c, null);
		visited[attacker.r][attacker.c] = true;
		queue.add(startNode);

		while (!queue.isEmpty()) {
			Node nowNode = queue.poll();

			if (nowNode.x == endX && nowNode.y == endY) {
				// 경로 구하기
				findLazerRoot(startNode, nowNode);
				return true;
			}

			for (int i = 0; i < 4; i++) {
				int nx = (nowNode.x + direction[i][0] + n) % n;
				int ny = (nowNode.y + direction[i][1] + m) % m;

				if (!visited[nx][ny] && map[nx][ny] > 0) {
					queue.add(new Node(nx, ny, nowNode));
					visited[nx][ny] = true;
				}
			}
		}
		return false;
	}

	static void findLazerRoot(Node startNode, Node endNode) {
		damagedPath = new ArrayList<>();
		for (Node cur = endNode.parent; cur != startNode; cur = cur.parent) {
			if (cur == null) continue;
			damagedPath.add(cur);
		}
	}

	static Top findTarget(Top attacker) {
		Comparator<Top> priority = (a, b) -> {
			if (a.score == b.score) {
				if (a.turn == b.turn) {
					if (a.r + a.c == b.r + b.c) {
						return a.c - b.c;
					}
					return (a.r + a.c) - (b.r + b.c);
				}
				return a.turn - b.turn;
			}
			return b.score - a.score;
		};
		Collections.sort(tops, priority);
		return tops.stream()
			.filter(t -> t != attacker)  // <-- 공격자 제외
			.sorted(priority)
			.findFirst()
			.orElse(null);
	}

	static Top findAttacker(int turn) {
		Comparator<Top> priority = (a, b) -> {
			if (a.score == b.score) {
				if (a.turn == b.turn) {
					if (a.r + a.c == b.r + b.c) {
						return b.c - a.c;
					}
					return (b.r + b.c) - (a.r + a.c);
				} else {
					return b.turn - a.turn;
				}
			}
			return a.score - b.score;
		};
		Collections.sort(tops, priority);
		Top attacker = tops.get(0);
		map[attacker.r][attacker.c] = attacker.score += n + m;
		attacker.score = map[attacker.r][attacker.c];
		attacker.turn = turn;
		attacker.isWorked = true;
		return attacker;
	}
}

class Node {
	int x, y;
	Node parent;

	public Node(int x, int y, Node parent) {
		this.x = x;
		this.y = y;
		this.parent = parent;
	}
}

class Top {
	int r, c, score, turn;
	boolean isWorked; // 참여했는지 여부. true면 참여함

	public Top(int r, int c, int score, int turn) {
		this.r = r;
		this.c = c;
		this.score = score;
		this.turn = turn;
	}
}
