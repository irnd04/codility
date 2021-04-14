package codility.lesson.naf;

/*

N 개의 정수로 구성된 두 개의 비어 있지 않은 배열 A와 B가 제공됩니다.
이 배열은 N 개의 판자를 나타냅니다. 보다 정확하게는 A [K]는 K 번째 플랭크의 시작이고 B [K]는 끝입니다.

다음으로 M 개의 정수로 구성된 비어 있지 않은 배열 C가 제공됩니다.
이 배열은 M 개의 못을 나타냅니다. 좀 더 정확하게 말하면 C [I]는 I-th 못을 쳐서 치는 위치입니다.

A [K] ≤ C [I] ≤ B [K]와 같은 못 C [I]가 있으면 판자 (A [K], B [K])를 못 박는다고합니다.

목표는 모든 판자가 못 박힐 때까지 사용해야하는 최소 못 수를 찾는 것입니다.
즉, 첫 번째 J 못만 사용한 후 모든 판자가 못 박히도 록 J 값을 찾아야합니다.
보다 정확하게는 0 ≤ K <N 인 모든 판자 (A [K], B [K])에 대해 I <J 및 A [K] ≤ C [I] ≤ B [K]인 못 C [I]가 있어야합니다.

예를 들어 다음과 같은 배열 A, B가 있습니다.

    A [0] = 1 B [0] = 4
    A [1] = 4 B [1] = 5
    A [2] = 5 B [2] = 9
    A [3] = 8 B [3] = 10
네 개의 판자가 표시됩니다 : [1, 4], [4, 5], [5, 9] 및 [8, 10].

주어진 배열 C는 다음과 같습니다.

    C [0] = 4
    C [1] = 6
    C [2] = 7
    C [3] = 10
    C [4] = 2
다음 손톱을 사용하는 경우 :

0이면 널빤지 [1, 4]와 [4, 5] 모두 못을 박습니다.
0, 1, 판자 [1, 4], [4, 5] 및 [5, 9]가 못 박히게됩니다.
0, 1, 2, 판자 [1, 4], [4, 5] 및 [5, 9]가 못 박히게됩니다.
0, 1, 2, 3, 그러면 모든 판자가 못 박히게됩니다.
따라서 4 개는 순차적으로 사용되어 모든 판자를 못 박을 수있는 최소 못 수입니다.

함수 작성 :

class Solution {public int solution (int [] A, int [] B, int [] C); }

N 개의 정수로 구성된 비어 있지 않은 배열 A와 B와 M 개의 정수로 구성된 비어 있지 않은 배열
C가 주어지면 순차적으로 사용되어 모든 판자를 못 박을 수있는 최소 못 수를 반환합니다.

모든 판자를 못 박을 수없는 경우 함수는 −1을 반환해야합니다.

예를 들어 다음과 같은 배열 A, B, C가 있습니다.

    A [0] = 1 B [0] = 4
    A [1] = 4 B [1] = 5
    A [2] = 5 B [2] = 9
    A [3] = 8 B [3] = 10

    C [0] = 4
    C [1] = 6
    C [2] = 7
    C [3] = 10
    C [4] = 2
위에서 설명한대로 함수는 4를 반환해야합니다.

다음 가정에 대한 효율적인 알고리즘을 작성하십시오 .

N과 M의 범위 이내 [정수 1 .. 30000 ];
배열 A, B, C의 각 요소는 [ 1 .. 2 * M ] 범위 내의 정수입니다 .
A [K] ≤ B [K].
저작권 2009–2021 by Codility Limited. 판권 소유. 무단 복사, 게시 또는 공개를 금지합니다.

 */


import javax.sound.midi.Soundbank;
import java.util.*;

public class Solution {

    int result = -9;

    public static class Data {
        public int start;
        public int end;

        @Override
        public String toString() {
            return "Data{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }

        public Data(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    ArrayList<Data> datas = new ArrayList<>();
    int[] C;

    public boolean check(Data data, int x) {
        return data.start <= x && x <= data.end;
    }

    public boolean allCheck(int e) {

        long start = System.currentTimeMillis();

        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i <= e; i++)
            q.offer(C[i]);

        int cur = q.poll();
        boolean success = true;
        for (Data data : datas) {
            while (true) {
                if (check(data, cur)) break;
                if (q.isEmpty()) {
                    success = false;
                    break;
                }
                cur = q.poll();
            }
            if (!success) break;
        }

        // System.out.println("allcheck : " + (System.currentTimeMillis() - start));

        return success;
    }

    public int search(int s, int e) {
        if (s > e) return -1;
        int mid = (s + e) / 2;
        if (allCheck(mid)) {
            result = mid;
            return search(s, mid -1);
        } else {
            result = mid;
            return search(mid + 1, e);
        }
    }

    public int getResult() {
        List<Integer> integers = Arrays.asList(result - 1, result, result + 1);
        for (int i : integers) {
            if (0 <= i && i <= C.length -1) {
                if (allCheck(i)) return i;
            }
        }
        return -1;
    }

    public int solution2() {
        for (int i = 0; i < C.length; i++) {
            if (allCheck(i))
                return i + 1;
        }
        return -1;
    }

    public int solution(int[] A, int[] B, int[] C) {
        // write your code in Java SE 8
        this.C = C;
        for (int i = 0; i < A.length; i++) {
            datas.add(new Data(A[i], B[i]));
        }

        Collections.sort(datas, (a, b) -> {
            if (a.start == b.start)
                return a.end - b.end;
            return a.start - b.start;
        });

//        for (int i = 0; i < C.length; i++) {
//            System.out.println(i + ", " + allCheck(i));
//        }

        search(0, C.length -1);

        int r = getResult();
        return r == -1 ? -1 : r + 1;

    }

    public static void main(String[] args) {

        Random random = new Random();

        int[] A = new int[30000];
        int[] B = new int[30000];
        int[] C = new int[30000];

        Scanner sc = new Scanner(System.in);

        while (true) {
            for (int i = 0; i < A.length; i++) {
                A[i] = 1;
                B[i] = 1;
            }

            for (int i = 0; i < C.length; i++) {
                C[i] = 100;
            }

            Solution sol = new Solution();
            long ss = System.currentTimeMillis();
            int a = sol.solution(A, B, C);
//            int b = sol.solution2();
//            System.out.println(a + ", " + b + " = " + (a == b));
//            if (a != b)
//                throw new IllegalArgumentException();
//            System.out.println("111");
            System.out.println(System.currentTimeMillis() - ss);
            sc.nextLine();

        }



    }

}
