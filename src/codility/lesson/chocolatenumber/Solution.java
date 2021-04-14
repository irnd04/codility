package codility.lesson.chocolatenumber;


import java.util.Random;

/*

두 개의 양의 정수 N과 M이 주어집니다.
정수 N은 0에서 N-1까지 번호가 매겨진 원 안에 배열 된 초콜릿의 수를 나타냅니다.

당신은 초콜릿을 먹기 시작합니다. 초콜릿을 먹은 후에는 포장지 만 남깁니다.

0 번 초콜렛을 먹기 시작합니다. 그런 다음 원에있는 다음 M-1 초콜렛 또는 포장지를 생략하고 다음을 먹습니다.

더 정확하게는 초콜릿 숫자 X를 먹었다면 다음에 숫자 (X + M) 모듈로 N (나머지 나눗셈)의 초콜릿을 먹게됩니다.

빈 포장지를 만나면 식사를 중단합니다.

예를 들어, 정수 N = 10 및 M = 4가 주어지면 다음과 같은 초콜릿을 먹게됩니다 : 0, 4, 8, 2, 6.

목표는 위의 규칙에 따라 먹을 초콜릿의 수를 세는 것입니다.

함수 작성 :

class Solution {public int solution (int N, int M); }

두 개의 양의 정수 N과 M이 주어지면 먹을 초콜릿의 수를 반환합니다.

예를 들어, 정수 N = 10 및 M = 4가 주어지면 함수는 위에서 설명한대로 5를 반환해야합니다.

다음 가정에 대한 효율적인 알고리즘을 작성하십시오 .

N 및 M은 [ 1 .. 1,000,000,000 ] 범위 내의 정수 입니다.
저작권 2009–2021 by Codility Limited. 판권 소유. 무단 복사, 게시 또는 공개를 금지합니다.

 */
public class Solution {

    public int solution(int N, int M) {
        return (int) (lcm(N, M) / M);

    }

    public long gcd(long a, long b) {
        if (a % b == 0) return b;
        return gcd(b, a % b);
    }

    public long lcm(long a, long b) {
        return a * (b / gcd(a, b));
    }

    public static void check(int i1, int i2) {
        int solution = o.solution(i1, i2);
        int solution2 = (int) (o.lcm(i1, i2) / i2);

        System.out.println(i1 + ", " + i2 + " = " + solution + "::" + solution2);

        if (solution != solution2) {
            throw new IllegalArgumentException();
        }
    }

    static Solution o = new Solution();
    static Random r = new Random();

    public static void main(String[] args) {

        for (int i = 0; i < 10000; i++) {
            int i1 = r.nextInt(100000) + 1;
            int i2 = r.nextInt(100000) + 1;

            check(i1, i2);
        }

        check(1, 100);
        check(100, 1);
        check(1, 1);

    }


}

