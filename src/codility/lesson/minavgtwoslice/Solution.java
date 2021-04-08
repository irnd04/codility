package codility.lesson.minavgtwoslice;

import javax.swing.text.html.MinimalHTMLWriter;

/*

N 개의 정수로 구성된 비어 있지 않은 배열 A가 제공됩니다.
0 ≤ P <Q <N 인 정수 쌍 (P, Q) 을 배열 A 의 슬라이스 라고합니다
( 슬라이스 에 최소한 두 개의 요소가 포함되어 있음).
슬라이스 의 평균 (P, Q)은 A [P] + A [P + 1] + ... + A [Q]의 합을 슬라이스의 길이로 나눈 값입니다.
 정확히 말하면 평균은 (A [P] + A [P + 1] + ... + A [Q]) / (Q − P + 1)입니다.

예를 들어 배열 A는 다음과 같습니다.

    A [0] = 4
    A [1] = 2
    A [2] = 2
    A [3] = 5
    A [4] = 1
    A [5] = 5
    A [6] = 8
다음 예제 조각이 포함되어 있습니다.

평균이 (2 + 2) / 2 = 2 인 슬라이스 (1, 2);
평균이 (5 + 1) / 2 = 3 인 슬라이스 (3, 4);
평균이 (2 + 2 + 5 + 1) / 4 = 2.5 인 슬라이스 (1, 4).
목표는 평균이 최소 인 슬라이스의 시작 위치를 찾는 것입니다.

함수 작성 :

class Solution {public int solution (int [] A); }

N 개의 정수로 구성된 비어 있지 않은 배열 A가 주어진 경우 최소 평균으로 슬라이스의 시작 위치를 반환합니다.
 평균이 최소 인 슬라이스가 둘 이상있는 경우 해당 슬라이스의 가장 작은 시작 위치를 반환해야합니다.

예를 들어, 다음과 같은 배열 A가 있습니다.

    A [0] = 4
    A [1] = 2
    A [2] = 2
    A [3] = 5
    A [4] = 1
    A [5] = 1
    A [6] = 8
함수는 위에서 설명한대로 1을 반환해야합니다.

다음 가정에 대한 효율적인 알고리즘을 작성하십시오 .

N은 [ 2 .. 100,000 ] 범위 내의 정수 이고;
배열 A의 각 요소는 [ −10,000 .. 10,000 ] 범위 내의 정수 입니다.
저작권 2009–2021 by Codility Limited. 판권 소유. 무단 복사, 게시 또는 공개를 금지합니다.

 */
class Solution {

    Data[] memo;

    public static class Data {
        int value;
        int mod;
        int num;
        int sum;
        double d;

        public Data(int sum, int num) {
            this.sum = sum;
            this.num = num;
            this.value = sum / num;
            this.mod = sum % num;
            this.d = sum / (double) num;
        }

        public int compare(Data d) {
            if (this.value > d.value)
                return -1;
            if (this.value < d.value)
                return 1;
            return Integer.compare(d.mod, this.mod);
        }

        public Data add(Data d) {
            int sum_ = this.sum + d.sum;
            int num_= this.num + d.num;
            return new Data(sum_, num_);
        }

        @Override
        public String toString() {
            return "Data{" +
                    "value=" + value +
                    ", mod=" + mod +
                    ", num=" + num +
                    ", sum=" + sum +
                    ", d=" + d +
                    '}';
        }
    }

    public int solution(int[] A) {
        memo = new Data[A.length];

        memo[A.length - 1] = new Data(A[A.length - 1], 1);

        // System.out.println(memo[A.length - 1].toString());

        for (int i = A.length - 2; i >= 0; i--) {
            Data d1 = new Data(A[i], 1);
            Data c1 = d1.add(new Data(A[i + 1], 1));
            Data c2 = d1.add(memo[i + 1]);

            if (c1.compare(c2) < 0) {
                memo[i] = c2;
            } else memo[i] = c1;

            // System.out.println(i + ".. " + memo[i].toString());

        }

        Data min = memo[0];
        int minIdx = 0;

        for (int i = 0; i < A.length; i++) {
            if (memo[i].num == 1) continue;
            if (min.compare(memo[i]) < 0) {
                min = memo[i];
                minIdx = i;
            }
        }

        return minIdx;
    }

    public static void main(String[] args) {
        int solution = new Solution().solution(new int[]{4, 2, 2, 5, 1, 5, 8});
        System.out.println(solution);

        solution = new Solution().solution(new int[]{1, 2, -1, 4, 5});
        System.out.println(solution);

        solution = new Solution().solution(new int[]{100, 500, 1, 700, 5, 9});
        System.out.println(solution);
        // 4 2 2 5 1 5 8

    }

}


