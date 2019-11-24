package src.zadanie4;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        boolean loop = true;
        int result = 0;
        int howManyTimes = 1;
        int diceType = 0;
        int additionalFunction = 0;
        char plusMinus = ' ';
        while (loop) {
            howManyTimes = 1;
            diceType = 0;
            additionalFunction = 0;
            plusMinus = ' ';
            loop = false;
            String command = "";
            System.out.println("podaj komendę w formie xDy+z gdzie: \n " +
                    "-x oznacza liczbę rzutów (jeśli go nie podasz zostanie wykonany jeden rzut) \n " +
                    "-y oznacza ile ścian ma kostka (masz do wyboru: 3, 4, 6, 8, 10, 12, 20, 100) \n " +
                    "-z oznaczad dodatkowe działanie (możesz dać lub odjąć dowolną liczbę od wurzuconej liczby)");
            Scanner scanner = new Scanner(System.in);
            command = scanner.nextLine();
            String[] partFirst = command.split("D");
            if (!command.contains("D")) {
                System.out.println("Niepoprawna komenda. Brakuje \"D\"");
                loop = true;
            } else if (partFirst.length != 2) {
                System.out.println("Niepoprawna komenda.");
                loop = true;
            } else if (!partFirst[0].equals("")) {
                try {
                    howManyTimes = Integer.parseInt(partFirst[0]);
                } catch (NumberFormatException e) {
                    System.out.println("Przed \"D\" może znaleźć się tylko liczba");
                    loop = true;
                }
            }
            if (howManyTimes < 1) {
                System.out.println("Nie można rzucić kostką mniej niż jeden raz :(");
                loop = true;
            }
            if (!loop) {
                if (partFirst[1].contains("+")) {
                    String[] partSecond = partFirst[1].split("\\+");
                    plusMinus = '+';
                    try {
                        diceType = Integer.parseInt(partSecond[0]);
                    } catch (NumberFormatException e) {
                        System.out.println("Nieprawidłowa komenda. \n Pomiędzy \"D\" a + powinna sie znaleźć liczba ");
                        loop = true;
                    }
                    try {
                        additionalFunction = Integer.parseInt(partSecond[1]);
                    } catch (NumberFormatException ex) {
                        System.out.println("Nieprawidłowa komenda. Po znaku + powinna sie znaleźć liczba ");
                        loop = true;
                    }
                } else if (partFirst[1].contains("-")) {
                    String[] partSecond = partFirst[1].split("-");
                    plusMinus = '-';
                    try {
                        diceType = Integer.parseInt(partSecond[0]);
                    } catch (NumberFormatException e) {
                        System.out.println("Nieprawidłowa komenda. \n Pomiędzy \"D\" a - powinna sie znaleźć liczba ");
                        loop = true;
                    }
                    try {
                        additionalFunction = Integer.parseInt(partSecond[1]);
                    } catch (NumberFormatException ex) {
                        System.out.println("Nieprawidłowa komenda. Po znaku - powinna sie znaleźć liczba ");
                        loop = true;
                    }
                } else {
                    try {
                        diceType = Integer.parseInt(partFirst[1]);
                    } catch (NumberFormatException e) {
                        System.out.println("Nieprawidłowa komenda. Po \"D\" powinna sie znaleźć liczba ");
                        loop = true;
                    }
                }
                if (diceType == 3 ||
                        diceType == 4 ||
                        diceType == 6 ||
                        diceType == 8 ||
                        diceType == 10 ||
                        diceType == 12 ||
                        diceType == 20 ||
                        diceType == 100) {
                } else {
                    System.out.println("nie ma takiego typu kostki :(");
                    loop = true;
                }
            }
        }
        for (int i = 0; i < howManyTimes; i++) {
            Random r = new Random();
            int number = r.nextInt(diceType) + 1;
            result += number;
        }
        if (plusMinus == '+') {
            result += additionalFunction;
        } else if (plusMinus == '-') {
            result -= additionalFunction;
        }
        System.out.println("ile razy " + howManyTimes);
        System.out.println("typ kostki " + diceType);
        System.out.println("dodatek " + plusMinus + " " + additionalFunction);
        System.out.println();
        System.out.println("Wynik to : " + result);
    }
}
