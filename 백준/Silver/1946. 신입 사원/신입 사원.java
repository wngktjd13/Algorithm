import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            // 서류 순위를 인덱스로 사용하는 배열 생성
            int[] employ = new int[n + 1];
            int count = 1; // 선발된 지원자 수 (서류 1등은 무조건 선발)

            // 각 지원자의 서류 순위와 면접 순위 입력
            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int resume = Integer.parseInt(st.nextToken());   // 서류 순위
                int interview = Integer.parseInt(st.nextToken()); // 면접 순위

                employ[resume] = interview; // 서류 순위 기준으로 면접 순위 저장
            }

            // 서류 1등의 면접 순위를 기준값으로 설정
            int standard = employ[1];

            // 서류 순위 2등부터 면접 순위를 비교
            for (int j = 2; j <= n; j++) {
                // 면접 순위가 더 낮은 경우 선발
                if (employ[j] < standard) {
                    standard = employ[j]; // 기준값 갱신
                    count++;
                }
            }

            System.out.println(count);
        }
    }
}