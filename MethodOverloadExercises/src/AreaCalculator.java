public class AreaCalculator {
    public static void main(String[] args) {
        double radius = 1;
        System.out.println(area(radius));
        radius = 4.5;
        System.out.println(area(radius));

        double length = 10; double width = 20;
        System.out.println(area(length, width));

        width = 10;
        System.out.println(area(length, width));
    }
    public static double area(double radius) {
        if (radius < 0.0) {
            return -1.0;
        }
        return Math.PI * Math.pow(radius, 2);
    }

    public static double area(double length, double width) {
        if (length < 0.0 || width < 0.0) {
            return -1.0;
        }
        return length * width;
    }
}
