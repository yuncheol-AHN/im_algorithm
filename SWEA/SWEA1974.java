package SWEA;

import java.io.*;
import java.util.*;

// 스도쿠 검증
public class SWEA1974 {
    static boolean flag;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int xx = 1; xx <= T; xx++) {

            int[][] board = new int[9][9];
            for (int r = 0; r < 9; r++) {
                st = new StringTokenizer(br.readLine());
                for (int c = 0; c < 9; c++) {
                    board[r][c] = Integer.parseInt(st.nextToken());
                }
            }
            flag = false;
            // horizontal
            for (int i = 0; i < 9; i++) {
                check(board[i]);
            }
            if (flag == true) {
                System.out.printf("#%d %d\n", xx, 0);
                continue;
            }
            // vertical
            int[] arr = new int[9];
            for (int c = 0; c < 9; c++) {
                for (int r = 0; r < 9; r++) {
                    arr[r] = board[r][c];
                }
                check(arr);
            }
            if (flag == true) {
                System.out.printf("#%d %d\n", xx, 0);
                continue;
            }
            // 3X3
            for (int k = 0; k < 9; k += 3) {
                for (int r = 0; r < 3; r++) {
                    for (int c = 0; c < 3; c++) {
                        arr[(r*3) + c] = board[r][c];
                    }
                }
                check(arr);
            }
            if (flag == true)
                System.out.printf("#%d %d\n", xx, 0);
            else
                System.out.printf("#%d %d\n", xx, 1);
        }
    }
    private static void check(int[] arr) {

        boolean[] chk = new boolean[9];
        for (int i = 0; i < 9; i++) {
            int idx = arr[i] - 1;
            if (chk[idx] == true) {
                flag = true;
                return;
            } else {
                chk[idx] = true;
            }
        }
    }
}
