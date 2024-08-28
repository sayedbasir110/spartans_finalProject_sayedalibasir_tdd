package tek_insurance.tdd.utility;

import java.util.Random;

public class RandomUserName {
    public static String generateRandomUserName() {
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder randomUserName = new StringBuilder(10);
        for (int i = 0; i < 10; i++){
            randomUserName.append(characters.charAt(random.nextInt(characters.length())));
        }
        return randomUserName.toString();
    }
}
