package codility.lesson.gcdlcm;

import java.net.SocketTimeoutException;

public class Solution {

    public static int gcd(int a, int b) {
        if (a % b == 0)
            return b;
        return gcd(b, a % b);
    }

    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }


    public static void main(String[] args) {
        int lcm = lcm(32, 100);
        System.out.println(lcm);
        System.out.println(800 /32);
        System.out.println(32 * 25);

    }


}
