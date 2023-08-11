package Baekjoon;

import java.io.*;
import java.util.*;

//회의실 배정
public class BJ1931 {
    static int N;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1])
                    return o1[0] - o2[0];
                else
                    return o1[1] - o2[1];
            }
        });
        System.out.println(greedy(arr));
    }

    private static int greedy(int[][] arr) {

        int answer = 1;
        int[] tmp = arr[0];
        for (int i = 1; i < N; i++) {

            if (tmp[1] > arr[i][0])
                continue;
            else {
                tmp = arr[i];
                answer += 1;
            }
        }

        return answer;
    }
}
