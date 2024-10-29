import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if(n==1){
            System.out.println(0);
            return;
        }

        int dasom = sc.nextInt();
        int[] candidate = new int[n-1];
        int count = 0;

        for (int i = 0; i < n-1; i++) {
            candidate[i] = sc.nextInt();
        }

        Arrays.sort(candidate);
        while(dasom <= candidate[candidate.length-1]){
            dasom ++;
            candidate[candidate.length-1] --;
            Arrays.sort(candidate);
            count ++;
        }

        System.out.println(count);

    }
}
