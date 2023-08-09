package Baekjoon;

import java.io.*;
import java.util.*;

public class BJ4963 {
    static int[] dr = {1, -1, 0, 0, 1, -1, 1, -1};
    static int[] dc = {1, -1, 1, -1, -1, 1, 0, 0};
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int C = Integer.parseInt(st.nextToken());
            int R = Integer.parseInt(st.nextToken());

            if (R == 0)
                break;

            int[][] board = new int[R][C];

            for (int r = 0; r < R; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < C; c++) {
                    board[r][c] = Integer.parseInt(st.nextToken());
                }
            }

            int answer = 0;
            for (int r = 0; r < R; r++) {
                for (int c = 0; c < C; c++) {
                    if (board[r][c] == 1) {
                        answer += 1;
                        recursive(board, r, c);
                    }
                }
            }
            System.out.println(answer);
        }
    }

    private static void recursive(int[][] board, int r, int c) {
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] == 0)
            return;

        board[r][c] = 0;
        for (int i = 0; i < 8; i++) {
            recursive(board, r + dr[i], c + dc[i]);
        }
    }
}
