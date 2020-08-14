public class TeenNumberChecker {
    public static void main(String[] args) {
        System.out.println(hasTeen(10, 23,12));
        System.out.println(hasTeen(15, 33,12));
    }
    public static boolean hasTeen(int firstNumber, int secondNumber, int thirdNumber) {
        return isTeen(firstNumber) || isTeen(secondNumber) || isTeen(thirdNumber);
    }
    private static boolean isTeen(int number) {
        return number >= 13 && number <= 19;
    }
}