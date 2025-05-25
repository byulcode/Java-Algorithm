import java.util.*;

// https://www.codetree.ai/ko/frequent-problems/problems/mint-choco-milk/submissions?page=1&page_size=20
class Main {
	static int MINT_CHOCO_MILK = 111;
	static int CHOCO_MILK = 110;
	static int MINT_MILK = 101;
	static int MINT_CHOCO = 11;
	static int MILK = 100;
	static int CHOCO = 10;
	static int MINT = 1;
	static int N, T; // 배열크기, turn 수
	static Student[][] students; //학생들
	static boolean[][] visited;
	static int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 위, 아래, 왼쪽, 오른쪽
	static List<Student> leaders;
	static Map<Integer, List<Student>> groupMap;

	static int matchFood(char food) {
		if (food == 'T')
			return MINT;
		else if (food == 'C')
			return CHOCO;
		else
			return MILK;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		T = scan.nextInt();
		scan.nextLine();
		students = new Student[N][N];

		// input
		for (int i = 0; i < N; i++) {
			String line = scan.nextLine();
			for (int j = 0; j < N; j++) {
				char food = line.charAt(j);
				students[i][j] = new Student(matchFood(food), i, j);
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int believe = scan.nextInt();
				students[i][j].believe = believe;
			}
		}

		for (int t = 0; t < T; t++) {
			morning();
			lunch();
			dinner();

			Map<Integer, Integer> resultMap = new HashMap<>();
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int f = students[i][j].food;
					int believe = students[i][j].believe;
					resultMap.put(f, resultMap.getOrDefault(f, 0) + believe);
				}
			}

			System.out.printf("%d %d %d %d %d %d %d%n",
				resultMap.getOrDefault(MINT_CHOCO_MILK, 0),
				resultMap.getOrDefault(MINT_CHOCO, 0),
				resultMap.getOrDefault(MINT_MILK, 0),
				resultMap.getOrDefault(CHOCO_MILK, 0),
				resultMap.getOrDefault(MILK, 0),
				resultMap.getOrDefault(CHOCO, 0),
				resultMap.getOrDefault(MINT, 0));

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					students[i][j].isDefense = false;
					students[i][j].isLeader = false;
				}
			}
		}
	}

	static void morning() {
		// 아침. 모든 학생에 신앙심 +1
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				students[i][j].believe++;
			}
		}
	}

	static void lunch() {
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				students[i][j].isLeader = false;
			}
		}

		// 리더들
		leaders = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					leaders.add(bfs(i, j));
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!students[i][j].isLeader) {
					students[i][j].believe--;
				}
			}
		}
	}

	static void dinner() {
		makeGroup();
		for (int key : groupMap.keySet()) {
			List<Student> spreadList = groupMap.get(key);
			for (Student spreader : spreadList) {
				if (spreader.isDefense)
					continue;
				spread(spreader);
			}
		}
	}

	// 전파!
	static void spread(Student spreader) {
		int[] dir = direction[spreader.believe % 4];
		int x = spreader.believe - 1;
		int r = spreader.row;
		int c = spreader.col;
		spreader.believe = 1;

		// 한 칸씩 전파
		while (true) {
			r += dir[0];
			c += dir[1];

			if (r < 0 || r >= N || c < 0 || c >= N || x == 0)
				break;

			Student target = students[r][c];
			int y = target.believe;

			if (spreader.food == target.food) {
				continue;
			}

			if (x > y) {// 강한 전파
				target.food = spreader.food;
				target.believe++;
				target.isDefense = true;
				x -= (y + 1);
				if (x <= 0)
					break;
			} else {
				target.food = weakSpread(spreader, target);
				target.isDefense = true;
				target.believe += x;
				x = 0;
			}
		}
	}

	// 약한 전파
	static int weakSpread(Student a, Student b) {
		return a.food | b.food;
	}

	// 그룹 구하기 (단일: 1, 이중: 2, 삼중 : 3)
	static void makeGroup() {
		groupMap = new HashMap<>();
		for (int i = 1; i <= 3; i++) {
			groupMap.put(i, new ArrayList<>());
		}

		for (Student leader : leaders) {
			int groupNum = getGroupNum(leader.food);
			groupMap.get(groupNum).add(leader);
		}

		Comparator<Student> priorityComparator = (a, b) -> {
			if (a.believe != b.believe) {
				return Integer.compare(b.believe, a.believe);
			} else if (a.row != b.row) {
				return Integer.compare(a.row, b.row);
			} else {
				return Integer.compare(a.col, b.col);
			}
		};

		for (int i = 1; i <= 3; i++) {
			List<Student> slist = groupMap.get(i);
			if (slist.size() > 0) {
				slist.sort(priorityComparator);
			}
		}
	}

	static int getGroupNum(int food) {
		if (food == MINT_CHOCO_MILK)
			return 3;
		if (food == MINT || food == CHOCO || food == MILK)
			return 1;
		else
			return 2;
	}

	static Student bfs(int startR, int startC) {
		Student nowStudent = students[startR][startC];
		visited[startR][startC] = true;
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {startR, startC});

		int type = nowStudent.food;
		int cnt = 1;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int r = cur[0], c = cur[1];

			// 대표자 비교
			if (isPriority(nowStudent, students[r][c])) {
				nowStudent = students[r][c];
			}

			for (int[] dir : direction) {
				int nr = r + dir[0];
				int nc = c + dir[1];

				if (nr >= 0 && nr < N && nc >= 0 && nc < N &&
					!visited[nr][nc] && students[nr][nc].food == type) {
					visited[nr][nc] = true;
					queue.add(new int[] {nr, nc});
					cnt++;
				}
			}
		}

		nowStudent.believe += cnt - 1;
		nowStudent.isLeader = true;
		return nowStudent;
	}

	// a 보다 b가 우선순위가 높으면 true!
	static boolean isPriority(Student a, Student b) {
		if (a.believe < b.believe ||
			(a.believe == b.believe && a.row > b.row) ||
			(a.believe == b.believe && a.row == b.row) && a.col > b.col) {
			return true;
		}
		return false;
	}
}

class Student {
	int food;    // 신봉하는 음식
	int believe; // 신앙심
	boolean isLeader; // 대표자 여부
	boolean isDefense; // 방어
	int row;
	int col;

	public Student(int food, int row, int col) {
		this.food = food;
		this.isLeader = false;
		this.isDefense = false;
		this.row = row;
		this.col = col;
	}
}
