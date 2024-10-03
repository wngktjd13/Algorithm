import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] A = new int[n];
        Integer[] B = new Integer[n];   // Collections.reverseOrder()를 사용하기 위해 객체형 Integer 배열 선언

        // 배열 A 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // 배열 B 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        // 배열 A 오름차순 정렬
        Arrays.sort(A);

        // 배열 B 내림차순 정렬
        Arrays.sort(B, Collections.reverseOrder());

        int result = 0;
        for (int i = 0; i < n; i++) {
            result += A[i] * B[i];
        }

        System.out.println(result);

    }
}
