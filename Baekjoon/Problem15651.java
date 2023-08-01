package Baekjoon;

import java.io.*;
import java.util.*;

// 중복 순열
public class Problem15651 {

    static int n;
    static int c;
    static int[] sel;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        sel = new int[Integer.parseInt(st.nextToken())];

        permutationRepeated(sel, 0);

        System.out.println(sb);
    }

    private static void permutationRepeated(int[] sel, int idx) {

        if (idx == sel.length) {

            for (int i = 0; i < sel.length; i++)
                sb.append(sel[i] + " ");

            sb.append("\n");

            return;
        }

        for (int i = 0; i < n; i++) {

            sel[idx] = i+1;
            permutationRepeated(sel, idx+1);
        }
    }
}
