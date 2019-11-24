package src.zadanie3;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        int min = 0;
        int max = 1001;
        System.out.println("Pomyśl liczbę od 0 do 1000 a ja ją zgadnę w max. 10 próbach ");
        boolean loop = true;
        int counter = 1;
        while (loop) {
            int guess = ((max - min) / 2) + min;
            System.out.println("Próba numer: " + counter);
            System.out.println("Zgaduję: " + guess);
            System.out.println("Wpisza: za mało, za dużo albo zgadłeś");
            Scanner scanner = new Scanner(System.in);
            String word = scanner.nextLine();
            if (word.equals("zgadłeś")) {
                System.out.println("Wygrałem");
                loop = false;
            } else if (word.equals("za dużo") && counter<10) {
                max = guess;
                counter += 1;
            } else if (word.equals("za mało") && counter<10) {
                min = guess;
                counter += 1;
            } else {
                System.out.println("Nie oszukuj!");
            }
        }
    }
}
