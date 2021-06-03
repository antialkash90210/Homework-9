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
        int max = 0;
        int min = 100;
        final int EXIT_CODE = -1;
        boolean inputNumber;


        // TODO: 03.06.2021   choice of difficulty level
        int difficulty;
        boolean inputDifficulty;

        try {
            inputDifficulty = true;
            System.out.println("Введите сложность игры: 1 - легкий, 2 - средний, 3 - сложный: ");
            difficulty = input.nextInt();

            switch (difficulty) {
                case 1:
                    System.out.println("легкий\nВведите любое число от 1 до 100:");
                    compNumber = rnd.nextInt(100) + 1;
                    max = 100;
                    min = 1;
                    break;
                case 2:
                    System.out.println("средний\nВведите любое число от 1 до 250:  ");
                    compNumber = rnd.nextInt(250) + 1;
                    max = 250;
                    min = 1;
                    break;
                case 3:
                    System.out.println("сложный\nВведите любое число от 1 до 500: ");
                    compNumber = rnd.nextInt(500) + 1;
                    max = 500;
                    min = 1;
                    break;
            }
        } catch (Exception e) {
            inputDifficulty = false;
            System.out.println("Ошибка ввода,перезапустите программу " + e.getMessage());
        }

        // TODO: 03.06.2021  computer number output
        do {
            inputNumber = true;
//           Scanner input = new Scanner(System.in); - try catch работает только при переинициализации Scanner

            try {
                userNumber = input.nextInt();

                if (userNumber < 1 || userNumber > 500) {
                    throw new Exception();
                }

                if (userNumber > compNumber) {
                    max = userNumber;
                    System.out.println("Введите число поменьше: от " + min + " до " + userNumber);
                } else if (userNumber < compNumber) {
                    min = userNumber;
                    System.out.println("Введите число побольше: от " + userNumber + " до " + max);
                }

                if (userNumber != EXIT_CODE) {
                    numberOfAttempts++;
                }
            } catch (Exception e) {
                inputNumber = false;
            }

        } while (compNumber != userNumber || inputNumber == false);


        // TODO: 03.06.2021  decision result


        System.out.println("Поздравляю,вы угадали число!! ");
        System.out.println("Количество попыток: " + numberOfAttempts);

        if (numberOfAttempts <= 5) {
            System.out.println("красава");
        } else if (numberOfAttempts > 5 && numberOfAttempts <= 10) {
            System.out.println("среднячок");
        } else {
            System.out.println("лошара");
        }

        if (compNumber == 150) {
            System.out.print("Счастливое число :) ");
        }
    }
}