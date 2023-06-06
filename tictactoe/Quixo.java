/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tictactoe;

import java.util.Scanner;
import java.util.Random;

public class Quixo {


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        char[][] board = createBoard();

        System.out.println("LET'S PLAY QUIXO TIC - TAC - TOE GAME!");

        System.out.print("Please choose your level of difficulty. \nLevel 1 - Easy | Level 2 - Medium | Level 3 - Hard: ");
        int difficulty = input.nextInt();

        printBoard(board);

        while (true) {
            playersTurn(board, input);
            if (gameOver(board)) {
                break;
            }
            printBoard(board);

            computersTurn(board, difficulty);
            if (gameOver(board)) {
                break;
            }
            printBoard(board);
        }
        input.close();
    }

    private static char[][] createBoard() { // building 5x5 board
        char[][] board = new char[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                board[i][j] = ' ';
            }
        }
        return board;
    }

    private static void printBoard(char[][] board) { // printing the board
        System.out.println();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(board[i][j]);
                if (j < 4) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < 4) {
                System.out.println("------------------");
            }
        }
        System.out.println();
    }

    private static void computersTurn(char[][] board, int difficulty) { // how computer takes turn
        char mark = 'O';
        int move;
        switch (difficulty) {
            case 1:
                move = getEasyMove(board);
                break;
            case 2:
                move = getMediumMove(board, mark);
                break;
            default:
                move = getHardMove(board, mark);
                break;
        }
        moves(board, Integer.toString(move), mark);  // changing the int for move to string
        System.out.println("Computer chose " + move);
    }

    private static int getEasyMove(char[][] board) { // easy level move for computer
        Random rannum = new Random();
        int computermoves;
        while (true) {
            computermoves = rannum.nextInt(25) + 1;
            if (available(board, Integer.toString(computermoves))) {
                break;
            }
        } // if valid move, we will exit from this loop
        return computermoves; // return to move
    }
  private static int getMediumMove(char[][] board, char mark) {
        int row, col;
    
        // checking rows
        for (row = 0; row < 5; row++) {
            for (col = 0; col < 3; col++) {
                if (board[row][col] == mark && board[row][col + 1] == mark && board[row][col + 2] == ' ') {
                    return (row * 5) + col + 3;
                }
                if (board[row][col] == mark && board[row][col + 2] == mark && board[row][col + 1] == ' ') {
                    return (row * 5) + col + 2;
                }
                if (board[row][col + 1] == mark && board[row][col + 2] == mark && board[row][col] == ' ') {
                    return (row * 5) + col + 1;
                }
            }
        }
    
        // checking columns
        for (col = 0; col < 5; col++) {
            for (row = 0; row < 3; row++) {
                if (board[row][col] == mark && board[row + 1][col] == mark && board[row + 2][col] == ' ') {
                    return (row + 3) * 5 + col + 1;
                }
                if (board[row][col] == mark && board[row + 2][col] == mark && board[row + 1][col] == ' ') {
                    return (row + 2) * 5 + col + 1;
                }
                if (board[row + 1][col] == mark && board[row + 2][col] == mark && board[row][col] == ' ') {
                    return (row + 1) * 5 + col + 1;
                }
            }
        }
    
        // checking diagonals (top-left to bottom-right)
        for (row = 0; row < 3; row++) {
            for (col = 0; col < 3; col++) {
                if (board[row][col] == mark && board[row + 1][col + 1] == mark && board[row + 2][col + 2] == ' ') {
                    return (row + 3) * 5 + col + 3;
                }
                if (board[row][col] == mark && board[row + 2][col + 2] == mark && board[row + 1][col + 1] == ' ') {
                    return (row + 2) * 5 + col + 2;
                }
                if (board[row + 1][col + 1] == mark && board[row + 2][col + 2] == mark && board[row][col] == ' ') {
                    return (row + 1) * 5 + col + 1;
                }
            }
        }
    
        // checking diagonals (top-right to bottom-left)
        for (row = 0; row < 3; row++) {
            for (col = 2; col < 5; col++) {
                if (board[row][col] == mark && board[row + 1][col - 1] == mark && board[row + 2][col - 2] == ' ') {
                    return (row + 3) * 5 + col - 1;
                }
                if (board[row][col] == mark && board[row + 2][col - 2] == mark && board[row + 1][col - 1] == ' ') {
                    return (row + 2) * 5 + col - 2;
                }
                if (board[row + 1][col - 1] == mark && board[row + 2][col - 2] == mark && board[row][col] == ' ') {
                    return (row + 1) * 5 + col + 1;
                }
            }
        }
    
    return getEasyMove(board); // if no immediate winning move, return a random move
}

    private static int getHardMove(char[][] board, char mark) {
    // checking if the computer can win in the next move
    for (int row = 0; row < 5; row++) {
        for (int col = 0; col < 5; col++) {
            if (board[row][col] == ' ') {
                board[row][col] = mark;
                if (checkWin(board, mark)) {
                    board[row][col] = ' '; // Undo the move
                    return (row * 5) + col + 1;
                }
                board[row][col] = ' '; // Undo the move
            }
        }
    }
    
    // checking if the player can win in the next move and block it
    char playerMark = (mark == 'X') ? 'O' : 'X';
    for (int row = 0; row < 5; row++) {
        for (int col = 0; col < 5; col++) {
            if (board[row][col] == ' ') {
                board[row][col] = playerMark;
                if (checkWin(board, playerMark)) {
                    board[row][col] = ' '; // Undo the move
                    return (row * 5) + col + 1;
                }
                board[row][col] = ' '; // Undo the move
            }
        }
    }
    
    return getMediumMove(board, mark); // If no immediate winning/losing move, return a move using medium difficulty logic
}

    
    private static boolean checkWin(char[][] board, char mark) {
    // Checking horizontally
    for (int row = 0; row < 5; row++) {
        for (int col = 0; col < 1; col++) {
            if (board[row][col] == mark && board[row][col + 1] == mark && board[row][col + 2] == mark && board[row][col + 3] == mark && board[row][col + 4] == mark) {
                return true;
            }
        }
    }

    // Checking vertically
    for (int col = 0; col < 5; col++) {
        for (int row = 0; row < 1; row++) {
            if (board[row][col] == mark && board[row + 1][col] == mark && board[row + 2][col] == mark && board[row + 3][col] == mark && board[row + 4][col] == mark) {
                return true;
            }
        }
    }

    // Checking diagonals
    for (int row = 0; row < 1; row++) {
        for (int col = 0; col < 1; col++) {
            if (board[row][col] == mark && board[row + 1][col + 1] == mark && board[row + 2][col + 2] == mark && board[row + 3][col + 3] == mark && board[row + 4][col + 4] == mark) {
                return true;
            }
        }
    }

    for (int row = 0; row < 1; row++) {
        for (int col = 4; col < 5; col++) {
            if (board[row][col] == mark && board[row + 1][col - 1] == mark && board[row + 2][col - 2] == mark && board[row + 3][col - 3] == mark && board[row + 4][col - 4] == mark) {
                return true;
            }
        }
    }

    return false;
}


    private static void playersTurn(char[][] board, Scanner input) {
        char mark = 'X';
        String userinput;
        while (true) {
        System.out.print("Enter your move (1-25): ");
        userinput = input.next();
        if (available(board, userinput)) {
            break;
        }
        else {
            System.out.print("Invalid move. Enter your move (1-25): ");
        }    
    }
        moves(board, userinput, mark);
}
    
    private static boolean available(char[][] board, String position) {
        int index = Integer.parseInt(position) - 1; // integer.parseint changes the string position to integer, -1 because 1st array index starts with [0]
        if (index >= 0 && index < 25) {
            int row = index / 5;
            int col = index % 5;
            return board[row][col] == ' ';
        }   
        else {
        return false; // return false if user enter number that is not within 1-25
        }
    }
    
    private static void moves(char[][] board, String move, char mark) {
        int position = Integer.parseInt(move);
        int row = (position - 1) / 5;
        int col = (position - 1) % 5;
        board[row][col] = mark;
    }

    private static boolean gameOver(char[][] board) {
    if (checkWin(board, 'X')) {
        printBoard(board);
        System.out.println("Player wins!");
        return true;
    }

    if (checkWin(board, 'O')) {
        printBoard(board);
        System.out.println("Computer wins!");
        return true;
    }

    for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[i].length; j++) {
            if (board[i][j] == ' ') {
                return false;
            }
        }
    }

    printBoard(board);
    System.out.println("The game ended in a tie!");
    return true;
}
}