import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        int result = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        while(n-3 >= 0){
            if (arr[n - 1] < arr[n - 2] + arr[n - 3]) {
                result += arr[n - 1] + arr[n - 2] + arr[n - 3];
                break;
            }
            n--;
        }

        if(result == 0){
            System.out.println(-1);
        }else{
            System.out.println(result);
        }
    }
}
