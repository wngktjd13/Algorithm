import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        // 삼각형의 성립 조건을 만족하지 않는 걍우 -1을 출력하도록 설정
        int result = -1;

        // 빨대의 길이를 arr 배열에 저장
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        // 삼각형의 성립 조건 : 가장 큰 변의 길이보다 나머지 두 변의 길이 합이 더 커야 함.
        // 성립 조건을 만족할 때까지 반복
        while(n-3 >= 0){
            if (arr[n - 1] < arr[n - 2] + arr[n - 3]) {
                result = arr[n - 1] + arr[n - 2] + arr[n - 3];
                break;
            }
            n--;
        }
        System.out.println(result);
    }
}
