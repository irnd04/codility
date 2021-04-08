package codility.lesson.distinct;


/*

함수 작성

class Solution {public int solution (int [] A); }

N 개의 정수로 구성된 배열 A가 주어지면 배열 A의 고유 값 수를 반환합니다.

예를 들어, 다음과 같은 6 개의 요소로 구성된 배열 A가 있습니다.

 A [0] = 2 A [1] = 1 A [2] = 1
 A [3] = 2 A [4] = 3 A [5] = 1
배열 A에는 1, 2 및 3이라는 3 개의 고유 값이 있으므로 함수는 3을 반환해야합니다.

다음 가정에 대한 효율적인 알고리즘을 작성하십시오 .

N은 [ 0 .. 100,000 ] 범위 내의 정수입니다 .
배열 A의 각 요소는 [ −1,000,000 .. 1,000,000 ] 범위 내의 정수 입니다.
저작권 2009–2021 by Codility Limited. 판권 소유. 무단 복사, 게시 또는 공개를 금지합니다.

 */
class Solution {

    int[] check = new int[2000000 + 1];
    int ADD = 1000000;

    public int solution(int[] A) {
        for (int i : A) {
            check[ADD + i] = 1;
        }
        int sum = 0;
        for (int i = 0; i < check.length; i++)
            sum += check[i];
        return sum;
    }
}

