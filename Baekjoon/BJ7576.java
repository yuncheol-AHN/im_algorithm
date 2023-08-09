package Baekjoon;

import java.io.*;
import java.util.*;

public class BJ7576 {
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    static class Point {
        int r;
        int c;
        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        int[][] board = new int[R][C];
        int answer = -1;
        boolean flag = false;

        // board 생성
        for (int r = 0; r < R; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c = 0; c < C; c++) {
                board[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        List<Point> list = new ArrayList<>();
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (board[r][c] == 1)
                    list.add(new Point(r, c));
            }
        }

        List<Point> tmp = new ArrayList<>();
        while (!list.isEmpty()) {
            //System.out.println(list.toString());
            for (Point p: list) {
                spread(board, p.r, p.c, tmp);
            }
            answer += 1;
            list = new ArrayList<>(tmp);
            tmp.clear();
        }

        // check flag
        Loop:
        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (board[r][c] == 0) {
                    flag = true;
                    break Loop;
                }
            }
        }
        if (flag == true)
            System.out.println(-1);
        else
            System.out.println(answer);
    }
    private static void spread(int[][] board, int r, int c, List<Point> list) {
        int R = board.length;
        int C = board[0].length;

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
                if (board[nr][nc] == 0) {
                    board[nr][nc] = 1;
                    list.add(new Point(nr, nc));
                }
            }
        }
    }
}
