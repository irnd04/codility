package codility.lesson.maximalslice;

public class Solution {

    public static void main(String[] args) {
        int[] ints = {1, 2, 3, -1, 4};
        int max_ending, max_slice;
        max_ending = max_slice = 0;
        for (int v : ints) {
            max_ending = Math.max(0, max_ending + v);
            max_slice = Math.max(max_slice, max_ending);
        }
        System.out.println(max_slice);
    }

}
