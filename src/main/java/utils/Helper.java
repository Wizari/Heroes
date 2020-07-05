package utils;

import java.util.concurrent.ThreadLocalRandom;

public class Helper {
    public static int getRandom(int min, int max) {
        int result = ThreadLocalRandom.current().nextInt(min, max + 1);
        return result;
    }

    public static double round(double number, int scale) {
        int pow = 10;
        for (int i = 1; i < scale; i++)
            pow *= 10;
        double tmp = number * pow;
        return (double) (int) ((tmp - (int) tmp) >= 0.5 ? tmp + 1 : tmp) / pow;
    }
}
