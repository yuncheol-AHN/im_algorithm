package Baekjoon;

import java.io.*;
import java.util.*;

public class BJ16926 {

    public static void main(String[] args) throws IOException {
        //System.setIn(new FileInputStream("input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 변수 생성
        st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());   // 행 길이
        int C = Integer.parseInt(st.nextToken());   // 열 길이
        int n = Integer.parseInt(st.nextToken());   // 돌리는 횟수
        int[][] board = new int[R][C];              // 원본 배열
        int[][] answer = new int[R][C];             // 이동 배열

        // make board
        for (int r = 0; r < R; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < C; c++) {
                board[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        /*
        Point
        1. 배열 다루기
            1-1. 경계값 정확하게 인식 : 같다. 크다. 작다.
            1-2. 대응되는 값들의 index 파악
        2. 반복문
         */
        for (int x = 0; x < n; x++) {

            int k = 0;
            while (k <= (R-1)-k && k <= (C-1)-k) {
                for (int i = k; i < (R-1)-k; i++) {
                    answer[i+1][k] = board[i][k];                       // 상 -> 하
                    answer[(R-2)-i][(C-1)-k] = board[(R-1)-i][(C-1)-k]; // 하 -> 상
                }

                for (int j = k; j < (C-1)-k; j++) {
                    answer[(R-1)-k][j+1] = board[(R-1)-k][j];           // 좌 -> 우
                    answer[k][(C-1)-(j+1)] = board[k][(C-1)-j];         // 우 -> 좌
                }

                k += 1;
            }
            assign(answer, board);
        }
        print(answer);
    }

    private static void print(int[][] board) {
        int R = board.length;
        int C = board[0].length;

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                System.out.print(board[r][c] + " ");
            } System.out.println();
        }
    }

    private static void assign(int[][] from, int[][] to) {
        int R = from.length;
        int C = from[0].length;

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                to[r][c] = from[r][c];
            }
        }
    }
}
