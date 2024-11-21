import java.util.*;

public class Main {

    static int[] parent; // Union-Find에서 부모 노드를 저장하는 배열

    // Union-Find 초기화: 각 노드는 처음에 자기 자신을 부모로 설정
    static void initialize(int n) {
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }
    }

    // find 함수: 특정 노드의 최상위 부모(대표 노드)를 찾음
    // 경로 압축(Path Compression)을 사용해 효율적으로 그룹을 관리
    static int find(int x) {
        if (parent[x] == x) return x; // 자기 자신이 부모라면 대표 노드
        return parent[x] = find(parent[x]); // 경로 압축: 부모를 대표 노드로 갱신
    }

    // union 함수: 두 노드를 같은 그룹으로 묶음
    // 두 노드의 대표 노드를 찾아서 하나로 연결
    static void union(int x, int y) {
        x = find(x); // x의 대표 노드
        y = find(y); // y의 대표 노드
        if (x != y) parent[x] = y; // 두 노드가 다르면 하나로 묶기
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 사람 수
        int m = sc.nextInt(); // 파티 수

        int truthCount = sc.nextInt(); // 진실을 아는 사람의 수
        List<Integer> truth = new ArrayList<>(); // 진실을 아는 사람의 리스트
        for (int i = 0; i < truthCount; i++) {
            truth.add(sc.nextInt()); // 진실을 아는 사람 입력
        }

        List<List<Integer>> parties = new ArrayList<>(); // 각 파티의 참석자 정보
        for (int i = 0; i < m; i++) {
            int partySize = sc.nextInt(); // 파티 참석자 수
            List<Integer> party = new ArrayList<>();
            for (int j = 0; j < partySize; j++) {
                party.add(sc.nextInt()); // 참석자 번호 입력
            }
            parties.add(party);
        }

        // Union-Find 초기화
        initialize(n); // 사람 수만큼 그룹 초기화

        // 같은 파티에 있는 사람들을 같은 그룹으로 묶기
        // 파티에 참석한 첫 번째 사람과 나머지 사람들을 연결
        for (List<Integer> party : parties) {
            int firstPerson = party.get(0); // 파티의 첫 번째 참석자
            for (int i = 1; i < party.size(); i++) {
                union(firstPerson, party.get(i)); // 같은 파티에 있는 사람을 묶음
            }
        }

        // 진실을 아는 사람들을 하나의 그룹으로 묶기
        // 진실을 아는 모든 사람은 같은 그룹으로 간주
        if (!truth.isEmpty()) { // 진실을 아는 사람이 존재하는 경우
            for (int i = 1; i < truth.size(); i++) {
                union(truth.get(0), truth.get(i)); // 진실을 아는 사람 묶기
            }
        }

        // 진실 그룹의 대표 노드 찾기
        // 진실을 아는 사람이 없다면 truthGroup은 -1로 설정
        int truthGroup = truth.isEmpty() ? -1 : find(truth.get(0));

        // 각 파티에서 거짓말이 가능한지 검사
        int count = 0; // 거짓말이 가능한 파티 수
        for (List<Integer> party : parties) {
            boolean canLie = true; // 해당 파티에서 거짓말이 가능한지
            for (int person : party) {
                if (find(person) == truthGroup) { // 진실 그룹에 속한 사람이 있다면
                    canLie = false; // 거짓말 불가능
                    break; // 더 이상 검사하지 않고 종료
                }
            }
            if (canLie) count++; // 거짓말 가능한 파티라면 카운트 증가
        }
        System.out.println(count); // 거짓말 가능한 파티 수 출력
    }
}
