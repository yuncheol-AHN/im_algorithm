package SWEA;

import java.io.*;
import java.util.*;

/*

 */
public class Problem5215 {

    static int max = Integer.MIN_VALUE;
    static int N;
    static int L;

    static int[] taste;
    static int[] calory;

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("input"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        for (int x = 1; x <= T; x++) {

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            taste = new int[N];
            calory = new int[N];

            for (int i = 0; i < N; i++) {

                st = new StringTokenizer(br.readLine());
                taste[i] = Integer.parseInt(st.nextToken());
                calory[i] = Integer.parseInt(st.nextToken());
            }

            /*
                L을 넘지 않는 최고의 맛을 찾아라 !
             */

            recursive(0, 0, 0);

            System.out.printf("#%d %d\n", x, max);
        }
    }

    private static void recursive(int idx, int tastes, int calories) {

        if (N == idx) {
            max = (tastes > max) ? tastes : max;
            return;
        }


        recursive(idx+1, tastes + taste[idx], calories + calory[idx]);
        recursive(idx+1, tastes, calories);
    }
}