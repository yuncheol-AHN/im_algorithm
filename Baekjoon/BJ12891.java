package Baekjoon;

import java.io.*;
import java.util.*;

// DNA 비밀번호
public class BJ12891 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int answer = 0;

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        String s = br.readLine();

        // la,c,g,t : 제한된 a,c,g,t
        // na,c,g,t : 서브배열의 a,c,g,t *dn : 서브배열의 !(a,c,g,t)
        st = new StringTokenizer(br.readLine());
        int la = Integer.parseInt(st.nextToken());
        int lc = Integer.parseInt(st.nextToken());
        int lg = Integer.parseInt(st.nextToken());
        int lt = Integer.parseInt(st.nextToken());
        int na = 0, nc = 0, ng = 0, nt = 0, dn = 0;

        // 초기 서브배열
        for (int i = 0; i < P; i++) {
            if (s.charAt(i) == 'A') na++;
            else if (s.charAt(i) == 'C') nc++;
            else if (s.charAt(i) == 'G') ng++;
            else if (s.charAt(i) == 'T') nt++;
            else dn++;
        }
        // 초기 서브배열 연산
        if (!(dn > 0 || na < la || nc < lc || ng < lg || nt < lt))
            answer++;

        // 루프
        for (int i = P; i < S; i++) {
            if (s.charAt(i-P) == 'A') na--;
            else if (s.charAt(i-P) == 'C') nc--;
            else if (s.charAt(i-P) == 'G') ng--;
            else if (s.charAt(i-P) == 'T') nt--;
            else dn--;

            if (s.charAt(i) == 'A') na++;
            else if (s.charAt(i) == 'C') nc++;
            else if (s.charAt(i) == 'G') ng++;
            else if (s.charAt(i) == 'T') nt++;
            else dn++;

            if (!(dn > 0 || na < la || nc < lc || ng < lg || nt < lt))
                answer++;
        }

        System.out.println(answer);
    }
}
