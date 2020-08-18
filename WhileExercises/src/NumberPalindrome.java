public class NumberPalindrome {
    public static void main(String[] args) {
        printIsPalindrome(100);
        printIsPalindrome(12321);
        printIsPalindrome(-1001);
        printIsPalindrome(11221);
        printIsPalindrome(0);
    }
    public static boolean isPalindrome(int number) {
        if (number < 0) {
            number *= -1;
        }
        int originalNumber = number;
        int reversedNumber = 0; boolean shouldMultiplyBy10 = false;
        while (number > 0) {
            int lastDigit = number % 10;
            if (shouldMultiplyBy10) {
                reversedNumber *= 10;
            } else {
                shouldMultiplyBy10 = true;
            }
            reversedNumber += lastDigit;
            number /= 10;  // to discard the least significant digit
        }

        return reversedNumber == originalNumber;
    }
    public static void printIsPalindrome(int number) {
        boolean isPalindrome = isPalindrome(number);
        if (isPalindrome)
            System.out.printf("Number %1$s is palindrome\n", number);
        else {
            System.out.printf("Number %1$s is not palindrome\n", number);
        }
    }
}
