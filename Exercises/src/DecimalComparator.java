public class DecimalComparator {
    public static void main(String[] args) {
        System.out.println(areEqualByThreeDecimalPlaces(-3.1756, -3.175));
        System.out.println(areEqualByThreeDecimalPlaces(3.175, 3.176));
        System.out.println(areEqualByThreeDecimalPlaces(3.123, -3.123));
        System.out.println(areEqualByThreeDecimalPlaces(3.174, 3.175));

    }
    public static boolean areEqualByThreeDecimalPlaces(double firstNumber, double secondNumber) {
        return Math.abs(firstNumber - secondNumber) <= 0.00099999999;
    }
}
