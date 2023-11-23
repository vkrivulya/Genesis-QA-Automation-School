package helpers;

import com.github.javafaker.Faker;


public final class FakerHelper {

    private static final String TEST = "Test";

    public static String generateRandomName() {
        return new Faker().name().fullName().concat(" " + TEST);
    }

    public static long generateRandomNumber() {
        return new Faker().number().numberBetween(100000, 9999999);
    }
}
