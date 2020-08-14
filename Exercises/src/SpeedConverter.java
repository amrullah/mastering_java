public class SpeedConverter {
    public static void main(String[] args) {
        printConversion(1.5);
        printConversion(10.25);
        printConversion(25.42);
        printConversion(75.114);
        printConversion(-2.0);
    }

    public static long toMilesPerHour(double kilometersPerHour) {
        if (kilometersPerHour < 0) {
            return -1;
        }
        double milesPerHour = kilometersPerHour * 0.621371;
        double k = Math.round(milesPerHour);

        return (long) k;
    }

    public static void printConversion(double kilometersPerHour) {
        long milesPerHour = toMilesPerHour(kilometersPerHour);
        if (milesPerHour == -1) {
            System.out.println("Invalid Value");
        } else {
            System.out.printf("%1$s km/h = %2$s mi/h%n", kilometersPerHour, milesPerHour);
        }
    }
}
