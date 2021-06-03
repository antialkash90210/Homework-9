package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Random rnd = new Random();
        int numberOfAttempts = 0;
        int compNumber = 0;
        int userNumber = 0;
        final int EXIT_CODE = -1;
        boolean inputResult;

        int difficulty;
        boolean inputDifficulty;

        try {
            inputDifficulty = true;
            System.out.println("Введите сложность игры от 1 до 3: ");
            difficulty = input.nextInt();

            switch (difficulty) {
                case 1:
                    System.out.println("легко ");
                    System.out.println("Введите любое число от 1 до 10: ");
                    compNumber = rnd.nextInt(10) + 1;
                    break;
                case 2:
                    System.out.println("средне ");
                    System.out.println("Введите любое число от 1 до 50: ");
                    compNumber = rnd.nextInt(50) + 1;
                    break;
                case 3:
                    System.out.println("сложно ");
                    System.out.println("Введите любое число от 1 до 100: ");
                    compNumber = rnd.nextInt(100) + 1;
                    break;
            }
        }
        catch (Exception e) {
            inputDifficulty = false;
            System.out.println("Ошибка ввода,перезапустите программу " + e.getMessage());
        }

        do {
            inputResult = true;
//           Scanner input = new Scanner(System.in);

            try {
                userNumber = input.nextInt();

                if (userNumber < 1 || userNumber > 100) {
                    throw new Exception();
                }

                if (userNumber > compNumber) {
                    System.out.println("Введите число поменьше: ");
                } else if (userNumber < compNumber) {
                    System.out.println("Введите число побольше: ");
                }

                if (userNumber != EXIT_CODE) {
                    numberOfAttempts++;
                }
            }
            catch (Exception e) {
                inputResult = false;
            }

        } while (compNumber != userNumber || inputResult == false);

        System.out.println("Поздравляю,вы угадали число!! ");
        System.out.println("Количество попыток: " + numberOfAttempts);

        if (numberOfAttempts <= 3) {
            System.out.println("гений");
        } else if (numberOfAttempts > 3 && numberOfAttempts <= 6) {
            System.out.println("среднячок");
        } else {
            System.out.println("лошара");
        }
    }
}