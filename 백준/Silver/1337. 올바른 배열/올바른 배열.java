import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 오름차순 정렬
        Arrays.sort(arr);

        int minAddition = Integer.MAX_VALUE;

        // 슬라이딩 윈도우 방식으로 추가되어야 할 최소 원소의 개수 계산
        for (int i = 0; i < arr.length; i++) {   // i는 슬라이딩 윈도우의 시작점
            int count = 1;  // 현재 구간에서 몇 개의 숫자가 같은 구간(5개의 연속된 수)에 속하는지 세는 변수
            for (int j = i + 1; j < arr.length; j++) {  // j는 슬라이딩 윈도우의 끝점
                if (arr[j] - arr[i] < 5) {   // 현재 숫자(arr[j])와 시작점(arr[i])의 차이가 4 이하일 때만 같은 구간에 속하도록 함
                    count++;
                }
            }
            // 5개의 연속된 수가 되기 위해 추가되어야 할 원소의 최솟값을 갱신
            minAddition = Math.min(minAddition, 5 - count);
        }

        // 결과 출력
        System.out.println(minAddition);
    }
}
