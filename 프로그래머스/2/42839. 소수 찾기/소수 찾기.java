import java.util.*;

class Solution {
    HashSet<Integer> numSet = new HashSet<>();
    
    public int solution(String numbers) {
        int answer = 0;
        
        recursive("", numbers);
        Iterator<Integer> iter = numSet.iterator();
        
        while(iter.hasNext()) {
            int num = iter.next();
            System.out.println(num);
            if (isPrime(num)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    void recursive(String num, String others) {
        if (num != "") {
            numSet.add(Integer.parseInt(num));
        }
        
        for (int i = 0; i < others.length(); i++) {
            recursive(num + others.charAt(i), others.substring(0,i) + others.substring(i+1));
        }
    }
    
    boolean isPrime(int num) {
        if (num <= 1) 
            return false;
        int max = (int)Math.sqrt(num);
        for (int i = 2; i <= max; i++) {
            if (num % i == 0) 
                return false;
        }
        return true;
    }
}