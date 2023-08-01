package Baekjoon;

import java.io.*;
import java.util.*;

/*
    N과 M (1)
    순열
 */
public class Problem15649 {
    static int[] sel;
    static boolean[] chk;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        chk = new boolean[n];
        sel = new int[Integer.parseInt(st.nextToken())];

        permutationRepeated(0);
    }

    private static void permutationRepeated(int k) {

        if (k == sel.length) {
            for (int i = 0; i < sel.length; i++)
                System.out.printf(sel[i] + " ");
            System.out.println();
            return;
        }

        for (int i = 0; i < n; i++) {

            if (chk[i] == false) {
                chk[i] = true;
                sel[k] = i+1;
                permutationRepeated(k+1);
                chk[i] = false;
            }
        }
    }
}
