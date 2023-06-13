package javaapplication10.java;
import java.util.Comparator;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
public class Score {
    private String name;
    private int win;
    private int draw;
    private int lose;

    public Score(String name, int win, int draw, int lose) {
        this.name = name;
        this.win = win;
        this.draw = draw;
        this.lose = lose;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWin() {
        return win;
    }

    public void setWin(int win) {
        this.win = win;
    }

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public int getLose() {
        return lose;
    }

    public void setLose(int lose) {
        this.lose = lose;
    }

    @Override
    public String toString() {
        return name + " [ W/D/L : " + win + "/" + draw + "/" + lose + " ]";
    }
    
}
