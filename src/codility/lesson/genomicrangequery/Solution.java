package codility.lesson.genomicrangequery;

/*
DNA 서열은 문자 A , C , G 및 T 로 구성된 문자열로 표현 될 수 있으며 , 이는 서열의 연속 뉴클레오티드 유형에 해당합니다.
 각 뉴클레오티드에는 정수인 영향 계수 가 있습니다. 유형 A , C , G 및 T의 뉴클레오티드는 각각 1, 2, 3 및 4의 영향 계수를 갖습니다.
 다음과 같은 형식의 몇 가지 질문에 답할 것입니다. 주어진 DNA 서열의 특정 부분에 포함 된 뉴클레오티드의 최소 영향 계수는 무엇입니까?

DNA 시퀀스는 N 개의 문자로 구성된 비어 있지 않은 문자열 S = S [0] S [1] ... S [N-1] 로 제공됩니다.
비어 있지 않은 배열 P 및 Q에 주어진 M 쿼리가 있으며 각각 M 개의 정수로 구성됩니다. K 번째 쿼리 (0 ≤ K <M)에서는
위치 P [K]와 Q [K] (포함) 사이의 DNA 시퀀스에 포함 된 뉴클레오티드의 최소 영향 계수를 찾아야합니다.

예를 들어, 문자열 S = CAGCCTA 및 배열 P, Q를 다음과 같이 고려하십시오 .

    P [0] = 2 Q [0] = 4
    P [1] = 5 Q [1] = 5
    P [2] = 0 Q [2] = 6
이러한 M = 3 쿼리에 대한 답변은 다음과 같습니다.

위치 2와 4 사이의 DNA 부분에는 영향 계수가 각각 3과 2 인 뉴클레오티드 G 와 C (두 번) 가 포함되어 있으므로 답은 2입니다.
위치 5와 5 사이의 부분에는 영향 계수가 4 인 단일 뉴클레오티드 T 가 포함되어 있으므로 답은 4입니다.
위치 0과 6 사이의 부분 (전체 문자열)에는 모든 뉴클레오티드, 특히 영향 계수가 1 인 뉴클레오티드 A 가 포함되어 있으므로 답은 1입니다.
함수 작성 :

class Solution {public int [] solution (String S, int [] P, int [] Q); }

N 개의 문자로 구성된 비어 있지 않은 문자열 S와 M 개의 정수로 구성된
두 개의 비어 있지 않은 배열 P와 Q가 주어진 경우 모든 쿼리에 대한 연속적인 응답을 지정하는 M 개의 정수로 구성된 배열을 반환합니다.

결과 배열은 정수 배열로 반환되어야합니다.

예를 들어, 문자열 S = CAGCCTA 및 배열 P, Q가 다음과 같을 때 :

    P [0] = 2 Q [0] = 4
    P [1] = 5 Q [1] = 5
    P [2] = 0 Q [2] = 6
함수는 위에서 설명한대로 [2, 4, 1] 값을 반환해야합니다.

다음 가정에 대한 효율적인 알고리즘을 작성하십시오 .

N은 [ 1 .. 100,000 ] 범위 내의 정수 이고;
M은 [ 1 .. 50,000 ] 범위 내의 정수 이고;
배열 P, Q의 각 요소는 [ 0 .. N-1 ] 범위 내의 정수입니다 .
P [K] ≤ Q [K], 여기서 0 ≤ K <M;
문자열 S는 대문자 영문 A, C, G, T 로만 구성됩니다 .
저작권 2009–2021 by Codility Limited. 판권 소유. 무단 복사, 게시 또는 공개를 금지합니다.

 */

import java.util.Arrays;

public class Solution {

    int[] num;
    int[][] memo = new int[100000][5];

    public int toInt(char c) {
        // 유형 A , C , G 및 T의 뉴클레오티드는 각각 1, 2, 3 및 4의 영향 계수를 갖습니다.
        switch (c) {
            case 'A':
                return 1;
            case 'C':
                return 2;
            case 'G':
                return 3;
            case 'T':
                return 4;
            default:
                throw new RuntimeException();
        }
    }

    public int solve(int s, int e) {

        int[] result = new int[5];
        copy(result, memo[e]);

        if (s > 0) {
            for (int i = 0; i < result.length; i++) {
                result[i] -= memo[s - 1][i];
            }
        }

        for (int i = 1; i <= 4; i++) {
            if (result[i] > 0) return i;
        }

        return -1;
    }

    public void copy(int[] arr1, int[] arr2) {
        System.arraycopy(arr2, 0, arr1, 0, arr2.length);
    }

    public int[] solution(String S, int[] P, int[] Q) {
        // write your code in Java SE 8
        num = new int[S.length()];
        char[] chars = S.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            num[i] = toInt(chars[i]);
        }

        memo[0][num[0]] += 1;

        for (int i = 1; i < num.length; i++) {
            copy(memo[i], memo[i - 1]);
            memo[i][num[i]] += 1;
        }

        int[] rr = new int[Q.length];

        for (int i = 0; i < Q.length; i++) {
            int r = solve(P[i], Q[i]);
            rr[i] = r;
        }

        return rr;
    }

    public static void main(String[] args) {
        // ('CAGCCTA', [2, 5, 0], [4, 5, 6])
        String z = Arrays.toString(new Solution().solution("CAGCCTA", new int[] {2,5,0}, new int[] {4,5,6}));
        System.out.println(z);

        // 2 1 3 2 2 4 1
        //     .   .

    }

}
