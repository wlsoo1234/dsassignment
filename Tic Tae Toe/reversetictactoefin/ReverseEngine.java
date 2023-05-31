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
import java.util.Collections;
import java.util.List;
import java.util.Random;
public class ReverseEngine {

    private static final char PLAYER = 'X';
    private static final char OPPONENT = 'O';

    public int makeMove(char[] board, String difficulty) {
        List<Integer> emptyCells = getEmptyCells(board);

        // Hard Difficulty: All Perfect Moves (1st ranked moves)
        if (difficulty.equals("hard")) {
            return getRankedMove(board, emptyCells, 1, emptyCells.size());
        }

        // Medium Difficulty: 70% 1st ranked moves, 30% 2nd ranked moves
        if (difficulty.equals("medium")) {
            int numFirstRankedMoves = (int) (emptyCells.size() * 0.7);
            int numSecondRankedMoves = emptyCells.size() - numFirstRankedMoves;

            int firstRankedMove = getRankedMove(board, emptyCells, 1, numFirstRankedMoves);
            int secondRankedMove = getRankedMove(board, emptyCells, 2, numSecondRankedMoves);

            Random random = new Random();
            int randomValue = random.nextInt(10); // Random value between 0 and 9

            // 70% chance of selecting a 1st ranked move, 30% chance of selecting a 2nd ranked move
            if (randomValue < 7) {
                return firstRankedMove;
            } else {
                return secondRankedMove;
            }
        }

        // Easy Difficulty: 30% 1st ranked moves, 70% 2nd ranked moves
        if (difficulty.equals("easy")) {
            int numFirstRankedMoves = (int) (emptyCells.size() * 0.3);
            int numSecondRankedMoves = emptyCells.size() - numFirstRankedMoves;

            int firstRankedMove = getRankedMove(board, emptyCells, 1, numFirstRankedMoves);
            int secondRankedMove = getRankedMove(board, emptyCells, 2, numSecondRankedMoves);

            Random random = new Random();
            int randomValue = random.nextInt(10); // Random value between 0 and 9

            // 30% chance of selecting a 1st ranked move, 70% chance of selecting a 2nd ranked move
            if (randomValue < 3) {
                return firstRankedMove;
            } else {
                return secondRankedMove;
            }
        }

        return -1; // Invalid difficulty
    }

    private int getRankedMove(char[] board, List<Integer> emptyCells, int rank, int numMoves) {
        List<Integer> rankedMoves = new ArrayList<>();

        for (int cell : emptyCells) {
            board[cell] = OPPONENT;
            int score = minimax(board, 0, false);
            board[cell] = ' ';

            if (score == rank) {
                rankedMoves.add(cell);
            }

            if (rankedMoves.size() == numMoves) {
                break;
            }
        }

        if (!rankedMoves.isEmpty()) {
            // Choose a random move from the ranked moves
            Random random = new Random();
            int randomIndex = random.nextInt(rankedMoves.size());
            return rankedMoves.get(randomIndex);
        }

        // If no ranked moves available, select a random move
        Random random = new Random();
        return emptyCells.get(random.nextInt(emptyCells.size()));
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
