package codility.lesson.nesting;

/*

N 문자로 구성된 문자열 S는 다음과 같은 경우 적절하게 중첩되어 호출 됩니다.

S는 비어 있습니다.
S는 " (U) " 형식을 갖습니다. 여기서 U는 적절하게 중첩 된 문자열입니다.
S는 " VW " 형식을 가지며 여기서 V와 W는 적절하게 중첩 된 문자열입니다.
예를 들어 " (() (()) ()) "문자열은 올바르게 중첩되지만 " ()) "는 그렇지 않습니다.

함수 작성 :

class Solution {public int solution (String S); }

N 개의 문자로 구성된 문자열 S가 주어지면 문자열 S가 적절하게 중첩되면 1을 반환하고 그렇지 않으면 0을 반환합니다.

예를 들어, S = " (() (()) ()) "이면 함수는 1을 반환하고 S = " ()) "이면 함수는 위에서 설명한대로 0을 반환해야합니다.

다음 가정에 대한 효율적인 알고리즘을 작성하십시오 .

N은 [ 0 .. 1,000,000 ] 범위 내의 정수입니다 .
문자열 S는 " ( "및 / 또는 " ) " 문자로만 구성됩니다 .
저작권 2009–2021 by Codility Limited. 판권 소유. 무단 복사, 게시 또는 공개를 금지합니다.

 */
class Solution {

    public int solution(String S) {
        // write your code in Java SE 8
        int open = 0;
        for (char ch : S.toCharArray()) {
            if (ch == '(') open++;
            if (ch == ')') {
                if (open == 0) return 0;
                open--;
            }
        }
        if (open == 0) return 1;
        return 0;
    }

    public static void main(String[] args) {
        String s;
        int sol;
        s = "(()(())())";
        sol = new Solution().solution(s);
        System.out.println(sol);
        s = "())";
        sol = new Solution().solution(s);
        System.out.println(sol);
        s = "(()";
        sol = new Solution().solution(s);
        System.out.println(sol);
    }

}
