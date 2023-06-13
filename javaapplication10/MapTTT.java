/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication10;


/**
 *
 * @author husnanadiah
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javaapplication10.java.GUI;


       
public class MapTTT extends JPanel {
    private static final int TILE_SIZE = 30; // Size of each tile in pixels
    private static final int[] ALLOWED_NUMBERS = {0, 2, 3};

     int[][] map = {
            {0, 0, 2, 0, 0, 0, 1, 1, 1, 1, 0, 0, 2, 0, 0, 0, 1, 1, 1, 1},
            {0, 1, 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 1},
            {0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1},
            {0, 1, 0, 1, 1, 0, 0, 2, 0, 1, 0, 1, 0, 1, 1, 0, 0, 2, 0, 1},
            {0, 1, 0, 1, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 1, 0, 1},
            {0, 1, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 1, 0, 1},
            {0, 1, 0, 0, 0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0, 1},
            {0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 0, 1, 1, 0, 1},
            {0, 1, 0, 1, 1, 1, 1, 0, 0, 1, 0, 1, 0, 1, 1, 2, 1, 0, 0, 1},
            {0, 0, 0, 1, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 0, 1, 1},
            {0, 1, 1, 1, 1, 0, 0, 0, 0, 1, 0, 1, 1, 1, 1, 0, 0, 0, 0, 1},
            {0, 1, 1, 0, 0, 2, 1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 2, 0, 1},
            {0, 1, 1, 0, 1, 0, 0, 1, 0, 0, 0, 1, 1, 0, 1, 0, 0, 1, 0, 0},
            {0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0},
            {0, 1, 1, 0, 1, 1, 0, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 1, 0, 0},
            {2, 0, 0, 0, 1, 1, 0, 0, 0, 1, 2, 0, 0, 0, 1, 1, 0, 0, 0, 1},
            {0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1},
            {0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 1},
            {0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1},
            {0, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 0, 3}
        };
        

    private int playerX = 0; // Player's initial X coordinate
    private int playerY = 0; // Player's initial Y coordinate

    public MapTTT() {
        setPreferredSize(new Dimension(map[0].length * TILE_SIZE, map.length * TILE_SIZE));

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                handleMovement(e.getKeyCode());
            }
        });

        setFocusable(true);
    }

    private void handleMovement(int keyCode) {
        int newPlayerX = playerX;
        int newPlayerY = playerY;

        if (keyCode == KeyEvent.VK_UP) { // Move up
            newPlayerY--;
        } else if (keyCode == KeyEvent.VK_DOWN) { // Move down
            newPlayerY++;
        } else if (keyCode == KeyEvent.VK_LEFT) { // Move left
            newPlayerX--;
        } else if (keyCode == KeyEvent.VK_RIGHT) { // Move right
            newPlayerX++;
        }

        if (isValidMove(newPlayerX, newPlayerY)) {
            playerX = newPlayerX;
            playerY = newPlayerY;
        }

        repaint();
        if (map[playerY][playerX] == 2) {
            GUI gui = new GUI();
        
        // Set the GUI visible
        gui.setVisible(true);
        }
        if (map[playerY][playerX] == 3) {
            System.out.println("Congratulations! You reached the goal.");
        }
    }

    private boolean isValidMove(int x, int y) {
        if (y < 0 || y >= map.length || x < 0 || x >= map[y].length) {
            return false; // Out of map bounds
        }

        int currentNumber = map[y][x];

        for (int allowedNumber : ALLOWED_NUMBERS) {
            if (currentNumber == allowedNumber) {
                return true; // Valid move
            }
        }

        return false; // Invalid move
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[y].length; x++) {
                int tileX = x * TILE_SIZE;
                int tileY = y * TILE_SIZE;

                if (x == playerX && y == playerY) {
                    g.setColor(Color.RED);
                } else {
                    switch (map[y][x]) {
                        case 0:
                            g.setColor(Color.WHITE);
                            break;
                        case 1:
                            g.setColor(Color.BLACK);
                            break;
                        case 2:
                            g.setColor(Color.BLUE);
                            break;
                        case 3:
                            g.setColor(Color.GREEN);
                            break;
                        default:
                            g.setColor(Color.GRAY);
                            break;
                    }
                }

                g.fillRect(tileX, tileY, TILE_SIZE, TILE_SIZE);
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Map ");
        MapTTT map1 = new MapTTT();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(map1);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        map1.requestFocus();
    }
}