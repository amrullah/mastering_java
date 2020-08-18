public class SharedDigit {
    public static void main(String[] args) {
        System.out.println(hasSharedDigit(12, 23));
        System.out.println(hasSharedDigit(35, 52));
        System.out.println(hasSharedDigit(35, 66));
        System.out.println(hasSharedDigit(8, 345));
        System.out.println(hasSharedDigit(123, 92));
    }
    public  static boolean hasSharedDigit(int firstNumber, int secondNumber) {
        if (!isInRange(firstNumber) || !isInRange(secondNumber)) {
            return false;
        }

        int originalSecondNumber = secondNumber;

        while (firstNumber > 0 ){
            int outerCurrentDigit = firstNumber % 10;

            secondNumber = originalSecondNumber;
            while (secondNumber > 0){
                int innerCurrentDigit = secondNumber % 10;
                if (innerCurrentDigit == outerCurrentDigit) {
                    return true;
                }
                secondNumber /= 10;
            }

            firstNumber /= 10;
        }
        return false;
    }

    private static boolean isInRange(int number) {
        return number >= 10 && number <= 99;
    }
}
