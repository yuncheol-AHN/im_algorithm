package SWEA;

import java.io.*;
import java.util.*;

// 암호생성기
public class SWEA1225 {

    public static void main(String[] args) throws IOException {

        System.setIn(new FileInputStream("input"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int xx = 1; xx <= 10; xx++) {

            br.readLine();  // 필요없는 input 버리기
            st = new StringTokenizer(br.readLine());    // 암호 문자열
            Queue<Integer> queue = new LinkedList<>();

            // queue 생성
            for (int i = 0; i < 8; i++)
                queue.add(Integer.parseInt(st.nextToken()));

            int idx = 1;    // 감소하는 수의 크기
            int tmp;        // 옮기는 값
            while (true) {  // poll 맨 앞 요소 제거, add 맨 뒤 요소 추가
                tmp = queue.poll() - idx++;
                if (tmp <= 0)
                    tmp = 0;
                queue.add(tmp);

                if (idx > 5)
                    idx = 1;
                if (tmp == 0)
                    break;
            }
            
            //출력
            System.out.printf("#%d ", xx);
            for (int i = 0; i < 8; i++) {
                System.out.printf("%d ", queue.poll());
            }
            System.out.println();
        }
    }
}
