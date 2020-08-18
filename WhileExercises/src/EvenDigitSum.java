public class EvenDigitSum {
    public static void main(String[] args) {
        System.out.println(getEvenDigitSum(1234));
        System.out.println(getEvenDigitSum(-2345));
        System.out.println(getEvenDigitSum(237984));
        System.out.println(getEvenDigitSum(47854638));
    }
    public static int getEvenDigitSum(int number){
        if (number < 0) {
            return -1;
        }
        int evenDigitSum = 0;
        while (number > 0) {
            int currentDigit = number % 10;
            if (currentDigit % 2 == 0) {
                evenDigitSum += currentDigit;
            }
            number /= 10;
        }

        return evenDigitSum;
    }
}
