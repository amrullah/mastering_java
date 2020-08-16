public class PlayingCat {
    public static void main(String[] args) {
        System.out.println(isCatPlaying(true, 44));
        System.out.println(isCatPlaying(true, 22));
        System.out.println(isCatPlaying(false, 37));
        System.out.println(isCatPlaying(false, 30));
    }
    public static boolean isCatPlaying(boolean isSummer, int temperature) {
        int lowerTemperatureLimit = 25;

        int higherTemperatureLimit = 35;
        if (isSummer) {
            higherTemperatureLimit = 45;
        }
        return temperature >= lowerTemperatureLimit && temperature <= higherTemperatureLimit;
    }
}
