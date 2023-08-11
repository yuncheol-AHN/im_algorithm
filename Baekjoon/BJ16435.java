package Baekjoon;

import java.io.*;
import java.util.*;

public class BJ16435 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);

        for (int i = 0; i < N; i++){

            if (L >= arr[i])
                L += 1;
            else
                break;
        }

        System.out.println(L);
    }
}
