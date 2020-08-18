public class PerfectNumber {
    public static void main(String[] args) {
        System.out.println(isPerfectNumber(6));
        System.out.println(isPerfectNumber(28));
        System.out.println(isPerfectNumber(5));
        System.out.println(isPerfectNumber(-1));
    }
    public static boolean isPerfectNumber(int number) {
        if (number < 1) {
            return false;
        }

        int sumOfFactors = 0;
        for (int counter = 1; counter < number; counter++){
            if (number % counter == 0) {
                sumOfFactors += counter;
            }
        }
        return sumOfFactors == number;
    }
}
