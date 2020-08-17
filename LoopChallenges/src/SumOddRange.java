public class SumOddRange {
    public static void main(String... args){
        System.out.println(sumOdd(10, 20));
    }
    public static int sumOdd(int start, int end) {
        if (!isStartEndValid(start, end)) {
            return -1;
        }

        int sumOfOdd = 0;
        for (int i=start;i<=end;i++) {
            if (isOdd(i)) {
                System.out.println(i);
                sumOfOdd += i;
            }
        }
        return sumOfOdd;
    }

    public static boolean isOdd(int number) {
        return (number > 0) && (number % 2 != 0);
    }

    private static boolean isStartEndValid(int start, int end) {
        return start > 0 && end > 0 && end >= start;
    }
}
