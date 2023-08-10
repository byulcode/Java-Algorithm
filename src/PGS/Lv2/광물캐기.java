import java.util.*;

class Solution {

    static List<Mineral> mineralList;
    static int[][] score;

    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        mineralList = new ArrayList<>();
        score = new int[][]{{1, 1, 1}, {5, 1, 1}, {25, 5, 1}};

        int totalPick = Arrays.stream(picks).sum();

        for (int i = 0; i < minerals.length; i += 5) {
            if (totalPick == 0) break;

            int dia = 0, iron = 0, stone = 0;
            for (int j = i; j < i + 5; j++) {
                if(j == minerals.length) break;     //이거 안해줘서 오류남
                String mineral = minerals[j];
                int val = mineral.equals("diamond") ? 0 :
                        mineral.equals("iron") ? 1 : 2;
                dia += score[0][val];
                iron += score[1][val];
                stone += score[2][val];
            }
            mineralList.add(new Mineral(dia, iron, stone));
            totalPick--;
        }

        mineralList.sort(((o1, o2) -> o2.stone - o1.stone));
        for (Mineral m : mineralList) {

            if (picks[0] > 0) {
                answer += m.dia;
                picks[0]--;
                continue;
            }
            if (picks[1] > 0) {
                answer += m.iron;
                picks[1]--;
                continue;
            }
            if (picks[2] > 0) {
                answer += m.stone;
                picks[2]--;
                continue;
            }
        }
        return answer;
    }

    class Mineral {
        int dia;
        int iron;
        int stone;

        public Mineral(int dia, int iron, int stone) {
            this.dia = dia;
            this.iron = iron;
            this.stone = stone;
        }
    }
}