package codility.lesson.stonwell2;

import java.util.LinkedList;

public class Solution {

    public int solution(int[] H) {
        // write your code in Java SE 8

        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(H[0]);
        int r = 1;

        for (int i = 1; i < H.length; i++) {
            int v = H[i];
            if (stack.isEmpty()) {
                stack.push(v);
                r++;
                continue;
            }
            int b = stack.peek();

            if (b == v) continue;

            if (b < v) {
                stack.push(v);
                r++;
                continue;
            }
            while (true) {
                if (stack.isEmpty()) {
                    r++;
                    stack.push(v);
                    break;
                }
                b = stack.peek();
                if (b > v) {
                    stack.pop();
                    continue;
                }

                if (b < v) {
                    stack.push(v);
                    r++;
                }
                break;
            }

        }

        System.out.println(r);
        System.out.println(stack);
        return 0;
    }

    public static void main(String[] args) {
        new Solution().solution(new int[] {8, 8, 5, 7, 9, 8, 7, 4, 8}); // 7
        // new Solution().solution(new int[] {4, 10, 11, 1, 6, 10});
        // new Solution().solution(new int[] {1, 2, 3, 3, 2, 1});
        // new Solution().solution(new int[] {1, 2, 3, 3, 2, 1, 3});
        // new Solution().solution(new int[] {1,2,1,2,1,2});
        // new Solution().solution(new int[] {5, 4, 3, 2, 1}); 5
        // new Solution().solution(new int[] {5, 5, 5, 3, 5, 5, 5, 5}); // 3
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
