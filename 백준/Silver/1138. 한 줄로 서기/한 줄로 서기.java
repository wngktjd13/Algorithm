import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] height_count = new int[n];
        int[] result = new int[n];

        // 키가 1인 사람부터 차례대로 자기보다 키가 큰 사람이 왼쪽에 몇 명이 있었는지 주어질 때 문자를 분리하여 height_count 배열에 저장하기 위함
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            height_count[i] = Integer.parseInt(st.nextToken());
        }

        // 키가 1인 사람부터 height_count 배열의 각 원소의 값에 따라 result 배열에 저장
        for (int i = 0; i < n; i++) {
            int j = 0;

            // height_count 원소의 값이 0이 아닌 경우에는 0이 될 때 까지 저장되는 result 배열의 인덱스 값을 1씩 증가시킴.
            // height_count 원소의 값이 0이 되었을 때 result 배열에 저장
            while(true){
                if(height_count[i] == 0 && result[j] == 0){
                    result[j] = i+1; // 키가 1인 사람부터 시작하기에
                    break;
                } else if(result[j] == 0){
                    height_count[i]--;
                }
                j++;
            }

        }

        for (int i = 0; i < n; i++) {
            System.out.print(result[i]+" ");
        }

    }
}
