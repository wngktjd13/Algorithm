import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 노드 수(N)와 간선 수(M)
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 노드 개수
        int m = Integer.parseInt(st.nextToken()); // 간선 개수

        // 인접 리스트 생성
        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>(); // 각 노드에 빈 리스트 할당
        }

        // 간선 정보 입력
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // 신뢰를 받는 컴퓨터
            int b = Integer.parseInt(st.nextToken()); // 신뢰를 주는 컴퓨터
            graph[b].add(a); // 방향 그래프: B가 A를 신뢰 (B → A)
        }

        // 각 노드에서 방문 가능한 노드 수를 저장하는 배열
        int[] counts = new int[n + 1];
        int maxCount = 0; // 최대 방문 가능한 노드 수

        // 모든 노드에 대해 BFS 실행
        for (int i = 1; i <= n; i++) {
            counts[i] = bfs(graph, i, n); // i번 노드에서 시작해 방문 가능한 노드 수 계산
            maxCount = Math.max(maxCount, counts[i]); // 최댓값 업데이트
        }

        // 결과를 저장할 StringBuilder
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (counts[i] == maxCount) {
                sb.append(i).append(" "); // 최댓값을 가진 노드들을 결과에 추가
            }
        }

        // 최종 결과 출력
        System.out.println(sb.toString());
    }

    // BFS 탐색: 시작 노드(start)에서 방문 가능한 노드의 개수를 반환
    public static int bfs(ArrayList<Integer>[] graph, int start, int n) {
        // 큐 생성: BFS를 위한 탐색 큐
        Queue<Integer> queue = new LinkedList<>();
        // 방문 배열: 노드의 방문 여부를 기록
        boolean[] visited = new boolean[n + 1];
        int count = 0; // 방문한 노드 수

        // 초기 상태: 시작 노드를 큐에 추가하고 방문 처리
        queue.offer(start);
        visited[start] = true;

        // 큐가 비어있지 않을 때까지 반복
        while (!queue.isEmpty()) {
            int current = queue.poll(); // 큐에서 노드를 꺼냄
            count++; // 방문한 노드 수 증가

            // 현재 노드와 연결된 모든 노드를 확인
            for (int next : graph[current]) {
                // 방문하지 않은 노드만 탐색
                if (!visited[next]) {
                    visited[next] = true; // 방문 처리
                    queue.offer(next); // 큐에 추가
                }
            }
        }

        return count; // 시작 노드에서 방문 가능한 노드 수 반환
    }
}