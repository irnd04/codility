package codility.lesson.countdiv;
/*

함수 작성 :

class Solution {public int solution (int A, int B, int K); }

세 개의 정수 A, B 및 K가 주어지면 K로 나눌 수있는 [A..B] 범위 내의 정수 수를 반환합니다. 즉,

{i : A ≤ i ≤ B, i  mod  K = 0}

예를 들어, A = 6, B = 11 및 K = 2의 경우 [6..11] 범위 내에서 2로 나눌 수있는 세 개의 숫자, 즉 6, 8 및 10이 있으므로 함수는 3을 반환해야합니다.

다음 가정에 대한 효율적인 알고리즘을 작성하십시오 .

A와 B는 [ 0 .. 2,000,000,000 ] 범위 내의 정수입니다 .
K는 [ 1 .. 2,000,000,000 ] 범위 내의 정수입니다 .
A ≤ B.
저작권 2009–2021 by Codility Limited. 판권 소유. 무단 복사, 게시 또는 공개를 금지합니다.

https://tram-devlog.tistory.com/entry/Codility-51-CountDiv
못풀었음

 */
class Solution {

    public int solution2(int A, int B, int K) {
        // write your code in Java SE 8

        int r = 0;
        for (int i = A; i <= B; i++) {
            if (i % K == 0) r++;
        }

        return r;
    }

    public int solution(int A, int B, int K) {
        int AK = A / K;
        int BK = B / K;
        return BK - AK + (A % K == 0 ? 1 : 0);
    }

    public static void main(String[] args) {
        int A = 123;
        int B = 548752;
        int K = 2;
        int i = new Solution().solution2(A, B, K);

        int AK = A / K;
        int BK = B / K;

        System.out.println(String.format("%s / %s = %s", B, K, BK));
        System.out.println(String.format("%s / %s = %s", A, K, AK));
        System.out.println("BK - AK = " + (BK - AK));
        System.out.println(A % K == 0 ? 1 : 0);

        System.out.println("reuslt : " + i);
    }
}
