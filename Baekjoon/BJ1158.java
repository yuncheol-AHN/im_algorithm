package Baekjoon;

import java.util.*;

public class BJ1158 {

    public static void main(String[] args) {

        java.util.Scanner sc = new java.util.Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        Queue<Integer> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= N; i++)
            q.add(i);

        while (!q.isEmpty()) {

            for (int i = 0; i < K-1; i++)
                q.add(q.poll());

            list.add(q.poll());
        }

        System.out.print("<");
        for (int i = 0; i < N-1; i++) {
            System.out.printf("%d, ", list.get(i));
        }
        System.out.printf("%d>", list.get(list.size()-1));

    }

}
