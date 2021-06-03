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
        boolean inputNumber;


        //choice of difficulty level
        int difficulty;
        boolean inputDifficulty;

        try {
            inputDifficulty = true;
            System.out.println("Введите сложность игры: 1 - легкий, 2 - средний, 3 - сложный: ");
            difficulty = input.nextInt();

            switch (difficulty) {
                case 1:
                    System.out.println("легкий ");
                    System.out.println("Введите любое число от 1 до 10: ");
                    compNumber = rnd.nextInt(10) + 1;
                    break;
                case 2:
                    System.out.println("средний ");
                    System.out.println("Введите любое число от 1 до 50: ");
                    compNumber = rnd.nextInt(50) + 1;
                    break;
                case 3:
                    System.out.println("сложный ");
                    System.out.println("Введите любое число от 1 до 100: ");
                    compNumber = rnd.nextInt(100) + 1;
                    break;
            }
        }
        catch (Exception e) {
            inputDifficulty = false;
            System.out.println("Ошибка ввода,перезапустите программу " + e.getMessage());
        }

        //computer number output
        do {
            inputNumber = true;
//           Scanner input = new Scanner(System.in); - try catch работает только при переинициализации Scanner

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
                inputNumber = false;
            }

        } while (compNumber != userNumber || inputNumber == false);


        //decision result
        if (compNumber == 10) {
            System.out.print("Счастливое число :) ");
        }

        System.out.println("Поздравляю,вы угадали число!! ");
        System.out.println("Количество попыток: " + numberOfAttempts);

        if (numberOfAttempts <= 5) {
            System.out.println("красава");
        } else if (numberOfAttempts > 5 && numberOfAttempts <= 10) {
            System.out.println("среднячок");
        } else {
            System.out.println("лошара");
        }
    }
}