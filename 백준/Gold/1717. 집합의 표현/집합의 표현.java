import java.io.*;
import java.util.*;

public class Main {
    // 부모 배열과 랭크 배열을 전역 변수로 선언
    static int[] parent; // 각 원소의 부모를 나타내는 배열
    static int[] rank;   // 각 트리의 높이를 저장하는 배열 (랭크 최적화를 위해 사용)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1]; // 1부터 n까지 사용할 것이므로 n+1 크기로 선언
        rank = new int[n + 1];

        // 모든 원소를 자기 자신이 루트인 독립 집합으로 초기화
        for (int i = 0; i <= n; i++) {
            parent[i] = i; // 각 원소의 부모를 자기 자신으로 설정
            rank[i] = 1;   // 초기 트리 높이는 1
        }

        // StringBuilder를 사용하여 출력 성능 최적화
        StringBuilder sb = new StringBuilder();

        // m개의 연산 처리
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken()); // 연산 종류 (0 또는 1)
            int a = Integer.parseInt(st.nextToken());  // 첫 번째 원소
            int b = Integer.parseInt(st.nextToken());  // 두 번째 원소

            if (op == 0) {
                // op == 0: a와 b가 포함된 두 집합을 합친다
                union(a, b);
            } else if (op == 1) {
                // op == 1: a와 b가 같은 집합에 속해 있는지 확인한다
                if (find(a) == find(b)) {
                    sb.append("YES\n"); // 같은 집합이면 YES
                } else {
                    sb.append("NO\n");  // 다른 집합이면 NO
                }
            }
        }
        System.out.print(sb);
    }

    // Find 함수: 경로 압축(Path Compression)을 적용
    static int find(int x) {
        if (x != parent[x]) {
            // x가 루트가 아니면 재귀적으로 부모를 찾는다
            // 찾은 루트를 현재 노드의 부모로 설정 (경로 압축)
            parent[x] = find(parent[x]);
        }
        return parent[x]; // x의 루트 반환
    }

    // Union 함수: 랭크를 기준으로 두 집합을 합친다
    static void union(int x, int y) {
        int rootX = find(x); // x의 루트 노드
        int rootY = find(y); // y의 루트 노드

        if (rootX != rootY) {
            // 두 노드의 루트가 다를 경우에만 합친다
            if (rank[rootX] > rank[rootY]) {
                // rootX의 트리 높이가 더 크면 rootY를 rootX 밑에 붙인다
                parent[rootY] = rootX;
            } else if (rank[rootX] < rank[rootY]) {
                // rootY의 트리 높이가 더 크면 rootX를 rootY 밑에 붙인다
                parent[rootX] = rootY;
            } else {
                // 높이가 같을 경우, 한쪽에 붙이고 높이를 1 증가시킨다
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }
}
