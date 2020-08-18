public class FactorPrinter {
    public static void main(String[] args) {
        printFactors(12);
        System.out.println("");

        printFactors(45);
        System.out.println("");

        printFactors(100);
        System.out.println("");

        printFactors(10);
        System.out.println("");
    }
    public static void printFactors(int number) {
        if (number < 1) {
            System.out.println("Invalid Value");
            return;
        }

        for (int counter = 1; counter <= number; counter++){
            if (number % counter == 0) {
                System.out.println(counter);
            }
        }
    }
}
