class Solution {
    public int[] solution(int[] sequence, int k) {
        int partSum = 0;
        int left = 0;
        int right = 0;
        int n = sequence.length;
        int ansl = 0;
        int ansr = 0;

        for(right=0;right<sequence.length;right++){
            partSum += sequence[right];

            while(partSum > k){
                partSum -= sequence[left];
                left++;
            }

            if(partSum == k){
                if(right - left < n){
                    ansl = left;
                    ansr = right;
                    n = right-left;
                }else if(right - left == n){
                    ansl = Math.min(ansl, left);
                    ansr = Math.min(ansr, right);
                }
            }
        }
        return new int[]{ansl, ansr};
    }
}