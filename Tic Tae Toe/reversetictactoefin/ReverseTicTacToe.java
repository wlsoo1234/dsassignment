/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reversetictactoefin;

import java.util.Scanner;

/**
 *
 * @author husna
 */
public class ReverseTicTacToe {
    
    private char[] board;
    private char currentPlayer;
    private boolean gameOver;
    private int movesCount;
    private ReverseEngine engine;
    private String difficulty;

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Tic-Tac-Toe!");

        initializeGame(scanner);

        while (!gameOver) {
            displayBoard();

            if (currentPlayer == 'X') {
                playerMove(scanner);
            } else {
                engineMove();
            }

            if (checkWin(currentPlayer)) {
                displayBoard();
                if (currentPlayer == 'X') {
                    System.out.println("You lose!");
                } else {
                    System.out.println("You win!");
                }
                break;
            }

            if (movesCount == 9) {
                displayBoard();
                System.out.println("It's a tie!");
                break;
            }

            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }

        System.out.println("Thank you for playing Tic-Tac-Toe!");
    }

    private void initializeGame(Scanner scanner) {
        board = new char[9];
        currentPlayer = 'X';
        gameOver = false;
        movesCount = 0;
        engine = new ReverseEngine();

        // Choose difficulty level
        System.out.println("Choose difficulty level: ");
        System.out.println("1. Easy");
        System.out.println("2. Medium");
        System.out.println("3. Hard");
        System.out.print("Enter difficulty level (1-3): ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        switch (choice) {
            case 1:
                difficulty = "easy";
                break;
            case 2:
                difficulty = "medium";
                break;
            case 3:
                difficulty = "hard";
                break;
            default:
                difficulty = "medium"; // Default to medium difficulty
                break;
        }

        for (int i = 0; i < board.length; i++) {
            board[i] = ' ';
        }
    }

    private void displayBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 9; i += 3) {
            System.out.println("| " + board[i] + " | " + board[i + 1] + " | " + board[i + 2] + " |");
            System.out.println("-------------");
        }
    }

    private void playerMove(Scanner scanner) {
        while (true) {
            System.out.print("Player " + currentPlayer + ", enter your move (1-9): ");
            int move = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            if (move < 1 || move > 9) {
                System.out.println("Invalid move. Please enter a number between 1 and 9.");
                continue;
            }

            int index = move - 1;
            if (board[index] != ' ') {
                System.out.println("Invalid move. The selected cell is not empty.");
                continue;
            }

            board[index] = currentPlayer;
            movesCount++;
            break;
        }
    }

    private void engineMove() {
        int move = engine.makeMove(board, difficulty);
        board[move] = currentPlayer;
        movesCount++;
    }

    private boolean checkWin(char player) {
        // Check rows
        for (int i = 0; i < 9; i += 3) {
            if (board[i] == player && board[i + 1] == player && board[i + 2] == player) {
                gameOver = true;
                return true;
            }
        }

        // Check columns
        for (int i = 0; i < 3; i++) {
            if (board[i] == player && board[i + 3] == player && board[i + 6] == player) {
                gameOver = true;
                return true;
            }
        }

        // Check diagonals
        if (board[0] == player && board[4] == player && board[8] == player) {
            gameOver = true;
            return true;
        }

        if (board[2] == player && board[4] == player && board[6] == player) {
            gameOver = true;
            return true;
        }

        return false;
    }
}


