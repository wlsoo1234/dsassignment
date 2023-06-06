/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tictactoe;

import java.util.Random;

 
public class MainTTT {
    public static void main(String[] args) {
        Random random = new Random();
        
        // Generate a random number in the range of 1-3
        int tttSelection = random.nextInt(3) + 1;
        
        
        if(tttSelection == 1){
            ReverseTTT game = new ReverseTTT(); // Create an instance of the TicTacToe class
        String[] gameArgs = {};
        game.main(gameArgs); 
        }
        if(tttSelection == 2){
           TicTacToe game = new TicTacToe(); // Create an instance of the TicTacToe class
        String[] gameArgs = {}; // Optional command-line arguments for the TicTacToe main method
        
        game.main(gameArgs); 
        }
        if(tttSelection == 3){
            Quixo game = new Quixo(); // Create an instance of the TicTacToe class
        String[] gameArgs = {}; // Optional command-line arguments for the TicTacToe main method
        
        game.main(gameArgs); 
        }
    }
}
