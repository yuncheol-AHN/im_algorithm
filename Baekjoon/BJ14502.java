package Baekjoon;

import java.io.*;
import java.util.*;

// 연구소
public class BJ14502 {
    static int[] dr = {0, 0, -1, 1};
    static int[] dc = {1, -1, 0, 0};
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[][] board = new int[R][C];

        for (int r = 0; r < R; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < C; c++) {
                board[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        combinations(0, board);
        System.out.println(max);
    }
    private static void combinations(int idx, int[][] board) {
        int R = board.length;
        int C = board[0].length;

        // basis
        if (idx == 3) {
            countSafeArea(board);
            return;
        }

        // inductive
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {

                if (board[r][c] == 0) {
                    board[r][c] = 1;
                    combinations(idx + 1, board.clone());
                    board[r][c] = 0;
                }
            }
        }
    }

    // counting safe area
    private static int countSafeArea(int[][] board) {

        int answer = 0;
        Queue<int[]> q = new LinkedList<>();


        int R = board.length;
        int C = board[0].length;
        int[][] tmpBoard = new int[R][C];

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                tmpBoard[r][c] = board[r][c];
            }
        }

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (tmpBoard[r][c] == 2)
                    q.add(new int[] {r, c});
            }
        }

        while (!q.isEmpty()) {
            int[] tmp = q.remove();

            for (int i = 0; i < 4; i++) {
                int nr = tmp[0] + dr[i];
                int nc = tmp[1] + dc[i];

                if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
                    if (tmpBoard[nr][nc] == 0) {
                        tmpBoard[nr][nc] = 2;
                        q.add(new int[] {nr, nc});
                    }
                }
            }
        }

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (tmpBoard[r][c] == 0)
                    answer += 1;
            }
        }

        return max = Math.max(answer, max);
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
