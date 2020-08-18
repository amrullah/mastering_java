public class NumberToWords {
    public static void main(String[] args) {
//        numberToWords(123);
//        numberToWords(456);
//        numberToWords(34);
//        numberToWords(100);
        numberToWords(0);

    }
    public static void numberToWords(int number) {
        if (number < 0) {
            System.out.println("Invalid Value");
            return;
        }
        if (number == 0) {
            System.out.println("Zero");
            return;
        }
        int reversedNumber = reverse(number);
        int zeroesToAppend = getDigitCount(number) - getDigitCount(reversedNumber); // to handle 100 -> 001 properly
        while (reversedNumber > 0) {
            int currentDigit = reversedNumber % 10;

            switch (currentDigit) {
                case 0:
                    System.out.println("Zero"); break;
                case 1:
                    System.out.println("One"); break;
                case 2:
                    System.out.println("Two"); break;
                case 3:
                    System.out.println("Three"); break;
                case 4:
                    System.out.println("Four"); break;
                case 5:
                    System.out.println("Five"); break;
                case 6:
                    System.out.println("Six"); break;
                case 7:
                    System.out.println("Seven"); break;
                case 8:
                    System.out.println("Eight"); break;
                case 9:
                    System.out.println("Nine"); break;
            }

            reversedNumber /= 10;
        }
        for (int i=0; i < zeroesToAppend; i++){
            System.out.println("Zero");
        }
    }

    public static int reverse(int number) {
        boolean numberIsNegative = false;
        if (number < 0) {
            numberIsNegative = true;
            number *= -1;
        }
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

        if (numberIsNegative) {
            reversedNumber *= -1;
        }
        return reversedNumber;
    }

    public static int getDigitCount(int number) {
        if (number < 0) {
            return -1;
        }
        if (number == 0) {
            return 1;
        }
        int digitCount = 0;
        while (number > 0) {
            digitCount += 1;
            number /= 10;
        }
        return digitCount;
    }
}
