package src.RandomLetter;

import java.util.Random;

public class RandomLetter {
    public static void main(String[] args) {
        String[] letters = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "r", "s", "t", "u", "w", "z"};
        Random random = new Random();
        System.out.println(letters[random.nextInt(letters.length)]);
    }
}
