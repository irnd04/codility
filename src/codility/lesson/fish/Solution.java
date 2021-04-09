package codility.lesson.fish;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*

N 개의 정수로 구성된 두 개의 비어 있지 않은 배열 A와 B가 제공됩니다.
배열 A와 B는 강의 흐름을 따라 하류로 정렬 된 강에있는 N 개의 탐욕스러운 물고기를 나타냅니다.

물고기는 0에서 N-1까지 번호가 매겨집니다.
P와 Q가 두 물고기이고 P <Q이면 물고기 P는 처음에 물고기 Q의 상류에 있습니다.
처음에는 각 물고기가 고유 한 위치를 갖습니다.

물고기 수 P는 A [P]와 B [P]로 표시됩니다. 배열 A는 물고기의 크기를 포함합니다.
모든 요소는 고유합니다.
배열 B는 물고기의 방향을 포함합니다.
0 및 / 또는 1 만 포함합니다.
여기서 :

0은 상류로 흐르는 물고기를 나타내고,
1은 하류로 흐르는 물고기를 나타냅니다.
두 물고기가 반대 방향으로 움직이고 그들 사이에 다른 (살아있는) 물고기가 없다면, 그들은 결국 서로 만날 것입니다.
그러면 한 마리의 물고기 만 살아남을 수 있습니다. 큰 물고기가 작은 물고기를 먹습니다.
보다 정확하게는 P <Q, B [P] = 1, B [Q] = 0 일 때 두 물고기 P와 Q가 서로 만나고 그 사이에 살아있는 물고기가 없다고 말합니다.

만난 후 :

A [P]> A [Q]이면 P는 Q를 먹고 P는 여전히 하류로 흐르고
A [Q]> A [P]이면 Q가 P를 먹고 Q는 여전히 상류로 흐릅니다.
우리는 모든 물고기가 같은 속도로 흐르고 있다고 가정합니다.

즉, 같은 방향으로 움직이는 물고기는 만나지 않습니다.
목표는 살아남을 물고기의 수를 계산하는 것입니다.

예를 들어, 다음과 같은 배열 A와 B를 고려하십시오.

  A [0] = 4 B [0] = 0
  A [1] = 3 B [1] = 1
  A [2] = 2 B [2] = 0
  A [3] = 1 B [3] = 0
  A [4] = 5 B [4] = 0
처음에는 모든 물고기가 살아 있고 1 번 물고기를 제외한 모든 물고기가 상류로 이동하고 있습니다.
 1 번 물고기가 2 번 물고기를 만나 먹은 다음 3 번 물고기를 만나서 먹습니다.
  마지막으로 물고기 번호 4를 만나서 먹습니다.
  나머지 두 물고기 인 숫자 0과 4는 결코 만나지 않아 살아남습니다.

함수 작성 :

class Solution {public int solution (int [] A, int [] B); }

N 개의 정수로 구성된 두 개의 비어 있지 않은 배열 A와 B가 주어지면 살아남을 물고기의 수를 반환합니다.

예를 들어 위에 표시된 배열이 주어지면 함수는 위에서 설명한대로 2를 반환해야합니다.

다음 가정에 대한 효율적인 알고리즘을 작성하십시오 .

N은 [ 1 .. 100,000 ] 범위 내의 정수 이고;
배열 A의 각 요소는 [ 0 .. 1,000,000,000 ] 범위 내의 정수입니다 .
배열 B의 각 요소는 다음 값 중 하나를 가질 수있는 정수입니다. 0, 1;
A의 요소는 모두 구별됩니다.
저작권 2009–2021 by Codility Limited. 판권 소유. 무단 복사, 게시 또는 공개를 금지합니다.

 */
class Solution {

    public static class Data {
        int v;
        int d;

        public Data(int v, int d) {
            this.v = v;
            this.d = d;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "v=" + v +
                    ", d=" + d +
                    '}';
        }
    }

    public void print(Object o) {
        System.out.println(o);
    }

    public int solution(int[] A, int[] B) {
        // write your code in Java SE 8
        LinkedList<Data> stack = new LinkedList<>();

        stack.push(new Data(A[0], B[0]));

        for (int i = 1; i < A.length; i++) {
            // System.out.println(stack);
            if (stack.isEmpty()) break;
            Data before = stack.peek();
            Data cur = new Data(A[i], B[i]);
            // fight
            if (before.d == 1 && cur.d == 0) {
                if (before.v < cur.v) {
                    stack.pop();
                    while (true) {
                        if (stack.isEmpty()) {
                            stack.push(cur);
                            break;
                        }
                        before = stack.peek();
                        if (before.d != 1) {
                            stack.push(cur);
                            break;
                        }
                        if (before.v < cur.v)
                            stack.pop();
                        else {
                            break;
                        }
                    }
                }
            } else // nofight
                stack.push(cur);

        }

        // System.out.println(stack);

        return stack.size();
    }

    public static void main(String[] args) {

        int[] A = new int[] {1, 1000, 3, 4, 99, 6, 7, 100, 9, 50000};
        int[] B = new int[] {0, 1,    0, 0, 1, 1, 0, 1, 0, 0};
        int sol = new Solution().solution(A, B);
        System.out.println(sol);

//        A [0] = 4 B [0] = 0
//        A [1] = 3 B [1] = 1
//        A [2] = 5 B [2] = 1
//        A [3] = 2 B [3] = 0
//        A [4] = 1 B [4] = 0
//        A [5] = 5 B [5] = 0


    }
}
