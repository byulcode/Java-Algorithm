class Solution {
    public int solution(String[] board) {

        int cnt_x = 0;
        int cnt_o = 0;

        String[][] arr = new String[3][3];
        for (int i = 0; i < 3; i++) {
            arr[i] = board[i].split("");
            for (int j = 0; j < 3; j++) {
                if (arr[i][j].equals("X"))
                    cnt_x++;
                if (arr[i][j].equals("O"))
                    cnt_o++;
            }
        }

        if(cnt_x - cnt_o > 0 || cnt_o - cnt_x > 1)
            return 0;

        if(checkWin("O", arr) && cnt_x + 1 != cnt_o){
            return 0;
        }
        if (cnt_x != cnt_o && checkWin("X", arr))
            return 0;

        return 1;
    }

    static boolean checkWin(String target, String[][] board) {

        for (int i = 0; i < 3; i++) {
            if (board[i][0].equals(target) && board[i][1].equals(target) && board[i][2].equals(target))
                return true;

        }
        for (int i = 0; i < 3; i++) {
            if (board[0][i].equals(target) && board[1][i].equals(target) && board[2][i].equals(target))
                return true;
        }

        if(board[0][0].equals(target) && board[1][1].equals(target) && board[2][2].equals(target))
            return true;

        if (board[2][0].equals(target) && board[1][1].equals(target) && board[0][2].equals(target))
            return true;
        return false;
    }
}