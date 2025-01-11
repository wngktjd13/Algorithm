import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        // 람다식을 활용한 2차원 배열의 정렬
        Arrays.sort(arr, (e1, e2) -> {
            if(e1[0] == e2[0]){
                return e1[1] - e2[1];
            } else {
                return e1[0] - e2[0];
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(arr[i][0] + " " + arr[i][1]).append('\n');
        }

        System.out.println(sb);

    }
}
