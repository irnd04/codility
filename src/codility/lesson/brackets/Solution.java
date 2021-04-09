package codility.lesson.brackets;

import java.util.LinkedList;

/*

N 개의 문자로 구성된 문자열 S 는 다음 조건 중 하나라도 참이면 적절하게 중첩 된 것으로 간주됩니다 .

S는 비어 있습니다.
S는 " (U) "또는 " [U] "또는 " {U} " 형식을 갖습니다. 여기서 U는 적절하게 중첩 된 문자열입니다.
S는 " VW " 형식을 가지며 여기서 V와 W는 적절하게 중첩 된 문자열입니다.
예를 들어, " {[() ()]} " 문자열 은 올바르게 중첩되었지만 " ([) ()] "는 그렇지 않습니다.

함수 작성 :

class Solution {public int solution (String S); }

N 개의 문자로 구성된 문자열 S가 주어지면 S가 적절하게 중첩되면 1을 반환하고 그렇지 않으면 0을 반환합니다.

예를 들어, S = " {[() ()]} "이면 함수는 1을 반환하고 S = " ([) ()] "이면 함수는 위에서 설명한대로 0을 반환해야합니다.

다음 가정에 대한 효율적인 알고리즘을 작성하십시오 .

N은 [ 0 .. 200,000 ] 범위 내의 정수 이고;
문자열 S는 " ( ", " { ", " [ ", " ] ", " } "및 / 또는 " ) " ) 문자로만 구성됩니다 .
저작권 2009–2021 by Codility Limited. 판권 소유. 무단 복사, 게시 또는 공개를 금지합니다.

 */
class Solution {

    public boolean check(char open, char close) {
        if (open == '(' && close == ')') return true;
        if (open == '[' && close == ']') return true;
        if (open == '{' && close == '}') return true;
        return false;
    }

    public int solution(String S) {
        // write your code in Java SE 8
        LinkedList<Character> stack = new LinkedList<>();
        for (char ch : S.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            }
            else if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.isEmpty()) return 0;
                if (!check(stack.pop(), ch)) return 0;
            }
        }
        if (stack.isEmpty()) return 1;
        return 0;
    }

    public static void main(String[] args) {
        int r;
        r = new Solution().solution("{[()()]}");
        System.out.println(r);
        r = new Solution().solution("([)()]");
        System.out.println(r);

    }

}
