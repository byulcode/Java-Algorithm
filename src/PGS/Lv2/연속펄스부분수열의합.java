class Solution {

    public long solution(int[] sequence) {
        long sum1 = cntSum(true, sequence);
        long sum2 = cntSum(false, sequence);

        return Math.max(sum1, sum2);
    }

    static long cntSum(boolean p, int[] seq) {
        long pSum = 0;
        long max = 0;

        boolean isPlus = p;
        for (int j : seq) {
            pSum += isPlus ? j : -j;
            pSum = Math.max(pSum, 0);
            max = Math.max(max, pSum);

            isPlus = !isPlus;
        }

        return max;
    }
}