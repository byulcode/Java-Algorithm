import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	static int n, start, end, sum, maxHeightIdx, maxHeight;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[1001];
		start = Integer.MAX_VALUE;

		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			arr[l] = h;
			start = Math.min(start, l);
			end = Math.max(end, l);
			if (maxHeight < h) {
				maxHeight = h;
				maxHeightIdx = l;
			}
		}

		int temp = arr[start];
		Stack<Integer> stack = new Stack<>();
		stack.push(start);
		for (int i = start + 1; i <= maxHeightIdx; i++) {

			if (temp > arr[i]) {
				stack.push(i);
			} else {
				while (!stack.isEmpty()) {
					int x = stack.pop();
					arr[x] = temp;
				}
				temp = arr[i];
			}
		}

		temp = arr[end];
		stack.push(end);
		for (int i = end - 1; i >= maxHeightIdx; i--) {
			if (temp > arr[i]) {
				stack.push(i);
			} else {
				while (!stack.isEmpty()) {
					int x = stack.pop();
					arr[x] = temp;
				}
				temp = arr[i];
			}
		}

		for (int i = start; i <= end; i++) {
			sum += arr[i];
		}
		System.out.println(sum);
	}
}
