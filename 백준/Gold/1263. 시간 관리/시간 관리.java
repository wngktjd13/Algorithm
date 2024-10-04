import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        // 소요 시간, 마감 시간을 저장할 배열
        int[][] tasks = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            // 한 줄의 입력을 공백을 기준으로 나누어 배열에 저장
            String[] input = br.readLine().split(" ");
            tasks[i][0] = Integer.parseInt(input[0]); // 소요 시간
            tasks[i][1] = Integer.parseInt(input[1]); // 마감 시간
        }

        // 마감 시간을 기준으로 내림차순 정렬
        Arrays.sort(tasks, (a, b) -> b[1] - a[1]);

        // 가능한 가장 늦게 시작할 수 있는 시간
        int latestStart = Integer.MAX_VALUE;

        // 각 일을 순차적으로 처리
        for (int i = 0; i < n; i++) {
            int duration = tasks[i][0];
            int deadline = tasks[i][1];

            // 일을 마감 시간에 끝내기 위해서는 latestStart와 마감 시간 중 더 작은 값에서 소요 시간을 뺀다
            latestStart = Math.min(latestStart, deadline) - duration;

            // 만약 latestStart가 음수가 되면 모든 일을 끝낼 수 없음
            if (latestStart < 0) {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(latestStart);
    }
}
