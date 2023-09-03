package problems.recursion;

public class TowersOfHanoi {

    public static void printMovements(int N, char source, char temp, char dest) {
        if(N == 0) {
            return;
        }
        printMovements(N - 1, source, dest, temp);
        System.out.println("Moving " + N + " disc from " + source + " to " + dest);
        printMovements(N - 1, temp, source, dest);
    }

    public static void main(String[] args) {
        printMovements(3, 'S', 'T', 'D');
    }
}
