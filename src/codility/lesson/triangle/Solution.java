package codility.lesson.triangle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*

N 개의 정수로 구성된 배열 A가 제공됩니다. 삼중 선 (P, Q, R)은 0 ≤ P <Q <R <N이고 다음과 같은 경우 삼각형입니다 .

A [P] + A [Q]> A [R],
A [Q] + A [R]> A [P],
A [R] + A [P]> A [Q].
예를 들어, 다음과 같은 배열 A를 고려하십시오.

  A [0] = 10 A [1] = 2 A [2] = 5
  A [3] = 1 A [4] = 8 A [5] = 20
삼중 선 (0, 2, 4)은 삼각형입니다.

함수 작성 :

class Solution {public int solution (int [] A); }

N 개의 정수로 구성된 배열 A가 주어지면이 배열에 대한 삼각 삼중 항이 있으면 1을 반환하고 그렇지 않으면 0을 반환합니다.

예를 들어, 다음과 같은 배열 A가 있습니다.

  A [0] = 10 A [1] = 2 A [2] = 5
  A [3] = 1 A [4] = 8 A [5] = 20
위에서 설명한대로 함수는 1을 반환해야합니다. 주어진 배열 A는 다음과 같습니다.

  A [0] = 10 A [1] = 50 A [2] = 5
  A [3] = 1
함수는 0을 반환해야합니다.

다음 가정에 대한 효율적인 알고리즘을 작성하십시오 .

N은 [ 0 .. 100,000 ] 범위 내의 정수입니다 .
배열 A의 각 요소는 [ −2,147,483,648 .. 2,147,483,647 ] 범위 내의 정수 입니다.
저작권 2009–2021 by Codility Limited. 판권 소유. 무단 복사, 게시 또는 공개를 금지합니다.
 */
class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int N = A.length;
        List<Long> li = new ArrayList<>();
        for (int x : A) {
            // if (0 <= x && x < N) {
                li.add((long) x);
            // }
        }
        Collections.sort(li);
        // System.out.println(li);

        if (li.size() < 3) return 0;

        for (int i = 2; i < li.size(); i++) {
            long v = li.get(i);
            long a = li.get(i - 1);
            long b = li.get(i - 2);
            if (a + b > v) {
                // System.out.println(a + " : " + b + " : " + v);
                return 1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int sol = new Solution().solution(new int[] {10, 2, 5, 1, 8, 20});
        System.out.println(sol);
    }

}

