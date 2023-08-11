package Baekjoon;

// 설탕 배달
public class BJ2839 {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        int n = sc.nextInt();
        int answer = 0;


        while (n > 0) {
            if (n % 5 == 0) {
                while (n > 0) {
                    n -= 5;
                    answer += 1;
                }
                break;
            }

            n -= 3;
            answer += 1;
        }

        if (n == 0)
            System.out.println(answer);
        else
            System.out.println(-1);
    }
}
