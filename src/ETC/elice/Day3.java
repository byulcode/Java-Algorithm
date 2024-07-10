import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String line = br.readLine();

		Stack<Integer> repeatStack = new Stack<>();
		Stack<Integer> lengthStack = new Stack<>();

		int i = 0;
		int curLength = 0;

		while (i < line.length()) {
			char cur = line.charAt(i);

			if (Character.isDigit(cur)) {
				int repeat = cur - '0';

				if (i + 1 < line.length() && line.charAt(i + 1) == '(') {
					repeatStack.push(repeat);
					lengthStack.push(curLength);
					curLength = 0;
					i++;
				} else {
					curLength++;
				}
			} else if (cur == ')') {
				curLength = lengthStack.pop() + repeatStack.pop() * curLength;
			}
			i++;
		}
		System.out.println(curLength);
	}
}
