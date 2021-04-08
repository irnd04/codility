package codility.lesson.missinginteger;


import jdk.dynalink.linker.ConversionComparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*

이것은 데모 작업입니다.

함수 작성 :

class Solution {public int solution (int [] A); }

N 개의 정수 배열 A가 주어지면 A에서 발생하지 않는 가장 작은 양의 정수 (0보다 큼)를 반환합니다.

예를 들어 A = [1, 3, 6, 4, 1, 2]가 주어지면 함수는 5를 반환해야합니다.

A = [1, 2, 3]이 주어지면 함수는 4를 반환해야합니다.

A = [−1, −3]이 주어지면 함수는 1을 반환해야합니다.

다음 가정에 대한 효율적인 알고리즘을 작성하십시오 .

N은 [ 1 .. 100,000 ] 범위 내의 정수 이고;
배열 A의 각 요소는 [ −1,000,000 .. 1,000,000 ] 범위 내의 정수 입니다.
저작권 2009–2021 by Codility Limited. 판권 소유. 무단 복사, 게시 또는 공개를 금지합니다.

 */
class Solution {

    int limit = 1000000;
    int[] arr = new int[limit + 1];

    public int solution(int[] A) {

        for (int i : A) {
            if (i <= 0) continue;
            arr[i] = 1;
        }

        for (int i = 1; i <= limit; i++) {
            if (arr[i] == 0) return i;
        }

        return -1;
    }

    public static int[] convert(List<Integer> arr) {
        int[] r = new int[arr.size()];
        for (int i = 0; i < arr.size(); i++)
            r[i] = arr.get(i);
        return r;
    }

    public static void main(String[] args) {
        int solution = new Solution().solution(new int[]{1, 3, 6, 4, 1, 2});
        System.out.println(solution);

        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < 300; i++) {
            arr.add(i - 100);
        }

        arr.removeIf(x -> x == -100);

        int[] convert = convert(arr);
        System.out.println(Arrays.toString(convert));

        solution = new Solution().solution(convert);
        System.out.println(solution);

    }
}
