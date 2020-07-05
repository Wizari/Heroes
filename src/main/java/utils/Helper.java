package utils;

import java.util.concurrent.ThreadLocalRandom;

public class Helper {
    public static int getRandom(int min, int max) {
        int result = ThreadLocalRandom.current().nextInt(min, max + 1);
        return result;
    }
}
