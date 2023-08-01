package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Problem15650 {

    static int n;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int[] sel = new int[Integer.parseInt(st.nextToken())];

        recursive(sel, 0, 0);
    }

    private static void recursive(int[] sel, int idx, int k) {

        if (k == sel.length) {

            for (int i = 0; i < sel.length; i++)
                System.out.printf(sel[i] + " ");
            System.out.println();

            return;
        }

        for (int i = idx; i < n; i++) {

            sel[k] = i + 1;
            recursive(sel, i+1, k+1);
        }
    }
}
