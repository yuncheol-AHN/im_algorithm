package Baekjoon;

public class BJ1992 {

    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        int N = sc.nextInt();
        int[][] board = new int[N][N];

        String s;
        for (int r = 0; r < N; r++) {
            s = sc.next();
            for (int c = 0; c < N; c++) {
                board[r][c] = s.charAt(c) - '0';
            }
        }
    }
    /*
    1. 시작점과 도착점
    2. 입력값과 출력값
     */
    private static void backtracking(int[][] board) {
        // tracking !!

    }
}
