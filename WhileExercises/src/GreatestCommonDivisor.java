public class GreatestCommonDivisor {
    public static void main(String[] args) {
        System.out.println(getGreatestCommonDivisor(25, 15));
        System.out.println(getGreatestCommonDivisor(12, 30));
        System.out.println(getGreatestCommonDivisor(9, 18));
        System.out.println(getGreatestCommonDivisor(81, 153));
    }
    public static int getGreatestCommonDivisor(int firstNumber, int secondNumber) {
        if (firstNumber < 10 || secondNumber < 10) {
            return -1;
        }

        int numberToIterate = -1;

        numberToIterate = Math.min(firstNumber, secondNumber);

        int gcd = 0;

        for (int i=1; i <= numberToIterate; i++) {
            if (firstNumber % i == 0 && secondNumber % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }
}
