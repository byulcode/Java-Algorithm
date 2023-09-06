import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();

        int today_date = operateDate(today);
        Map<String, Integer> map = new HashMap<>();
        for (String t : terms) {
            String[] arr = t.split(" ");
            int days = Integer.parseInt(arr[1]) * 28;
            map.put(arr[0], days);
        }

        for (int i = 0; i < privacies.length; i++) {
            String[] arr = privacies[i].split(" ");
            int p_date = operateDate(arr[0]);
            int expired_date = p_date + map.get(arr[1]);
            if (expired_date <= today_date) {
                answer.add(i + 1);
            }
        }

        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    public static int operateDate(String date) {
        String[] arr = date.split("\\.");
        int y = Integer.parseInt(arr[0]);
        int m = Integer.parseInt(arr[1]);
        int d = Integer.parseInt(arr[2]);
        return y * 12 * 28 + m * 28 + d;
    }
}