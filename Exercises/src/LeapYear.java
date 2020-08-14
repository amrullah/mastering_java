public class LeapYear {
    public static void main(String[] args) {
        System.out.println(isLeapYear(100));
        System.out.println(isLeapYear(444));
        System.out.println(isLeapYear(1800));
        System.out.println(isLeapYear(2000));
    }
    public static boolean isLeapYear(int year) {
        /*
        A year which is divisible by 4, but not by hundred unless it is divisible by 400
         */
        boolean isLeapYear = false;
        if (year < 1 || year > 9999) {
            return isLeapYear;
        }

        if (year % 4 == 0) {
            isLeapYear = true;
            if (year % 100 == 0) {
                isLeapYear = year % 400 == 0;
            }
        }

        return isLeapYear;
    }
}
