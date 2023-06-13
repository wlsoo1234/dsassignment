package javaapplication10.java;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//package tictactoe;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Reverse {
    public static void main(String[] args) {
        ReverseTicTacToe game = new ReverseTicTacToe();
        game.start(args[0]);
    }
}


 class ReverseTicTacToe {
    
    private char[] board;
    private char currentPlayer;
    private boolean gameOver;
    private int movesCount;
    private ReverseEngine engine;
    private String difficulty;

    public void start(String d) {
//        Scanner scanner = new Scanner(System.in);
        JOptionPane.showMessageDialog(null, "Welcome to Reverse Tic-Tac-Toe!");

        initializeGame(d);

//        while (!gameOver) {
//            displayBoard();
//
//            if (currentPlayer == 'X') {
//                playerMove(scanner);
//            } else {
//                engineMove();
//            }
//
//            if (checkWin(currentPlayer)) {
//                displayBoard();
//                if (currentPlayer == 'X') {
//                    System.out.println("You lose!");
//                } else {
//                    System.out.println("You win!");
//                }
//                break;
//            }
//
//            if (movesCount == 9) {
//                displayBoard();
//                System.out.println("It's a tie!");
//                break;
//            }
//
//            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
//        }
//
//        System.out.println("Thank you for playing Reverse Tic-Tac-Toe!");
    }

    private void initializeGame(String scanner) {
        board = new char[9];
        currentPlayer = 'X';
        gameOver = false;
        movesCount = 0;
        engine = new ReverseEngine();

        // Choose difficulty level
//        System.out.println("Choose difficulty level: ");
//        System.out.println("1. Easy");
//        System.out.println("2. Medium");
//        System.out.println("3. Hard");
//        System.out.print("Enter difficulty level (1-3): ");
        int choice = Integer.parseInt(scanner);

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
        
        JOptionPane.showMessageDialog(null, "You have chose " + difficulty + " level! Good luck!");

        for (int i = 0; i < board.length; i++) {
            board[i] = ' ';
        }
    }

    void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 9; i += 3) {
            System.out.println("| " + board[i] + " | " + board[i + 1] + " | " + board[i + 2] + " |");
            System.out.println("-------------");
        }
    }

    void setBoard(char[] rboard) {
        board = rboard;
        System.out.println("-------------");
        for (int i = 0; i < 9; i += 3) {
            System.out.println("| " + board[i] + " | " + board[i + 1] + " | " + board[i + 2] + " |");
            System.out.println("-------------");
        }
    }
    

    char[] getBoard() { // building 5x5 board
        return board;
    }

    boolean playerMove(int scanner) {
        while (true) {
            System.out.print("Player " + currentPlayer + ", enter your move (1-9): ");
            int move = scanner;

            if (move < 1 || move > 9) {
                JOptionPane.showMessageDialog(null,"Invalid move. Please enter a number between 1 and 9.");
                return false;
            }

            int index = move - 1;
            if (board[index] != ' ') {
                JOptionPane.showMessageDialog(null,"Invalid move. The selected cell is not empty.");
                return false;
            }

            board[index] = currentPlayer;
            movesCount++;
            return true;
        }
    }

    void engineMove() {
        int move = engine.makeMove(board, difficulty);
        board[move] = 'O';
        movesCount++;
    }

    boolean checkWin(char player) {
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

//            JOptionPane.showMessageDialog(null, " here");
        return false;
    }

    void resetBoard() {
    
        for (int i = 0; i < board.length; i++) {
            board[i] = ' ';
        }
    }
}

class ReverseEngine {
    private static final char PLAYER = 'X';
    private static final char OPPONENT = 'O';

    public int makeMove(char[] board, String difficulty) {
        List<Integer> emptyCells = getEmptyCells(board);

        if (difficulty.equals("easy")) {
            return getEasyMove(board, emptyCells);
        }

        if (difficulty.equals("medium")) {
            return getMediumMove(board, emptyCells);
        }

        if (difficulty.equals("hard")) {
            return getHardMove(board, emptyCells);
        }

        return -1;
    }

