package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

// 조합
public class Problem15652 {

    static int n;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        int[] sel = new int[Integer.parseInt(st.nextToken())];

        recursive(sel, 0, 0);
        System.out.println(sb);
    }

    private static void recursive(int[] sel, int idx, int k) {

        if (k == sel.length) {

            for (int i = 0; i < sel.length; i++)
                sb.append(sel[i] + " ");

            sb.append("\n");
            return;
        }

        for (int i = idx; i < n; i++) {

            sel[k] = i + 1;
            recursive(sel, i, k+1);
        }
    }
}
