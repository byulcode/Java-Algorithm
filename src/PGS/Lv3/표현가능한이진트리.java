class Solution {
	public int[] solution(long[] numbers) {
		int[] answer = new int[numbers.length];
		for (int i = 0; i < numbers.length; i++) {
			String binary = convertToBinary(numbers[i]);
			boolean flag = check(binary, 0, binary.length()-1);

			if (flag) {
				answer[i] = 1;
			} else {
				answer[i] = 0;
			}
		}
		return answer;
	}

	// 포화이진트리 생성 메서드
	public String convertToBinary(long num) {
		String binary = Long.toBinaryString(num);
		int h = 0;
		int nodes = 1;

		while (nodes < binary.length()) {
			h++;
			nodes += (int)Math.pow(2, h);
		}
		return "0".repeat(nodes - binary.length()) + binary;
	}

	public boolean check(String binary, int start, int end) {
		if (start == end) return true; // 리프노드에서 호출한 경우
		int root = (start + end) / 2;

		if (binary.charAt(root) == '0') {
			for (int i = start; i < root; i++) {
				if (binary.charAt(i) == '1')
					return false;
			}
			for (int i = root + 1; i <= end; i++) {
				if (binary.charAt(i) == '1')
					return false;
			}
		}
		return check(binary, start, root - 1) && check(binary, root + 1, end);
 	}
}