    private boolean checkWin(char[] board, char player) {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i * 3] == player && board[i * 3 + 1] == player && board[i * 3 + 2] == player) {
                return true;
            }
        }

        // Check columns
        for (int i = 0; i < 3; i++) {
            if (board[i] == player && board[i + 3] == player && board[i + 6] == player) {
                return true;
            }
        }

        // Check diagonals
        if (board[0] == player && board[4] == player && board[8] == player) {
            return true;
        }

        if (board[2] == player && board[4] == player && board[6] == player) {
            return true;
        }

        // Check reverse lines (creating opponent's symbol line)
        if (board[6] == player && board[7] == player && board[8] == player) {
            return true;
        }

        if (board[3] == player && board[4] == player && board[5] == player) {
            return true;
        }

        if (board[0] == player && board[1] == player && board[2] == player) {
            return true;
        }

        return false;
    }

    private int getEasyMove(char[] board, List<Integer> emptyCells) {
        // Check for an immediate winning move for the opponent
        for (int cell : emptyCells) {
            board[cell] = PLAYER; // Assume the move for the player
            if (checkWin(board, OPPONENT)) {
                board[cell] = ' ';
                return cell;
            }
            board[cell] = ' ';
        }

        // No immediate winning move, choose the first available move
        return emptyCells.get(0);
    }

    private int getMediumMove(char[] board, List<Integer> emptyCells) {
        // Check for an immediate winning move for the opponent
        for (int cell : emptyCells) {
            board[cell] = PLAYER; // Assume the move for the player
            if (checkWin(board, OPPONENT)) {
                board[cell] = ' ';
                return cell;
            }
            board[cell] = ' ';
        }

        // Check for an immediate winning move for the engine
        for (int cell : emptyCells) {
            board[cell] = OPPONENT;
            if (checkWin(board, PLAYER)) {
                board[cell] = ' ';
                return cell;
            }
            board[cell] = ' ';
        }

        // No immediate winning moves, choose the first available move
        return emptyCells.get(0);
    }

    private int getHardMove(char[] board, List<Integer> emptyCells) {
    int bestMove = -1;
    int bestScore = Integer.MIN_VALUE;

    for (int cell : emptyCells) {
        board[cell] = PLAYER; // Assume the move for the AI player
        int score = minimax(board, 0, false);
        board[cell] = ' ';

        if (score > bestScore) {
            bestScore = score;
            bestMove = cell;
        } else if (score == bestScore && emptyCells.size() > 1) {
            // Additional check to avoid immediate losing move
            boolean isImmediateLosingMove = isImmediateLosingMove(board, cell, emptyCells);
            if (!isImmediateLosingMove) {
                bestMove = cell;
            }
        }
    }

    return bestMove;
}

private boolean isImmediateLosingMove(char[] board, int move, List<Integer> emptyCells) {
    board[move] = OPPONENT; // Assume the move for the opponent

    for (int cell : emptyCells) {
        if (cell != move) {
            board[cell] = PLAYER; // Assume the move for the AI player
            boolean isLosingMove = checkWin(board, PLAYER);
            board[cell] = ' ';
            if (isLosingMove) {
                board[move] = ' ';
                return true;
            }
        }
    }

    board[move] = ' ';
    return false;
}

    private int minimax(char[] board, int depth, boolean isMaximizing) {
        // Base cases: check for wins or a full board

        // If AI player wins, return a high score with depth penalty
        if (checkWin(board, PLAYER)) {
            return depth - 10;
        }
        // If opponent wins, return a low score with depth penalty
        else if (checkWin(board, OPPONENT)) {
            return 10 - depth;
        } else if (isBoardFull(board)) {
            return 0;
        }

        if (isMaximizing) {
            int bestScore = Integer.MIN_VALUE;

            for (int cell : getEmptyCells(board)) {
                board[cell] = PLAYER;
                int score = minimax(board, depth + 1, false);
                board[cell] = ' ';

                bestScore = Math.max(score, bestScore);

                // Additional check to avoid immediate winning move
                if (bestScore == 10) {
                    break;
                }
            }

            return bestScore;
        } else {
            int bestScore = Integer.MAX_VALUE;

            for (int cell : getEmptyCells(board)) {
                board[cell] = OPPONENT;
                int score = minimax(board, depth + 1, true);
                board[cell] = ' ';

                bestScore = Math.min(score, bestScore);

                // Additional check to avoid immediate losing move
                if (bestScore == -10) {
                    break;
                }
            }

            return bestScore;
        }
    }

    private List<Integer> getEmptyCells(char[] board) {
        List<Integer> emptyCells = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            if (board[i] == ' ') {
                emptyCells.add(i);
            }
        }

        return emptyCells;
    }

    private boolean isBoardFull(char[] board) {
        for (char cell : board) {
            if (cell == ' ') {
                return false;
            }
        }

        return true;
    }
}
