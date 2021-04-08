package codility.lesson.maxproductofthree;


import java.util.Arrays;

/*


N 개의 정수로 구성된 비어 있지 않은 배열 A가 제공됩니다.
삼중 항 (P, Q, R) 의 곱은 A [P] * A [Q] * A [R] (0 ≤ P <Q <R <N)과 같습니다.

예를 들어 배열 A는 다음과 같습니다.

  A [0] = -3
  A [1] = 1
  A [2] = 2
  A [3] = -2
  A [4] = 5
  A [5] = 6
다음과 같은 세 개의 예제를 포함합니다.

(0, 1, 2), 곱은 −3 * 1 * 2 = −6
(1, 2, 4), 제품은 1 * 2 * 5 = 10입니다.
(2, 4, 5), 제품은 2 * 5 * 6 = 60입니다.
당신의 목표는 삼중 항의 최대 곱을 찾는 것입니다.

함수 작성 :

class Solution {public int solution (int [] A); }

비어 있지 않은 배열 A가 주어지면 모든 삼중 항의 최대 곱 값을 반환합니다.

예를 들어, 다음과 같은 배열 A가 있습니다.

  A [0] = -3
  A [1] = 1
  A [2] = 2
  A [3] = -2
  A [4] = 5
  A [5] = 6
삼중 항 (2, 4, 5)의 곱이 최대이므로 함수는 60을 반환해야합니다.

다음 가정에 대한 효율적인 알고리즘을 작성하십시오 .

N은 [ 3 .. 100,000 ] 범위 내의 정수 이고;
배열 A의 각 요소는 [ −1,000 .. 1,000 ] 범위 내의 정수 입니다.
저작권 2009–2021 by Codility Limited. 판권 소유. 무단 복사, 게시 또는 공개를 금지합니다.

 */
class Solution {
    public int solution(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);
        return Math.max(A[A.length - 1] * A[A.length - 2] * A[A.length - 3],
                A[0] * A[1] * A[A.length -1]);
    }

    public static void main(String[] args) {
        int solution = new Solution().solution(new int[]{-100, 0, 1, 2, 3});
        System.out.println(solution);
    }
}

