package codility.lesson.binarysearch;

public class MySolution {

    static int result = 0;

    public static int search(int[] arr, int s, int e, int x) {
        if (s > e) return -1;
        int mid = (s + e) / 2;
        if (arr[mid] >= x) {
            result = mid;
            return search(arr, s, mid - 1, x);
        }
        else {
            result = mid;
            return search(arr, mid + 1, e, x);
        }

    }

    public static void main(String[] args) {
        int[] ints = {1, 3, 5, 7, 9, 10};
        int search = search(ints, 0, ints.length - 1, -1);
        System.out.println(search);
        System.out.println(result);
        System.out.println(search + ", " + ints[search]);
    }

}
