import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String document = br.readLine();
        String word = br.readLine();

        int doc_size = document.length();
        int word_size = word.length();

        document = document.replace(word, "");
        System.out.println((doc_size - document.length()) / word_size);
    }
}