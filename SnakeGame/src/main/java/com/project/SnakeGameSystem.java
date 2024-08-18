package com.project;

import java.util.LinkedList;
import java.util.Scanner;

public class SnakeGameSystem {

    private static char[][] board = new char[3][3];
    private static LinkedList<int[]> snake = new LinkedList<>(); // To store snake's body parts as (row, col) coordinates

    public static void main(String[] args) {
        initializeBoard();
        display();

        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        // Place the first food on the board
        placeFood(sc);

        while (!exit) {
            System.out.print("Enter your move (R/L/U/D) or Q to quit: ");
            String moveTo = sc.next();

            int[] head = snake.getFirst();
            int newRow = head[0], newCol = head[1];

            switch (moveTo.toUpperCase()) {
                case "R":
                    newCol++;
                    break;
                case "L":
                    newCol--;
                    break;
                case "U":
                    newRow--;
                    break;
                case "D":
                    newRow++;
                    break;
                case "Q":
                    exit = true;
                    System.out.println("Quitting the game.");
                    break;
                default:
                    System.out.println("Enter a valid move");
                    continue;
            }

            if (exit) break;

            if (newRow < 0 || newRow >= 3 || newCol < 0 || newCol >= 3) {
                System.out.println("Game over! Snake moved out of bounds.");
                break;
            }

            // Check if the snake runs into itself
            if (board[newRow][newCol] == 'S') {
                System.out.println("Game over! Snake ran into itself.");
                break;
            }

            // Check if the snake eats food
            if (board[newRow][newCol] == 'F') {
                snake.addFirst(new int[]{newRow, newCol}); // Grow snake by adding new head
                board[newRow][newCol] = 'S';
                display(); // Display the board after eating the food
                placeFood(sc); // Ask for the next food input
            } else {
                // Move the snake
                snake.addFirst(new int[]{newRow, newCol});
                board[newRow][newCol] = 'S';

                int[] tail = snake.removeLast();
                board[tail[0]][tail[1]] = ' '; // Clear the tail position
                display(); // Display the board after moving the snake
            }
        }

        sc.close();
    }

    private static void placeFood(Scanner sc) {
        while (true) {
            System.out.print("Enter food row and column: ");
            int row = sc.nextInt();
            int col = sc.nextInt();
            if (row < 0 || row >= 3 || col < 0 || col >= 3) {
                System.out.println("Invalid food position, please enter within the grid bounds.");
                continue;
            }

            if (board[row][col] == ' ') {
                board[row][col] = 'F';
                display();
                break;
            }
            else {
                System.out.println("Position already occupied by the snake. Try again.");
            }
        }
    }

    private static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
        snake.add(new int[]{0, 0});
        board[0][0] = 'S';
    }

    private static void display() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("| " + board[i][j]);
            }
            System.out.print("|");
            System.out.println();
        }
    }
}
