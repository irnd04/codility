package codility.lesson.maxslicesum;

/*


N 개의 정수로 구성된 비어 있지 않은 배열 A가 제공됩니다.
0 ≤ P ≤ Q <N 인 정수 쌍 (P, Q) 을 배열 A의 슬라이스 라고합니다.
슬라이스 의 합 (P, Q)은 A [P] + A [P의 합계입니다. +1] + ... + A [Q].

함수 작성 :

class Solution {public int solution (int [] A); }

N 개의 정수로 구성된 배열 A가 주어지면 A 조각의 최대 합계를 반환합니다.

예를 들어, 다음과 같은 배열 A가 있습니다.

A [0] = 3 A [1] = 2 A [2] = -6
A [3] = 4 A [4] = 0
함수는 다음과 같은 이유로 5를 반환해야합니다.

(3, 4)는 합계가 4 인 A 조각입니다.
(2, 2)는 합이 −6 인 A 조각입니다.
(0, 1)은 합계가 5 인 A 조각입니다.
A의 다른 조각에는 (0, 1)보다 큰 합계가 없습니다.
다음 가정에 대한 효율적인 알고리즘을 작성하십시오 .

N은 [ 1 .. 1,000,000 ] 범위 내의 정수입니다 .
배열 A의 각 요소는 [ -1,000,000 .. 1,000,000 ] 범위 내의 정수입니다 .
결과는 [−2,147,483,648..2,147,483,647] 범위 내의 정수가됩니다.
저작권 2009–2021 by Codility Limited. 판권 소유. 무단 복사, 게시 또는 공개를 금지합니다.

 */

import java.util.Random;

public class Solution {

    public int solution2(int[] A) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            max = Math.max(max, A[i]);
            int v = A[i];
            for (int j = i + 1; j < A.length; j++) {
                v += A[j];
                max = Math.max(max, v);
            }
        }
        return max;
    }

    public int solution(int[] A) {
        // write your code in Java SE 8

        long before = 0;
        long result = 0;
        long max = Integer.MIN_VALUE;

        for (int i = 0; i < A.length; i++) {
            before = Math.max(0, before + A[i]);
            result = Math.max(before, result);
            max = Math.max(A[i], max);
        }

        if (result == 0)
            result = max;

        return (int) result;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Random random = new Random();
        int T = 100;
        while (T --> 0) {
            int[] arr = new int[100];
            for (int i = 0; i < 100; i++) {
                arr[i] = random.nextInt(500000) - (500000 / 2);
            }
            int a = solution.solution(arr);
            int b = solution.solution2(arr);
            System.out.println(a + ", " + b);
            if (a != b) {
                throw new IllegalArgumentException();
            }
        }
    }

}
