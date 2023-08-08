package Baekjoon;

import java.io.*;
import java.util.*;

// 유기농 배추
public class BJ1012 {
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        /*
            1. TC 개수 입력

            2. board 생성
            4. [0,0] -> [N, M] 순회
                4-1. 1을 만나면 주변에 1이 없을 때 까지 재귀 후, 다시 탐색  * answer +1
         */

        System.setIn(new FileInputStream("input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int xx = 1; xx <= T; xx++) {

            int answer = 0;

            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());   // 가로
            int N = Integer.parseInt(st.nextToken());   // 세로
            int n = Integer.parseInt(st.nextToken());   // 배추 개수

            // board 생성
            int[][] board = new int[N][M];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                board[r][c] = 1;
            }


            // Queue
            int[][] copy = board.clone();
            baechuQueue(copy(board));

            /*
            // Recursive
            // [0, 0] -> [N, M] 순회
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (board[i][j] == 1) {
                        answer += 1;
                        baechuRecursive(i, j, board);
                    }
                }
            }
            System.out.println(answer);
        */}
    }

    private static void baechuRecursive(int r, int c, int[][] board) {
        for (int i = 0; i < 4; i++) {
            if (r + dr[i] >= 0 && r + dr[i] < board.length && c + dc[i] >= 0 && c + dc[i] < board[0].length && board[r + dr[i]][c + dc[i]] == 1) {
                board[r + dr[i]][c + dc[i]] = 0;
                baechuRecursive(r + dr[i], c + dc[i], board);
            }
        }
    }
    private static void baechuQueue(int[][] board) {    // 메모리 초과

        int answer = 0;
        Deque<int[]> q = new ArrayDeque<>();
        int R = board.length;
        int C = board[0].length;

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {

                if (board[r][c] == 1) {
                    q.add(new int[] {r, c});

                    while (!q.isEmpty()) {
                        int[] tmp = q.pop();
                        board[tmp[0]][tmp[1]] = 0;

                        for (int i = 0; i < 4; i++) {
                            if (tmp[0] + dr[i] >= 0 && tmp[0] + dr[i] < R && tmp[1] + dc[i] >= 0 && tmp[1] + dc[i] < C && board[tmp[0] + dr[i]][tmp[1] + dc[i]] == 1) {
                                q.add(new int[] {tmp[0] + dr[i], tmp[1] + dc[i]});
                            }
                        }
                    }
                    answer++;
                }
            }
        }

        // output 출력
        System.out.println(answer);
    }
    private static int[][] copy(int[][] base) {

        int[][] tmp = new int[base.length][base[0].length];

        for (int i = 0; i < base.length; i++) {
            for (int j = 0; j < base[0].length; j++)
                tmp[i][j] = base[i][j];
        }

        return tmp;
    }
    private static void printBoard(int R, int C, int[][] board) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(board[i][j] + " ");
            } System.out.println();
        }
    }
}
