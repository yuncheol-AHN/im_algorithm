package Baekjoon;

import java.io.*;
import java.util.*;

// 미로 탐색
public class BJ2178 {
    static int[] dr = {0,0,-1,1};
    static int[] dc = {1,-1,0,0};
    static class Point {
        int r;
        int c;
        int v;

        Point(int r, int c, int v) {
            this.r = r;
            this.c = c;
            this.v = v;
        }
    }
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] board = new int[N][M];
        boolean[][] chk = new boolean[N][M];

        for (int r = 0; r < N; r++) {
            String s = br.readLine();
            for (int c = 0; c < M; c++) {
                if (s.charAt(c) - '0' != 0)
                    board[r][c] = 1;
            }
        }

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0,0,1));
        board[0][0] = 1;
        chk[0][0] = true;

        while (!q.isEmpty()) {
            Point p = q.remove();
            if (p.r == N-1 && p.c == M-1)
                break;

            for (int i = 0; i < 4; i++) {
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];

                if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                    if (board[nr][nc] != 0 && !chk[nr][nc]) {
                        chk[nr][nc] = true;
                        board[nr][nc] = p.v+1;
                        q.add(new Point(nr, nc, p.v+1));
                    }
                }
            }
        }
        System.out.println(board[N-1][M-1]);
        print(board);
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
