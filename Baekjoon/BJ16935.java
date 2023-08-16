package Baekjoon;

import java.io.*;
import java.util.*;

public class BJ16935 {
    static int[][] board;
    static int[][] answer;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 변수 생성
        st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());   // 행의 길이
        int C = Integer.parseInt(st.nextToken());   // 열의 길이
        int n = Integer.parseInt(st.nextToken());   // 연산의 수
        board = new int[R][C];
        answer = new int[R][C];

        // make board
        for (int r = 0; r < R; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < C; c++) {
                board[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        print(board); System.out.println();
        st = new StringTokenizer(br.readLine());
        for (int count = 0; count < n; count++) {

            int number = Integer.parseInt(st.nextToken());
            switch (number) {
                case 1:
                    moving01();
                    break;
                case 2:
                    moving02();
                    break;
                case 3:
                    moving03();
                    break;
                case 4:
                    moving04();
                    break;
                case 5:
                    moving05();
                    break;
                case 6:
                    moving06();
                    break;
            }

        }

        print(board);
    }
    private static void moving01() {
        int R = board.length;
        int C = board[0].length;

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                answer[(R-1)-r][c] = board[r][c];
            }
        }
        assignmentArray();
    }
    private static void moving02() {
        int R = board.length;
        int C = board[0].length;

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                answer[r][(C-1)-c] = board[r][c];
            }
        }
        assignmentArray();
    }
    private static void moving03() {
        int R = board.length;
        int C = board[0].length;
        answer = new int[C][R];

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                answer[c][(R-1)-r] = board[r][c];
            }
        }
        assignmentArray();
    }
    private static void moving04() {
        int R = board.length;
        int C = board[0].length;
        answer = new int[C][R];

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                answer[(C-1)-c][r] = board[r][c];
            }
        }
        assignmentArray();
    }

    private static void moving05() {
        int R = board.length;
        int C = board[0].length;

        // 1 -> 2
        for (int r = 0; r < R/2; r++) {
            for (int c = 0; c < C/2; c++) {
                answer[r][(C/2)+c] = board[r][c];
            }
        }
        // 2 -> 3
        for (int r = 0; r < R/2; r++) {
            for (int c = C/2; c < C; c++) {
                answer[(R/2)+r][c] = board[r][c];
            }
        }
        // 3 -> 4
        for (int r = R/2; r < R; r++) {
            for (int c = C/2; c < C; c++) {
                answer[r][-(C/2)+c] = board[r][c];
            }
        }
        // 4 -> 1
        for (int r = R/2; r < R; r++) {
            for (int c = 0; c < C/2; c++) {
                answer[-(R/2)+r][c] = board[r][c];
            }
        }
        assignmentArray();
    }

    private static void moving06() {
        int R = board.length;
        int C = board[0].length;

        // 1 -> 4
        for (int r = 0; r < R/2; r++) {
            for (int c = 0; c < C/2; c++) {
                answer[(R/2)+r][c] = board[r][c];
            }
        }
        // 4 -> 3
        for (int r = R/2; r < R; r++) {
            for (int c = 0; c < C/2; c++) {
                answer[r][(C/2)+c] = board[r][c];
            }
        }
        // 3 -> 2
        for (int r = R/2; r < R; r++) {
            for (int c = C/2; c < C; c++) {
                answer[-(R/2)+r][+c] = board[r][c];
            }
        }
        // 2 -> 1
        for (int r = 0; r < R/2; r++) {
            for (int c = C/2; c < C; c++) {
                answer[r][-(C/2)+c] = board[r][c];
            }
        }
        assignmentArray();
    }
    private static void assignmentArray() {
        int R = answer.length;
        int C = answer[0].length;
        board = new int[R][C];

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                board[r][c] = answer[r][c];
            }
        }
    }
    private static void print(int[][] board) {
        int R = board.length;
        int C = board[0].length;

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                System.out.print(board[r][c] + " ");
            }
            System.out.println();
        }
    }
}
