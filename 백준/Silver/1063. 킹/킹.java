import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static Point king;
	static Point rock;
	static int n;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");

		king = inputPoint(input[0]);
		rock = inputPoint(input[1]);
		n = Integer.parseInt(input[2]);

		for (int i = 0; i < n; i++) {
			String direction = br.readLine().trim();
			move(direction);
		}

		System.out.println(king.originX() + king.originY());
		System.out.println(rock.originX() + rock.originY());
	}

	static Point inputPoint(String start) {
		char[] inputChar = start.toCharArray();
		int x = inputChar[0] - 'A';
		int y = 8 - Integer.parseInt(String.valueOf(inputChar[1]));
		return new Point(x, y);
	}

	static void move(String direction) {
		int dx = 0;
		int dy = 0;

		switch (direction) {
			case "R":
				dx += 1;
				break;
			case "L":
				dx -= 1;
				break;
			case "B":
				dy += 1;
				break;
			case "T":
				dy -= 1;
				break;
			case "RT":
				dx += 1;
				dy -= 1;
				break;
			case "LT":
				dx -= 1;
				dy -= 1;
				break;
			case "RB":
				dx += 1;
				dy += 1;
				break;
			case "LB":
				dx -= 1;
				dy += 1;
				break;
		}

		int nx = king.x + dx;
		int ny = king.y + dy;

		if (!isValid(nx, ny))
			return;

		if (nx == rock.x && ny == rock.y) {
			if (!isValid(rock.x + dx, rock.y + dy)) {
				return;
			}
			rock.x += dx;
			rock.y += dy;
		}
		king.x = nx;
		king.y = ny;
	}

	public static boolean isValid(int x, int y) {
		return 0 <= x && x < 8 && y >= 0 && y < 8;
	}
}

class Point {
	int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public char originX() {
		return (char)(x + 'A');
	}

	public String originY() {
		return String.valueOf(8 - y);
	}
}
