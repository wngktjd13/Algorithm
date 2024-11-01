import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> crane = new ArrayList<>();  // 내림차순 정렬을 위해 Integer 배열로 선언 -> ArrayList로 변경
        for (int i = 0; i < n; i++) {
            crane.add(Integer.parseInt(st.nextToken()));
        }

        int m = Integer.parseInt(br.readLine());
        ArrayList<Integer> box = new ArrayList<>(); // 박스를 옮길때마다 해당 박스를 제거하기 위해 ArrayList로 선언.
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            box.add(Integer.parseInt(st.nextToken()));
        }

        // 크레인과 박스 배열 모두 내림차순 정렬
        Collections.sort(crane, Collections.reverseOrder());
        Collections.sort(box, Collections.reverseOrder());

        // 박스의 무게가 크레인의 최대 무게 제한을 벗어나는 경우
        if (crane.get(0) < box.get(0)) {
            System.out.println(-1);
            return;
        }

        int count = 0;

        // 박스가 배로 전부 옮겨질 때까지 반복
        while (!box.isEmpty()) {
            for (int i = 0; i < crane.size(); i++) {
                for (int j = 0; j < box.size(); j++) {
                    if (crane.get(i) >= box.get(j)) {
                        box.remove(j);
                        break;
                    }
                }
            }
            count++;

        }
        System.out.println(count);
    }
}
