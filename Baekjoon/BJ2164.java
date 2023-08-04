package Baekjoon;

import java.io.*;
import java.util.*;

// 카드2
public class BJ2164 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();

        // 큐 생성
        for (int i = 1; i <= n; i++)
            queue.add(i);

        int tmp;
        while (queue.size() > 1) {

            queue.poll();
            tmp = queue.poll();
            queue.add(tmp);
        }

        System.out.println(queue.peek());
    }
}
