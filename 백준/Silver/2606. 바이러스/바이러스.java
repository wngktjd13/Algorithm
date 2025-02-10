import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;
    static int[][] graph;
    static int count = 0;
    static int node, line;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        node = Integer.parseInt(br.readLine());  // 컴퓨터 수
        line = Integer.parseInt(br.readLine());  // 연결된 쌍 개수
        
        graph = new int[node + 1][node + 1];  // 인접 행렬
        visited = new boolean[node + 1];  // 방문 여부

        // 그래프 입력 받기
        for (int i = 0; i < line; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = graph[b][a] = 1;  // 양방향 연결
        }

        System.out.println(bfs(1));  // 1번 컴퓨터에서 시작
    }

    public static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        int count = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();  // 현재 컴퓨터 꺼내기

            for (int i = 1; i <= node; i++) {  // 모든 컴퓨터 확인
                if (graph[cur][i] == 1 && !visited[i]) {  // 연결되어 있고, 방문 안 했으면
                    queue.add(i);
                    visited[i] = true;
                    count++;  // 감염된 컴퓨터 수 증가
                }
            }
        }
        return count;
    }
}