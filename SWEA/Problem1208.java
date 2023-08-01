package SWEA;

import java.io.*;
import java.util.StringTokenizer;

public class Problem1208 {

    static int[] boxs = new int[100];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int dumpCount;
        int maxIdx;
        int minIdx;

        for (int xx = 1; xx <= 10; xx++) {

            dumpCount = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < 100; i++)
                boxs[i] = Integer.parseInt(st.nextToken());

            while (dumpCount-- > 0) {

                maxIdx = findMaxIdx();
                minIdx = findMinIdx();

                boxs[maxIdx] -= 1;
                boxs[minIdx] += 1;
            }
            maxIdx = findMaxIdx();
            minIdx = findMinIdx();

            System.out.printf("#%d %d\n", xx, boxs[maxIdx] - boxs[minIdx]);
        }
    }

    private static int findMinIdx() {
        int idx = 0;

        for (int i = 1; i < 100; i++) {
            idx = (boxs[idx] > boxs[i]) ? i : idx;
        }

        return idx;
    }

    private static int findMaxIdx() {
        int idx = 0;

        for (int i = 1; i < 100; i++) {
            idx = (boxs[idx] < boxs[i]) ? i : idx;
        }

        return idx;
    }
}
