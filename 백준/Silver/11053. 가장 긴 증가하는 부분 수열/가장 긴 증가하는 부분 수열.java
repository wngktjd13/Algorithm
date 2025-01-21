import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];     // n개의 수를 저장할 배열
        int[] dp = new int[n];      // 최대 수열 길이를 저장할 배열

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        
        for(int i = 0; i < n; i++) {
            dp[i] = 1;      // 모든 값은 길이 1을 가짐
            for(int j = 0; j < i; j++) {
                if(arr[i] > arr[j]) {   // 이전 값들과 비교를 진행해서 이전 값보다 크면 dp[i]를 갱신
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int max =0;
        for(int i = 0; i < n; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}