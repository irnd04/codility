package codility.lesson.permcheck;

import java.util.ArrayList;
import java.util.List;

/*
N 개의 정수로 구성된 비어 있지 않은 배열 A가 제공됩니다.

순열 번만 회 1에서 N까지 각각의 요소를 포함하는 서열, 및이다.

예를 들어 배열 A는 다음과 같습니다.

    A [0] = 4
    A [1] = 1
    A [2] = 3
    A [3] = 2
순열이지만 배열 A는 다음과 같습니다.

    A [0] = 4
    A [1] = 1
    A [2] = 3
값 2가 없기 때문에 순열이 아닙니다.

목표는 배열 A가 순열인지 확인하는 것입니다.

함수 작성 :

class Solution {public int solution (int [] A); }

배열 A가 주어지면 배열 A가 순열이면 1을 반환하고 그렇지 않으면 0을 반환합니다.

예를 들어, 다음과 같은 배열 A가 있습니다.

    A [0] = 4
    A [1] = 1
    A [2] = 3
    A [3] = 2
함수는 1을 반환해야합니다.

주어진 배열 A는 다음과 같습니다.

    A [0] = 4
    A [1] = 1
    A [2] = 3
함수는 0을 반환해야합니다.

다음 가정에 대한 효율적인 알고리즘을 작성하십시오 .

N은 [ 1 .. 100,000 ] 범위 내의 정수 이고;
배열 A의 각 요소는 [ 1 .. 1,000,000,000 ] 범위 내의 정수 입니다.
저작권 2009–2021 by Codility Limited. 판권 소유. 무단 복사, 게시 또는 공개를 금지합니다.

 */
class Solution {

    boolean check[];

    public int solution(int[] A) {
        // write your code in Java SE 11
        int N = A.length;
        check = new boolean[N + 1];

        for (int i : A) {
            if (!inrange(i, N)) return 0;
            if (check[i]) return 0;
            check[i] = true;
        }

        return 1;
    }

    public boolean inrange(int v, int N) {
        return 1 <= v && v <= N;
    }

    public static int[] convert(List<Integer> li) {
        int[] r = new int[li.size()];
        for (int i = 0; i < li.size(); i++)
            r[i] = li.get(i);
        return r;
    }

    public static void main(String[] args) {
        int solution = new Solution().solution(new int[]{4, 1, 3});
        System.out.println(solution);

        List<Integer> li = new ArrayList<>();
        for (int i = 1; i <= 100000; i++) {
            li.add(i);
        }
        // li.removeIf(x -> x == 100);
        int[] arr = convert(li);

        System.out.println(new Solution().solution(arr));

    }

}
