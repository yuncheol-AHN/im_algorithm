package SWEA;

import java.io.*;
import java.util.*;

/*

 */
public class SWEA5215 {

    static int max = Integer.MIN_VALUE;
    static int N;
    static int L;

    static int[] tastes;
    static int[] calories;
    static int taste;
    static int calory;

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("input"));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());


        for (int x = 1; x <= T; x++) {

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            tastes = new int[N];
            calories = new int[N];
            taste = 0;
            calory = 0;
            // max = Integer.MIN_VALUE;

            for (int i = 0; i < N; i++) {

                st = new StringTokenizer(br.readLine());
                tastes[i] = Integer.parseInt(st.nextToken());
                calories[i] = Integer.parseInt(st.nextToken());
            }

            /*
                L을 넘지 않는 최고의 맛을 찾아라 !
            // max = recursive(0, 0, 0);
             */

            System.out.printf("#%d %d\n", x, recursive(N, L));
        }
    }

    private static void recursive(int idx, int taste, int calory) {

        if (N == idx) {
            max = (taste > max) ? taste : max;
            return;
        }

        if (L > calory + calories[idx])
            recursive(idx+1, taste + tastes[idx], calory + calories[idx]);

        recursive(idx+1, taste, calory);
    }

    private static int recursive(int idx, int w) {  // paramter : index, calory // output : taste

        if (idx == 0 || w == 0)
            return 0;

        if (calories[idx-1] > w)
            return recursive(idx - 1, w);
        else
            return Math.max(
                    recursive(idx-1, w - calories[idx-1]) + tastes[idx-1],  // 포함 O
                    recursive(idx-1,w));    // 포함 X
    }
}