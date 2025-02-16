
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while ((line = br.readLine()) != null) { // EOF 입력 처리
            String[] input = line.split(" ");
            String s = input[0], t = input[1];

            int i = 0, j = 0; // 두 개의 포인터
            while (i < s.length() && j < t.length()) {
                if (s.charAt(i) == t.charAt(j)) {
                    i++; // s의 문자가 t에서 발견되면 s의 다음 문자로 이동
                }
                j++; // t의 다음 문자로 이동 (순서 유지)
            }

            System.out.println(i == s.length() ? "Yes" : "No");
        }
    }
}