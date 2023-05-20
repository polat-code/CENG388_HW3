package utils;

import java.util.Random;

public class RandomUtil {


    public static int createRandomNumberOfDownloads(){
        Random rand = new Random();
        return rand.nextInt(1500);
    }
}

