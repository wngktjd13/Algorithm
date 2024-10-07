import java.util.Scanner;

public class Main {
    static int[] score;
    static Integer[] dp; // Integer로 선언하여 null 체크 가능하도록 설정

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        score = new int[n + 1];
        dp = new Integer[n + 1];

        for (int i = 1; i <= n; i++) {
            score[i] = sc.nextInt();
        }

        // 초기값 설정
        dp[0] = 0;
        dp[1] = score[1];
        if (n >= 2) {
            dp[2] = score[1] + score[2];
        }

        System.out.println(MaxScore(n));
    }

    static int MaxScore(int n) {
        // 이미 계산된 값이 있는 경우 반환
        if (dp[n] != null) {
            return dp[n];
        }

        // dp[n]을 계산
        dp[n] = Math.max(MaxScore(n - 2), MaxScore(n - 3) + score[n - 1]) + score[n];
        return dp[n];
    }
}