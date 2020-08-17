public class Sum3And5 {
    public static void main(String[] args) {
        int sumOfMultiples = 0;  // sum of multiples of 3 and 5
        int multiplesNeeded = 0;
        for (int number=1; number<=1000; number++){
            if (number % 3 == 0 && number % 5 == 0) {
                System.out.printf("Number %1$s is a multiple of 3 an 5\n", number);
                sumOfMultiples += number;
                multiplesNeeded += 1;
            }
            if (multiplesNeeded >= 5) {
                break;
            }
        }
        System.out.printf("The Sum of all the multiples of 3 and 5 is %1$s\n", sumOfMultiples);
    }
}
