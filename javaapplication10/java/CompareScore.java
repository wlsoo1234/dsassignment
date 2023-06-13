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

public class CompareScore implements Comparator<Score>
{

    @Override
    public int compare(Score o1, Score o2) {
        int win = Integer.compare(o2.getWin(), o1.getWin());
        
        if(win != 0)
        {
            return win;
        }
        
        int draw = Integer.compare(o2.getDraw(), o1.getDraw());

        if(draw != 0)
        {
            return draw;
        }
        
        int lose = Integer.compare(o1.getLose(), o2.getLose());

        return lose;
    }
}
