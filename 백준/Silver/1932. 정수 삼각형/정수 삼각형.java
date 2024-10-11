import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 삼각형 배열
        int[][] arr = new int[501][501];
        int n = sc.nextInt();

        // 삼각형의 각 줄을 i로, 각 줄의 값들을 j로 설정
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        // 삼각형의 마지막 줄 바로 위부터 시작해서 한 줄씩 올라가며 최댓값을 계산
        for (int i = n - 1; i >= 1; i--) {
            for (int j = 1; j <= i; j++) {
                arr[i][j] += Math.max(arr[i + 1][j], arr[i + 1][j + 1]);
            }
        }

        System.out.println(arr[1][1]);
    }
}
