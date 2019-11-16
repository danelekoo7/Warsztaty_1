package src.zadanie2;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        howManyNumbers(sixUsersNumbers(), sixLuckyNumbers());
    }

    static void howManyNumbers(int[] a, int[] b) {
        int result = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (a[i] == b[j]) {
                    result += 1;
                }
            }
        }
        if (result >= 3) {
            System.out.println("Brawo! Trafiłeś: " + result);
        }
    }

    static int[] sixUsersNumbers() {
        int[] numbers = {0, 0, 0, 0, 0, 0};
        int number = -1;
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Podaj liczbę: ");
            Scanner scanner = new Scanner(System.in);
            if (!scanner.hasNextInt()) {
                System.out.println("Musisz podać liczbę");
                i -= 1;
            } else {
                number = scanner.nextInt();
                if (number > 49 || number < 1) {
                    System.out.println("Podaj liczbę z zakresu 1-49");
                    i -= 1;
                } else {
                    numbers[i] = number;
                    for (int j = 0; j < i; j++) {
                        if (numbers[j] == number) {
                            System.out.println("ta liczba już była");
                            i -= 1;
                        }
                    }
                }
            }
        }
        Arrays.sort(numbers);
        System.out.println("Liczby podane przez uzytkownika to" + Arrays.toString(numbers));
        return numbers;
    }


    static int[] sixLuckyNumbers() {
        int[] luckyNumbers = {0, 0, 0, 0, 0, 0};
        for (int i = 0; i < luckyNumbers.length; i++) {
            Random random = new Random();
            int oneNumber = random.nextInt(49) + 1;
            luckyNumbers[i] = oneNumber;
            for (int j = 0; j < i; j++) {
                if (luckyNumbers[j] == oneNumber) {
                    random = new Random();
                    oneNumber = random.nextInt(49) + 1;
                    luckyNumbers[i] = oneNumber;
                    i -= 1;
                }
            }
        }
        Arrays.sort(luckyNumbers);
        System.out.println("komputer wylosował takie liczby: " + Arrays.toString(luckyNumbers));
        return luckyNumbers;
    }
}