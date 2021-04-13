package codility.lesson.numberofdisintersections;

import java.util.Arrays;
import java.util.Comparator;

/*


우리는 비행기에 N 개의 디스크를 그립니다.
디스크는 0에서 N-1까지 번호가 매겨집니다.
디스크의 반경을 지정하는 음이 아닌 정수 N 개의 배열 A가 제공됩니다.
J 번째 디스크는 중심이 (J, 0) 및 반경 A [J]에 그려집니다.

J ≠ K이고 J 번째 및 K 번째 디스크에 하나 이상의 공통점이 있으면 J 번째 디스크와 K 번째 디스크가 교차한다고 말합니다 (디스크에 테두리가 있다고 가정).

아래 그림은 다음과 같이 N = 6 및 A로 그려진 디스크를 보여줍니다.

  A [0] = 1
  A [1] = 5
  A [2] = 2
  A [3] = 1
  A [4] = 4
  A [5] = 0

-4 5
-1 2
0큰 3
0작 1


다음과 같이 교차하는 11 쌍 (순서가없는) 디스크가 있습니다.

디스크 1과 4는 교차하고 둘 다 다른 모든 디스크와 교차합니다.
디스크 2는 디스크 0 및 3 과도 교차합니다.
함수 작성 :

class Solution {public int solution (int [] A); }

위에서 설명한대로 N 개의 디스크를 설명하는 배열 A가 주어지면 교차하는 디스크의 (순서가없는) 쌍의 수를 반환합니다.
교차하는 쌍의 수가 10,000,000을 초과하면 함수는 -1을 반환해야합니다.

위에 표시된 배열 A가 주어지면 함수는 위에서 설명한대로 11을 반환해야합니다.

다음 가정에 대한 효율적인 알고리즘을 작성하십시오 .

N은 [ 0 .. 100,000 ] 범위 내의 정수입니다 .
배열 A의 각 요소는 [ 0 .. 2,147,483,647 ] 범위 내의 정수 입니다.
저작권 2009–2021 by Codility Limited. 판권 소유. 무단 복사, 게시 또는 공개를 금지합니다.

 */
public class Solution {

    Disk[] disksLeft;


    public static class Disk {
        public long left;
        public long right;
        public long r;
        public long pos;

        public Disk() {}

        public Disk(long pos, long r) {
            this.pos = pos;
            this.r = r;
            this.left = pos - r;
            this.right = pos + r;
        }

        @Override
        public String toString() {
            return "Disk{" +
                    "left=" + left +
                    ", right=" + right +
                    ", r=" + r +
                    ", pos=" + pos +
                    '}';
        }
    }

    public static int upperBound(long[] arr, int front, int rear, long key){
        int mid;
        while (front < rear) {
            mid = (front + rear) / 2;
            if(arr[mid] <= key) front = mid + 1;
            else rear = mid;
        }
        return rear;
    }

    public int solution(int[] A) {
        // write your code in Java SE 8
        disksLeft = new Disk[A.length];
        for (int i = 0; i < A.length; i++) {
            disksLeft[i] = new Disk(i, A[i]);
        }


        Arrays.sort(disksLeft, Comparator.comparingLong((Disk a) -> a.left));
        long[] lefts = new long[disksLeft.length];
        for (int i = 0; i < disksLeft.length; i++)
            lefts[i] = disksLeft[i].left;


//        System.out.println("left");
//        for (int i = 0; i < disksLeft.length; i++) {
//            System.out.println(disksLeft[i]);
//        }

        long sum = 0;
        for (int i = 0; i < disksLeft.length; i++) {
            long key = disksLeft[i].right;
            int higher = upperBound(lefts, 0, lefts.length, key);
            long add = (higher - 1 - i);
            // System.out.println("add :: "  + add);
            sum += add;
            if (sum > 10000000) return -1;
//            System.out.println("higher : " + higher);
//            System.out.println("sum : " + sum);
        }

        return (int) sum;

    }

    public static void main(String[] args) {
        new Solution().solution(new int[] {0, 1, 0, 0, 0, 0});
    }


}
