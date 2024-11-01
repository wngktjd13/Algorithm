import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] sensor = new int[n];
        for (int i = 0; i < n; i++) {
            sensor[i] = Integer.parseInt(st.nextToken());
        }

        // 센서의 수보다 기지국의 수가 많다면 항상 수신 가능
        if (k >= n) {
            System.out.println(0);
            return;
        }

        // 센서 배열 오름차순 정렬
        Arrays.sort(sensor);

        // 센서 사이의 간격으로 이루어진 배열 생성
        int[] gap = new int[n - 1];
        for (int i = 1; i < n; i++) {
            gap[i - 1] = sensor[i] - sensor[i - 1];
        }

        // 센서 사이의 간격으로 이루어진 배열 오름차순 정렬
        Arrays.sort(gap);

        int result = 0;
        for (int i = 0; i < n - k; i++) { // k-1개의 최대 간격 제거
            result += gap[i];
        }
        System.out.println(result);
    }
}