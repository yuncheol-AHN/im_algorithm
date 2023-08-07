package SWEA;

import java.io.*;
import java.util.*;

public class SWEA1228 {

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        List list = new ArrayList<>();

        for (int xx = 1; xx <= 10; xx++) {

            list.clear();
            br.readLine();  // 원본 암호문 길이 버리기
            st = new StringTokenizer(br.readLine());

            while (st.hasMoreTokens())
                list.add(Integer.parseInt(st.nextToken()));

            int N = Integer.parseInt(br.readLine());    // 명령어 개수
            st = new StringTokenizer(br.readLine());
            int idx;    // 삽입 위치 인덱스
            int count;  // 추가 암호문 개수
            for (int i = 0; i < N; i++) {

                st.nextToken(); // I 버리기
                idx = Integer.parseInt(st.nextToken()); // 삽입 위치 인덱스
                count = Integer.parseInt(st.nextToken());   // 추가 암호문 개수

                for (int k = 0; k < count; k++)
                    list.add(idx++, Integer.parseInt(st.nextToken()));

            }
            System.out.printf("#%d ", xx);
            for (int i = 0; i < 10; i++)
                System.out.printf("%d ", list.get(i));
            System.out.println();
        }


    }
}
