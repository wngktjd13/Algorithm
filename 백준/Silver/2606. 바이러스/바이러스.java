import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;
    static int[][] graph;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int node = Integer.parseInt(br.readLine());  // 컴퓨터 개수
        int line = Integer.parseInt(br.readLine());  // 연결된 쌍 개수
        
        // 배열 선언
        graph = new int[node + 1][node + 1];  // 인접 행렬
        visited = new boolean[node + 1];  // 방문 체크 배열
        
        // 그래프 입력 받기
        for (int i = 0; i < line; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = graph[b][a] = 1;  // 양방향 연결
        }

        System.out.println(bfs(1, node));  // 1번 컴퓨터에서 시작
    }

    public static int bfs(int start, int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        int count = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();  // 현재 감염된 컴퓨터 꺼내기

            // 모든 컴퓨터 확인
            for (int i = 1; i < graph[cur].length; i++) {  
                if (graph[cur][i] == 1 && !visited[i]) {  // 연결 & 미방문 체크
                    queue.add(i);
                    visited[i] = true;
                    count++;  // 감염된 컴퓨터 수 증가
                }
            }
        }
        return count;
    }
}
