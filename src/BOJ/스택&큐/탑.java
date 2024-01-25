import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		Stack<Top> stack = new Stack<>();

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			int h = Integer.parseInt(st.nextToken());
			while (!stack.isEmpty()) {
				Top top = stack.peek();
				if (top.height >= h) {
					System.out.print(top.num + " ");
					break;
				}
				stack.pop();
			}
			if (stack.isEmpty()) {
				System.out.print("0 ");
			}
			stack.push(new Top(i + 1, h));
		}
	}
}

class Top {
	int num;
	int height;

	public Top(int num, int height) {
		this.num = num;
		this.height = height;
	}
}
