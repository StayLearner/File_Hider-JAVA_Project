package service;

import java.util.Random;

public class GenerateOTP {
    public static String getOTP() {
        Random random = new Random();

//   If random.nextInt(10000) generates the number 572, the String.format will convert it to "0572", ensuring it has four digits.
        return String.format("%04d", random.nextInt(10000));
    }
}
