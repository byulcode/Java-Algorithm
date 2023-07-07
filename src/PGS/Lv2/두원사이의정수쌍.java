class Solution {
    public static long solution(int r1, int r2) {
        long answer = 0;

        for (int i = 1; i <= r2; i++) {
            int max = (int) Math.floor(Math.sqrt((long) r2 * r2 - (long) i * i));
            int min = (int) Math.ceil(Math.sqrt((long) r1 * r1 - (long) i * i));

            if (i >= r1) {
                min = 0;
            }
            answer += (max - min + 1);
        }
        answer *= 4;
        return answer;
    }
}