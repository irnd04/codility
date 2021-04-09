package codility.lesson.stonewell;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;

/*


돌담을 쌓을 것입니다. 벽은 똑 바르고 길이가
N meters이어야하며 두께는 일정해야합니다.
그러나 다른 장소에서 다른 높이를 가져야합니다.
벽의 높이는 N 개의 양의 정수로 구성된 배열 H로 지정됩니다.
H [I]는 I에서 왼쪽 끝의 I + 1 미터까지 벽의 높이입니다.
특히 H [0]은 벽의 왼쪽 끝 높이이고 H [N-1]은 벽의 오른쪽 끝 높이입니다.

벽은 직육면체 돌 블록 (즉, 이러한 블록의 모든면이 직사각형 임)으로 만들어야합니다.
당신의 임무는 벽을 만드는 데 필요한 최소 블록 수를 계산하는 것입니다.

함수 작성 :

class Solution {public int solution (int [] H); }

벽의 높이를 지정하는 N 개의 양의 정수 배열 H가 주어지면 벽을 만드는 데 필요한 최소 블록 수를 반환합니다.

예를 들어, N = 9 개의 정수를 포함하는 배열 H :

  H [0] = 8 H [1] = 8 H [2] = 5
  H [3] = 7 H [4] = 9 H [5] = 8
  H [6] = 7 H [7] = 4 H [8] = 8
함수는 7을 반환해야합니다. 그림은 7 개 블록의 가능한 배열을 보여줍니다.



다음 가정에 대한 효율적인 알고리즘을 작성하십시오 .

N은 [ 1 .. 100,000 ] 범위 내의 정수 이고;
배열 H의 각 요소는 [ 1 .. 1,000,000,000 ] 범위 내의 정수 입니다.
저작권 2009–2021 by Codility Limited. 판권 소유. 무단 복사, 게시 또는 공개를 금지합니다.

 */
class Solution {

    public int solution(int[] H) {
        // write your code in Java SE 8

        int c = 1;
        LinkedList<Integer> stack = new LinkedList<>();

        HashSet<Integer> set = new HashSet<>();
        set.add(H[0]);
        stack.push(H[0]);

        for (int i = 1; i < H.length; i++) {
            while (true) {
                if (stack.isEmpty()) break;
                int peek = stack.peek();
                if (peek > H[i]) {
                    stack.pop();
                    set.remove(peek);
                } else break;
            }

            if (set.contains(H[i])) {
                stack.push(H[i]);
                set.add(H[i]);
                continue;
            }
            c++;
            stack.push(H[i]);
            set.add(H[i]);
        }

        // System.out.println(c);
        return c;

    }

    public static void main(String[] args) {
        // new Solution().solution(new int[] {8, 8, 5, 7, 9, 8, 7, 4, 8});
        // new Solution().solution(new int[] {4, 10, 11, 1, 6, 10});
        // new Solution().solution(new int[] {1, 2, 3, 3, 2, 1});
        // new Solution().solution(new int[] {1, 2, 3, 3, 2, 1, 3});
        new Solution().solution(new int[] {1,2,1,2,1,2});
        // new Solution().solution(new int[] {5, 4, 3, 2, 1});
        // new Solution().solution(new int[] {5, 5, 5, 3, 5, 5, 5, 5});
        // new Solution().solution(new int[] {3, 4, 5, 5, 4, 3});
        // new Solution().solution(new int[] {5, 4, 3, 3, 4, 5});
        // new Solution().solution(new int[] {3, 7, 3, 7, 1, 7});
        // new Solution().solution(new int[] {1});
        // new Solution().solution(new int[] {1, 2, 3, 4, 5, 6, 7, 8});
        // new Solution().solution(new int[] {4, 3, 2, 1});
        // new Solution().solution(new int[] {5, 3, 5, 2, 5});
        // new Solution().solution(new int[] {5, 5, 5, 5, 6, 6, 6, 6, 6});
        // new Solution().solution(new int[] {6, 6, 6, 6, 6, 5, 5, 5, 5, 2, 2, 2});
        // new Solution().solution(new int[] {10, 7, 10, 7, 10, 2, 7, 10});
        // new Solution().solution(new int[] {1, 21, 41, 61, 81, 61, 41, 21, 1});
        // new Solution().solution(new int[] {20, 200, 400, 600});
        // new Solution().solution(new int[] {1, 2, 100, 88, 77, 55, 89, 2, 1});

    }

}

