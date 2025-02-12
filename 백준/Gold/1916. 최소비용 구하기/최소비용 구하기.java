import java.io.*;
import java.util.*;

class Node implements Comparable<Node> { // 우선순위 큐에서 비용 기준 정렬
    int v, cost;
    Node(int v, int cost) {
        this.v = v;
        this.cost = cost;
    }
    public int compareTo(Node o) { // 비용이 작은 순으로 정렬
        return this.cost - o.cost;
    }
}

public class Main {
    static final int INF = Integer.MAX_VALUE;
    static List<List<Node>> graph = new ArrayList<>();
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 도시 개수
        int M = Integer.parseInt(br.readLine()); // 버스 개수

        dist = new int[N + 1]; // 최소 비용 저장 배열
        Arrays.fill(dist, INF); // 초기값을 무한대로 설정
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>()); // 인접 리스트 초기화

        for (int i = 0; i < M; i++) { // 그래프 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Node(v, cost)); // 단방향 그래프
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken()); // 출발 도시
        int end = Integer.parseInt(st.nextToken()); // 도착 도시

        System.out.println(dijkstra(start, end)); // 다익스트라 실행 후 결과 출력
    }

    static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>(); // 최소 비용 기준 우선순위 큐
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll(); // 현재 최소 비용 노드 꺼내기
            if (now.v == end) return now.cost; // 도착지 도달 시 즉시 종료
            if (now.cost > dist[now.v]) continue; // 이미 최솟값이 갱신된 경우 무시

            for (Node next : graph.get(now.v)) { // 현재 노드와 연결된 노드 탐색
                int newCost = now.cost + next.cost;
                if (newCost < dist[next.v]) { // 더 적은 비용으로 갈 수 있으면 갱신
                    dist[next.v] = newCost;
                    pq.add(new Node(next.v, newCost));
                }
            }
        }
        return dist[end];
    }
}