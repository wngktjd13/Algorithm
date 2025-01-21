import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n][3];     // 최소 비용을 저장할 DP 배열
        int[][] cost = new int[n][3];   // 비용을 저장할 배열

        for(int i = 0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            cost[i][0] = Integer.parseInt(st.nextToken());
            cost[i][1] = Integer.parseInt(st.nextToken());
            cost[i][2] = Integer.parseInt(st.nextToken());
        }

        // DP 배열의 첫 번째 집 초기화
        dp[0][0] = cost[0][0];
        dp[0][1] = cost[0][1];
        dp[0][2] = cost[0][2];

        // 두 번째 집부터 n번째 집까지 DP 테이블 채우기
        for(int i = 1;i<n;i++){
            // dp[i][0] 경우, i번째 집을 빨강으로 칠했을 때의 최소 비용. 이전 집은 초록(G) 또는 파랑(B) 중 최소 비용을 더해야 함
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + cost[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + cost[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + cost[i][2];
        }

        // 배열의 인덱스가 0부터 시작했기에 마지막 집 n-1을 의미함.
        int result = Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2]));
        System.out.println(result);
    }
}