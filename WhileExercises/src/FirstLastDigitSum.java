public class FirstLastDigitSum {
    public static void main(String[] args) {
        printFirstLastDigitSum(222);
        printFirstLastDigitSum(1032);
        printFirstLastDigitSum(987);
        printFirstLastDigitSum(335);
        printFirstLastDigitSum(534);
        printFirstLastDigitSum(4);
        printFirstLastDigitSum(1);
        printFirstLastDigitSum(0);
    }
    public static int sumFirstAndLastDigit(int number) {
        if (number < 0) {
            return -1;
        }
        if (number == 0) {
            return 0;
        }
        int firstDigit = -1; int lastDigit = -1;

        while (number > 0) {
            int currentDigit = number % 10;
            if (firstDigit == -1) {
                firstDigit = currentDigit;
            }
            lastDigit = currentDigit;
            number /= 10;
        }

        return firstDigit + lastDigit;
    }
    public static void printFirstLastDigitSum(int number){
        int sum = sumFirstAndLastDigit(number);
        System.out.printf("Sum of first and last digits of %1$s is %2$s\n", number, sum);
    }
}
