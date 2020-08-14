public class BarkingDog {
    public static boolean shouldWakeUp(boolean isBarking, int hourOfDay){
        if (hourOfDay < 0 || hourOfDay > 23) {
            return false;
        }
        return (isBarking && (hourOfDay < 8 || hourOfDay > 22));
    }
}
