package Baekjoon;

// 신기한 소수 찾기
public class BJ2023 {
    public static void main(String[] args) {

        java.util.Scanner sc = new java.util.Scanner(System.in);
        int N = sc.nextInt();
        int s = (int) Math.pow(10,N-1) * 2;
        int e = (int) Math.pow(10,N);

        for (int i = 2; i < 9; i++) {
            recursive(i, N-1);
        }
    }

    private static void recursive(int num, int N) {

        if (!checkPrime(num))
            return;

        if (N == 0) {
            System.out.println(num);
            return;
        }
        for (int i = 1; i < 10; i++)
            recursive(10 * num + i, N-1);
    }


    private static boolean checkPrime(int num) {
        while (num > 0) {

            for (int i = 2; i <= Math.sqrt(num); i++) {
                if (num % i == 0)
                    return false;
            }

            num /= 10;
        }

        return true;
    }
}