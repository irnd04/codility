package codility.lesson.minmaxdivision;

/*

정수 K, M과 N 정수로 구성된 비어 있지 않은 배열 A가 제공됩니다.
배열의 모든 요소는 M보다 크지 않습니다.

이 배열을 K 개의 연속 요소 블록으로 나누어야합니다. 블록의 크기는 0에서 N 사이의 정수입니다.
배열의 모든 요소는 일부 블록에 속해야합니다.

X에서 Y까지의 블록 합계는 A [X] + A [X + 1] + ... + A [Y]와 같습니다.
 빈 블록의 합은 0입니다.

큰 합은 모든 블록의 최대 합이다.

예를 들어, 다음과 같은 정수 K = 3, M = 5 및 배열 A가 제공됩니다.

  A [0] = 2
  A [1] = 1
  A [2] = 5
  A [3] = 1
  A [4] = 2
  A [5] = 2
  A [6] = 2
예를 들어 배열은 다음 블록으로 나눌 수 있습니다.

[2, 1, 5, 1, 2, 2, 2], [], [] (큰 합계 15 포함);
[2], [1, 5, 1, 2], [2, 2] (큰 합계가 9 임);
[2, 1, 5], [], [1, 2, 2, 2] (큰 합계 8);
[2, 1], [5, 1], [2, 2, 2]의 큰 합이 6입니다.
목표는 큰 금액을 최소화하는 것입니다. 위의 예에서 6은 최소 큰 합계입니다.

함수 작성 :

class Solution {public int solution (int K, int M, int [] A); }

주어진 정수 K, M과 N 개의 정수로 구성된 비어 있지 않은 배열 A는 최소 큰 합계를 반환합니다.

예를 들어, K = 3, M = 5 및 다음과 같은 배열 A가 주어집니다.

  A [0] = 2
  A [1] = 1
  A [2] = 5
  A [3] = 1
  A [4] = 2
  A [5] = 2
  A [6] = 2
함수는 위에서 설명한대로 6을 반환해야합니다.

다음 가정에 대한 효율적인 알고리즘을 작성하십시오 .

N 및 K는 [ 1 .. 100,000 ] 범위 내의 정수입니다 .
M은 [ 0 .. 10,000 ] 범위 내의 정수입니다 .
배열 A의 각 요소는 [ 0 .. M ] 범위 내의 정수 입니다.
저작권 2009–2021 by Codility Limited. 판권 소유. 무단 복사, 게시 또는 공개를 금지합니다.

 */

public class Solution {
}