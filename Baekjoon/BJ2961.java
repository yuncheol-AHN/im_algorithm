package Baekjoon;

import java.io.*;
import java.util.StringTokenizer;

// 도영이가 만든 맛있는 음식
public class BJ2961 {
    static int[] s;
    static int[] b;
    static int mi = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());    // 음식의 개수
        s = new int[N]; // 신맛 배열 : 크기 N
        b = new int[N]; // 쓴맛 배열 : 크기 N
        int sSum = 1;   // 신맛 초기값
        int bSum = 0;   // 쓴맛 초기값

        // 신맛 배열, 쓴맛 배열 설정
        for (int i = 0; i < N; i++) {

            st = new StringTokenizer(br.readLine());
            s[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
        }

        recursive(N, sSum, bSum);
        System.out.println(mi);
    }

    private static void recursive(int idx, int sSum, int bSum) {

        if (idx == 0) {
            if (sSum == 1 || bSum == 0)
                return;

            mi = min(Math.abs(sSum-bSum), mi);
            return;
        }

        recursive(idx-1, sSum * s[idx-1], bSum + b[idx-1]);
        recursive(idx-1, sSum, bSum);
    }

    private static int min(int a, int b) {
        return (a > b) ? b : a;
    }
}