package codility.lesson.maxprofit;

/*

N 개의 정수로 구성된 배열 A가 제공됩니다. 연속 N 일 동안 주식 주식의 일일 가격을 포함합니다.
단일 주식이 P 일에 매수되어 Q 일에 매각 된 경우 (0 ≤ P ≤ Q <N), 이러한 거래 의 이익 은 A [Q] ≥ A [P]인 경우 A [Q] − A [P]와 같습니다.
. 그렇지 않으면 거래는 A [P]-A [Q]의 손실 을 가져옵니다 .

예를 들어 다음과 같은 6 개의 요소로 구성된 다음 배열 A를 고려하십시오.

  A [0] = 23171
  A [1] = 21011
  A [2] = 21123
  A [3] = 21366
  A [4] = 21013
  A [5] = 21367
주식이 0 일에 매수되고 2 일에 매도 된 경우 A [2]-A [0] = 21123-23171 = -2048이므로 2048의 손실이 발생합니다.
 주식이 4 일째에 매수되어 5 일에 매각 된 경우 A [5] − A [4] = 21367 − 21013 = 354이므로 354의 이익이 발생합니다.
  가능한 최대 이익은 356입니다. 주식이 다음과 같으면 발생합니다. 1 일에 구매하고 5 일에 판매되었습니다.

함수 작성,

class Solution {public int solution (int [] A); }

연속 N 일 동안 주식 주식의 일일 가격을 포함하는 N 개의 정수로 구성된 배열 A가 주어진 경우이 기간 동안 한 거래에서 가능한 최대 수익을 반환합니다.
이익을 얻을 수없는 경우 함수는 0을 반환해야합니다.

예를 들어, 다음과 같은 6 개의 요소로 구성된 배열 A가 있습니다.

  A [0] = 23171
  A [1] = 21011
  A [2] = 21123
  A [3] = 21366
  A [4] = 21013
  A [5] = 21367
함수는 위에서 설명한대로 356을 반환해야합니다.

다음 가정에 대한 효율적인 알고리즘을 작성하십시오 .

N은 [ 0 .. 400,000 ] 범위 내의 정수 이고;
배열 A의 각 요소는 [ 0 .. 200,000 ] 범위 내의 정수 입니다.
저작권 2009–2021 by Codility Limited. 판권 소유. 무단 복사, 게시 또는 공개를 금지합니다.

 */

import com.sun.corba.se.impl.orbutil.ObjectStreamClassUtil_1_3;

import java.util.Random;

public class Solution {

    public int real_solution(int[] A) {
        int r = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                r = Math.max(r, A[i] - A[j]);
            }
        }
        return r;
    }

    public int solution(int[] A) {
        // write your code in Java SE 8
        if (A.length == 0) return 0;
        int s = A[0];
        int r = 0;
        for (int i = 1; i < A.length; i++) {
            int v = A[i];
            if (s > v) s = v;
            else {
                r = Math.max(r, v - s);
            }
        }
        return r;
    }

    public static void main(String[] args) {
        int T = 100;
        while (T --> 0) {
            Random random = new Random();
            int[] A = new int[100];
            for (int i = 0; i < 100; i++)
                A[i] = random.nextInt(200001);

            Solution sol = new Solution();
            int a = sol.solution(A);
            int b = sol.real_solution(A);
            System.out.println(a + ", " + b);
            if (a != b)
                throw new IllegalArgumentException();
        }

    }

}
