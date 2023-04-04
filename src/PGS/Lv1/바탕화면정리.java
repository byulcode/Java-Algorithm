package PGS.Lv1;

//https://school.programmers.co.kr/learn/courses/30/lessons/161990
class Solution {
    public int[] solution(String[] wallpaper) {
        int lux = 51, luy = 51;
        int rdx = 0, rdy = 0;

        for (int r = 0; r < wallpaper.length; r++) {
            for (int c = 0; c < wallpaper[0].length(); c++) {
                if (wallpaper[r].charAt(c) == '#') {
                    lux = Math.min(r, lux);
                    luy = Math.min(c, luy);
                    rdx = Math.max(r, rdx);
                    rdy = Math.max(c, rdy);
                }
            }
        }
        return new int[]{lux, luy, rdx + 1, rdy + 1};
    }
}
