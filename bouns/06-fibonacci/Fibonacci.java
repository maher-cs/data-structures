public class Fibonacci {

    public static int fibR(int n) {
        if(n <= 1) {
            return 0;
        }
        if(n == 2) {
            return 1;
        }
        return fibR(n - 1) + fibR(n - 2);
    }

    public static int fibN(int n) {
        int first = 0;
        int second = 1;
        int result = 0;
        for(int i = 2; i < n; i++) {
            result = first + second;
            first = second;
            second = result;
        }
        return result;
    }

    public static void main(String[] args) {
        int n = 1000;
        System.out.println("recursion: " + fibR(n));
        System.out.println("non-recursion: " + fibN(n));
    }
}