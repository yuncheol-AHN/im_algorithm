package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA2001 {


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for (int xx = 1; xx <= T; xx++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] board = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int m = 0;
            int tm = 0;
            for (int i = 0; i <= N-M; i++) {
                for (int j = 0; j <= N-M; j++) {
                    tm = 0;
                    for (int x = 0; x < M; x++) {
                        for (int y = 0; y < M; y++) {
                            tm += board[x][y];
                        }
                    }
                    m = (tm > m) ? tm : m;
                }
            }

            System.out.printf("#%d %d\n", xx, m);
        }



    }
}
