import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] ropes = new int[n];


        for (int i = 0; i < n; i++) {
            ropes[i] = Integer.parseInt(br.readLine());
        }

        // rope 배열 오름차순 정렬
        Arrays.sort(ropes);

        // 최대 중량값 설정
        int maxWeight = 0;

        // 최대 중량 업데이트
        for (int i = 0; i < n; i++) {
            maxWeight = Math.max(maxWeight, ropes[i] * (n - i));
        }
        System.out.println(maxWeight);
    }
}
