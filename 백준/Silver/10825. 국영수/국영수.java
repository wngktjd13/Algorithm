import java.io.*;
import java.util.*;

public class Main {

    // Student 클래스를 정의 (학생 정보를 저장할 객체)
    static class Student {
        String name;
        int korean, english, math;

        // Student 클래스의 생성자: 객체 생성 시 name, korean, english, math 값을 초기화
        public Student(String name, int korean, int english, int math) {
            this.name = name;
            this.korean = korean;
            this.english = english;
            this.math = math;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        // 힉생 정보를 저장할 동적 배열 생성
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int korean = Integer.parseInt(st.nextToken());
            int english = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            // 생성한 Student 객체를 students 동적 배열에 저장
            students.add(new Student(name, korean, english, math));
        }

        // 람다식을 활용해 정렬
        students.sort((s1, s2) -> {
            if (s1.korean != s2.korean) {
                return s2.korean - s1.korean; // 국어 점수 내림차순 정렬
            } else if (s1.english != s2.english) {
                return s1.english - s2.english; // 영어 점수 오름차순 정렬
            } else if (s1.math != s2.math) {
                return s2.math - s1.math; // 수학 점수 내림차순 정렬
            } else {
                return s1.name.compareTo(s2.name);  // 이름 사전순(대문자 -> 소문자)
            }
        });

        // for-each문
        for(Student student : students){
            System.out.println(student.name);
        }

    }
}
