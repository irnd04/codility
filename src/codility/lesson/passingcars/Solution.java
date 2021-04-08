package codility.lesson.passingcars;


/*

N 개의 정수로 구성된 비어 있지 않은 배열 A가 제공됩니다. 배열 A의 연속 요소는 도로의 연속 자동차를 나타냅니다.

배열 A에는 0 및 / 또는 1 만 포함됩니다.

0은 동쪽으로 이동하는 자동차를 나타냅니다.
1은 서쪽으로 이동하는 자동차를 나타냅니다.
목표는 지나가는 차를 세는 것입니다. 0 ≤ P <Q <N 인 한 쌍의 자동차 (P, Q)는 P가 동쪽으로 이동하고 Q가 서쪽으로 이동할 때 지나가고 있다고 말합니다.

예를 들어, 다음과 같은 배열 A를 고려하십시오.

  A [0] = 0
  A [1] = 1
  A [2] = 0
  A [3] = 1
  A [4] = 1
(0, 1), (0, 3), (0, 4), (2, 3), (2, 4)의 5 쌍의 추월 차가 있습니다.

함수 작성 :

class Solution {public int solution (int [] A); }

N 개의 정수로 구성된 비어 있지 않은 배열 A가 주어지면 지나가는 자동차 쌍의 수를 반환합니다.

지나가는 자동차 쌍의 수가 1,000,000,000을 초과하면 함수는 −1을 반환해야합니다.

예를 들면 다음과 같습니다.

  A [0] = 0
  A [1] = 1
  A [2] = 0
  A [3] = 1
  A [4] = 1
함수는 위에서 설명한대로 5를 반환해야합니다.

다음 가정에 대한 효율적인 알고리즘을 작성하십시오 .

N은 [ 1 .. 100,000 ] 범위 내의 정수 이고;
배열 A의 각 요소는 0, 1 값 중 하나를 가질 수있는 정수입니다.
저작권 2009–2021 by Codility Limited. 판권 소유. 무단 복사, 게시 또는 공개를 금지합니다.

 */
class Solution {

    int limit = 1_000_000_000;
    long[] mem;

    public int solution(int[] A) {
        mem = new long[A.length];

        long r = 0;

        mem[A.length - 1] += A[A.length - 1];

        for (int i = A.length - 2; i >= 0; i--) {
            mem[i] += mem[i + 1];
            mem[i] += A[i];

            if (A[i] == 0) {
                r += mem[i];
                if (r > limit) return -1;
            }

        }

        return (int) r;
    }

    public static void main(String[] args) {
        int solution = new Solution().solution(new int[]{1, 1, 1, 1, 1, 0});
        System.out.println(solution);
    }
}
