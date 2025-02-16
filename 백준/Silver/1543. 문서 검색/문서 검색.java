import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String document = br.readLine();
        String word = br.readLine();

        int count = 0;

        while (document.contains(word)) {
            document= document.substring(document.indexOf(word)+word.length(), document.length());
            count ++;
        }

        System.out.println(count);
    }
}