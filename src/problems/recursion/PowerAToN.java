package problems.recursion;

public class PowerAToN {

    public static int aToThePwerN(int A, int N) {
        if(N == 0) {
            return 1;
        }
        if(N % 2 == 0) {
            return aToThePwerN(A, N/2) * aToThePwerN(A, N/2);
        }
        return A * aToThePwerN(A, N/2) * aToThePwerN(A, N/2);
    }

    public static void main(String[] args) {
        System.out.println(aToThePwerN(4, 4));
    }
}
