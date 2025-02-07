import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] met_sch = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            met_sch[i][0] = Integer.parseInt(st.nextToken());   // 시작시간
            met_sch[i][1] = Integer.parseInt(st.nextToken());   // 종료시간
        }

        // 종료 시간이 빠른 순으로 정렬, 같으면 시작 시간이 빠른 순으로 정렬
        Arrays.sort(met_sch, (o1, o2) -> {
            if(o1[1] == o2[1]) { // 종료시간이 같을 경우 시작 시간이 빠른 순
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });

        int cnt = 0;
        int end = 0;

        for (int i = 0; i < n; i++) {
            if(end <= met_sch[i][0]) {
                end = met_sch[i][1];
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
