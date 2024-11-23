import java.io.*;
import java.util.*;

public class Main {
    static Map<String, String> parent; // 각 노드의 부모를 저장
    static Map<String, Integer> size; // 각 네트워크의 크기를 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int f = Integer.parseInt(br.readLine());
            parent = new HashMap<>();
            size = new HashMap<>();

            for (int i = 0; i < f; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String person1 = st.nextToken();
                String person2 = st.nextToken();

                union(person1, person2); // 두 사람을 같은 네트워크로 연결
                sb.append(size.get(find(person1))).append("\n"); // 네트워크 크기 출력
            }
        }
        System.out.println(sb);
    }

    // find 함수: 부모를 찾고 경로 압축(Path Compression)을 적용
    private static String find(String person) {
        if (!parent.get(person).equals(person)) {
            parent.put(person, find(parent.get(person))); // 경로 압축
        }
        return parent.get(person);
    }

    // union 함수: 두 사람을 같은 네트워크로 합침
    private static void union(String person1, String person2) {
        if (!parent.containsKey(person1)) {
            parent.put(person1, person1);
            size.put(person1, 1); // 새로운 노드는 크기 1로 시작
        }
        if (!parent.containsKey(person2)) {
            parent.put(person2, person2);
            size.put(person2, 1); // 새로운 노드는 크기 1로 시작
        }

        String root1 = find(person1);
        String root2 = find(person2);

        if (!root1.equals(root2)) {
            // 네트워크를 합칠 때, 더 큰 네트워크 쪽으로 병합
            if (size.get(root1) < size.get(root2)) {
                parent.put(root1, root2);
                size.put(root2, size.get(root1) + size.get(root2));
            } else {
                parent.put(root2, root1);
                size.put(root1, size.get(root1) + size.get(root2));
            }
        }
    }
}
