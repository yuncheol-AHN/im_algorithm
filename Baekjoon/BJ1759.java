package Baekjoon;

import java.io.*;
import java.util.*;

public class BJ1759 {
    static char[] arr;
    static int L;
    static int C;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        // arr 생성, 정렬
        st = new StringTokenizer(br.readLine());
        arr = new char[C];
        for (int c = 0; c < C; c++) {
            arr[c] = st.nextToken().charAt(0);
        }
        Arrays.sort(arr);

        // 조합(재귀)
        recursive(new char[L], 0, 0);
    }

    private static void recursive(char[] sel, int idx, int chk) {
        if (chk == sel.length) {
            if (check(sel)) { // 자음 2개 모음 1개 일때
                print(sel);
            }
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            sel[chk] = arr[i];
            recursive(sel, i+1, chk+1);
        }
    }

    private static void print(char[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i]);
        System.out.println();
    }

    private static boolean check(char[] arr) {
        int jaeum = 0;
        int moeum = 0;

        for (int i = 0; i < arr.length; i++) {
            if (checkMoeum(arr[i]))
                moeum += 1;
            else
                jaeum += 1;
        }

        return jaeum >= 2 && moeum >= 1;
    }

    private static boolean checkMoeum(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c== 'u';
    }
}
