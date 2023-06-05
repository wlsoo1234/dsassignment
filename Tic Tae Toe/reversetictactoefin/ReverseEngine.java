/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package reversetictactoefin;

/**
 *
 * @author husna
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class ReverseEngine {

    private static final char PLAYER = 'X';
    private static final char OPPONENT = 'O';

    public int makeMove(char[] board, String difficulty) {
        List<Integer> emptyCells = getEmptyCells(board);

      // Easy Difficulty: Random Move
    if (difficulty.equals("easy")) {
        // Choose a random move
        Random random = new Random();
        int randomIndex = random.nextInt(emptyCells.size());
        return emptyCells.get(randomIndex);
    }
        // Medium Difficulty: Random Move, Avoid Immediate Losing Move
        if (difficulty.equals("medium")) {
            // Check for an immediate losing move for the opponent
            for (int cell : emptyCells) {
                board[cell] = OPPONENT;
                if (checkLoss(board, OPPONENT)) {
                    board[cell] = ' ';
                    continue;
                }
                board[cell] = ' ';
                return cell;
            }

            // Choose a random move
            Random random = new Random();
            return emptyCells.get(random.nextInt(emptyCells.size()));
        }

        // Hard Difficulty: Avoid Immediate Losing Move, Optimal Move
        if (difficulty.equals("hard")) {
            int bestMove = -1; //Initialize bestMove variable to -1 
            int bestScore = Integer.MIN_VALUE; //bestScore variable to the lowest possible value (Integer.MIN_VALUE)

            for (int cell : emptyCells) {
                board[cell] = OPPONENT;
                // Evaluate the board using minimax algorithm to get a score
                int score = minimax(board, 0, false);
                board[cell] = ' ';

                if (score > bestScore) {
                    bestScore = score;
                    bestMove = cell;
                }
            }

            return bestMove;
        }

        return -1;
    }
    private boolean checkLoss(char[] board, char player) {
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

        return false;
    }

    private int minimax(char[] board, int depth, boolean isMaximizing) {
        // Base cases: check for wins or a full board

       // If AI player wins, return a high score with depth penalty
        if (checkWin(board, PLAYER)) {
            return depth - 10;
       // If opponent wins, return a low score with depth penalty
        } else if (checkWin(board, OPPONENT)) {
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

                // Additional check to avoid immediate losing move
                if (bestScore == -10) {
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
                if (bestScore == 10) {
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

        return false;
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
