import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        char[][] arr = new char[n][n];
        int[] friendCount = new int[n];

        // 친구 관계 배열
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;

                // 직접 친구인 경우
                if (arr[i][j] == 'Y') {
                    friendCount[i]++; // 직접 친구 수 증가
                } else {
                    // 2-친구 관계 확인
                    for (int k = 0; k < n; k++) {
                        if (arr[i][k] == 'Y' && arr[k][j] == 'Y') {
                            friendCount[i]++; // 2-친구 관계 발견 시 증가
                            break; // 이미 2-친구가 있으면 더 이상 확인하지 않음
                        }
                    }
                }
            }
        }

        // friendCount 배열에서 최대값
        System.out.println(Arrays.stream(friendCount).max().getAsInt());
    }
}