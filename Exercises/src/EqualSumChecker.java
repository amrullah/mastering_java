public class EqualSumChecker {
    public static void main(String[] args) {
        System.out.println(hasEqualSum(1, 1, 2));
        System.out.println(hasEqualSum(1, 1, 1));
        System.out.println(hasEqualSum(1, -1, 0));
        System.out.println(hasEqualSum(20, -1, 21));
    }
    public static boolean hasEqualSum(int firstNumber, int secondNumber, int thirdNumber){
        return firstNumber + secondNumber == thirdNumber;
    }
}
