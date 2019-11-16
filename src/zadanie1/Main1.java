package src.zadanie1;

import java.util.Random;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Random random = new Random();
        int randomNumber = random.nextInt(100) + 1;
        int userNumber;
        System.out.println("Zgadnij liczbę");
        boolean loop = true;
        while (loop) {
            Scanner scanner = new Scanner(System.in);
            while (!scanner.hasNextInt()) {
                System.out.println("to nie jest liczba");
                scanner = new Scanner(System.in);
            }
            userNumber = scanner.nextInt();
            if (userNumber < randomNumber) {
                System.out.println("za mało");
            } else if (userNumber > randomNumber) {
                System.out.println("za dużo");
            } else if (userNumber == randomNumber) {
                System.out.println("Zgadłeś");
                loop = false;
            }
        }
    }
}