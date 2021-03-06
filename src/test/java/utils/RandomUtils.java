package utils;

import org.apache.commons.lang3.StringUtils;

import java.sql.Timestamp;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    private static String emailDomain = "@gmail.com";

    public static String getRandomString(int length) {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder result = new StringBuilder();
        Random rnd = new Random();
        while (result.length() < length) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            result.append(SALTCHARS.charAt(index));
        }

        return result.toString();
    }


    public static int getRandomInt(int min, int max) {
        Random r = new Random();

        return r.nextInt((max - min) + 1) + min;
    }

    public static String getRandomPhone() {
        return getRandomLong(1111111111L, 9999999999L) + "";
    }

    public static String getRandomPhone(String code) {
        return code + getRandomLong(11111111111111111L, 99999999999999999L);
    }

    public static String getDifficultRandomPhone(String code) {
        return code + " (" + getRandomLong(111L, 999L) + ") " + getRandomLong(11111L, 999999L) + "-" + getRandomLong(111L, 999999L);
    }

    public static Long getRandomLong(Long min, Long max) {
        return ThreadLocalRandom.current().nextLong(min, max);
    }

    public static String getRandomEmail() {
        long timestamp = new Timestamp(System.currentTimeMillis()).getTime();
        return getRandomString(5) + timestamp + emailDomain;
    }

    public static String getRandomGender(int min, int max) {
        String[] words3 = {"Other", "Male", "Female"};

        StringBuilder message = new StringBuilder();
        int messageLength = getRandomInt(min, max);
        while (message.length() < messageLength) {
            int wordIndex = getRandomInt(0, words3.length - 1);
            message.append(words3[wordIndex] + " ");
        }

        String readyMessage = StringUtils.capitalize(message.toString())
                .replace("  ", " ")
                .replace(" ,", ",")
                .replace(" .", ".").trim();

        return readyMessage;
    }


    public static String getRandomMonth(int min, int max) {
        String[] words4 = {"May", "April", "June"};

        StringBuilder message = new StringBuilder();
        int messageLength = getRandomInt(min, max);
        while (message.length() < messageLength) {
            int wordIndex = getRandomInt(0, words4.length - 1);
            message.append(words4[wordIndex] + " ");
        }


        String readyMessage = StringUtils.capitalize(message.toString())
                .replace("  ", " ")
                .replace(" ,", ",")
                .replace(" .", ".").trim();

        return readyMessage;
    }

    public static String getRandomSubjects(int min, int max) {
        String[] words4 = {"Civics", "Maths", "Hindi", "Arts"};

        StringBuilder message = new StringBuilder();
        int messageLength = getRandomInt(min, max);
        while (message.length() < messageLength) {
            int wordIndex = getRandomInt(0, words4.length - 1);
            message.append(words4[wordIndex] + " ");
        }


        String readyMessage = StringUtils.capitalize(message.toString())
                .replace("  ", " ")
                .replace(" ,", ",")
                .replace(" .", ".").trim();

        return readyMessage;
    }

    public static String getRandomState(int min, int max) {
        String[] words4 = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};

        StringBuilder message = new StringBuilder();
        int messageLength = getRandomInt(min, max);
        while (message.length() < messageLength) {
            int wordIndex = getRandomInt(0, words4.length - 1);
            message.append(words4[wordIndex] + " ");
        }


        String readyMessage = StringUtils.capitalize(message.toString())
                .replace("  ", " ")
                .replace(" ,", ",")
                .replace(" .", ".").trim();

        return readyMessage;
    }

    public static String getRandomHaryanaCity(int min, int max) {
        String[] words4 = {"Karnal", "Panipat"};

        StringBuilder message = new StringBuilder();
        int messageLength = getRandomInt(min, max);
        while (message.length() < messageLength) {
            int wordIndex = getRandomInt(0, words4.length - 1);
            message.append(words4[wordIndex] + " ");
        }


        String readyMessage = StringUtils.capitalize(message.toString())
                .replace("  ", " ")
                .replace(" ,", ",")
                .replace(" .", ".").trim();

        return readyMessage;


    }


}