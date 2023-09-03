package problems.dynamicprogramming;

public class MaxHousesToRob {

    private static int[] arr = {10, 100, 20, 10, 100, 20, 10, 5, 100};
    public static int maxHouseToRob(int i, boolean hasBeenRobbed) {
        if(i == arr.length) {
            return 0;
        }

        int robThisHouse = !hasBeenRobbed ? maxHouseToRob(i + 1, true) + arr[i] : maxHouseToRob(i + 1, false);
        int dontRobThisHouse = maxHouseToRob(i + 1, false);


        return Math.max(robThisHouse, dontRobThisHouse);
    }

    public static void main(String[] args) {
        System.out.println(maxHouseToRob(0, false));
    }
}
