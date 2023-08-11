package Baekjoon;

import java.util.Arrays;

public class BJ3040 {
    static int[] arr = new int[9];
    static int[] sel = new int[7];
    static int[] result;
    static boolean[] chk = new boolean[9];
    public static void main(String[] args) {

        java.util.Scanner sc = new java.util.Scanner(System.in);
        for (int i = 0; i < 9; i++)
            arr[i] = sc.nextInt();

        dfs(8, sel, chk);
        for (int e: result)
            System.out.println(e);
    }

    private static void dfs (int idx, int[] sel, boolean[] chk) {

        if (idx == 7 && sum(sel) == 100) {
            result = copyM(sel);
            return;
        }
        else if (idx == 7)
            return;

        for (int i = 8; i >= 0; i++) {
            if (chk[i] == false) {
                chk[i] = true;
                sel[idx] = arr[i];
                dfs(idx - 1, sel, chk);
                chk[i] = false;
            }
        }
    }

    private static int sum(int[] arr) {
        int sum = 0;

        for (int e: arr)
            sum += e;

        return sum;
    }

    private static int[] copyM(int[] origin) {
        int[] copy = new int[7];
        for (int i = 0; i < 7; i++) {
            copy[i] = origin[i];
        }

        return copy;
    }
}
