import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int[][] books = new int[book_time.length][2];
        for (int i = 0; i < book_time.length; i++) {
            books[i][0] = timeToMin(book_time[i][0]);
            books[i][1] = timeToMin(book_time[i][1]);
        }
        Arrays.sort(books, Comparator.comparingInt((int[] o) -> o[0]));     // 시작 시간 순 정렬

        List<Integer> endtimeList = new ArrayList<>();

        for (int[] book : books) {
            boolean check = false;
            Collections.sort(endtimeList);  // 종료 시간 순 정렬
            for (int i = 0; i < endtimeList.size(); i++) {
                int endtime = endtimeList.get(i) + 10;
                if (book[0] >= endtime) {
                    endtimeList.set(i, book[1]);
                    check = true;
                    break;
                }
            }
            if (!check) endtimeList.add(book[1]);
        }
        return endtimeList.size();
    }

    static int timeToMin(String time) {
        String[] arr = time.split(":");
        return Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
    }
}