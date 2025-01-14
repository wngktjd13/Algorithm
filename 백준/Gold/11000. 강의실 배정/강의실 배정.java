import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());

        // 강의 시작 시간과 종료 시간을 저장할 2차원 배열 생성
        int[][] arr = new int[N + 1][2];
        
        for (int i = 1; i <= N; i++) { // 1부터 시작 (arr[0]은 사용 안 함)
            st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken()); // 시작 시간
            arr[i][1] = Integer.parseInt(st.nextToken()); // 종료 시간
        }

        // 강의 정보를 시작 시간 기준 오름차순 정렬
        // Comparator 사용: 시작 시간이 같을 경우 종료 시간 기준으로 추가 정렬
        Arrays.sort(arr, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) // 시작 시간이 같으면 종료 시간 기준 정렬
                    return o1[1] - o2[1];
                return o1[0] - o2[0]; // 시작 시간 기준 정렬
            }
        });

        // 종료 시간 기준으로 정렬된 강의를 관리하는 우선순위 큐 생성
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // 첫 강의의 종료 시간을 큐에 추가
        pq.add(arr[0][1]);

        // 나머지 강의들을 순차적으로 처리
        for (int i = 1; i <= N - 1; i++) {
            // 우선순위 큐의 최상단 요소(가장 빨리 끝나는 강의 종료 시간)와 비교
            if (pq.peek() <= arr[i][0]) // 현재 강의 시작 시간과 비교
                pq.poll(); // 기존 강의실을 비움 (강의 종료)

            // 새로운 강의를 종료 시간 기준으로 큐에 추가
            pq.add(arr[i][1]);
        }

        // 우선순위 큐에 남아 있는 요소의 개수가 필요한 강의실의 개수
        System.out.println(pq.size());
    }
}