package javaapplication10.java;
import java.awt.Color;
import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public final class GUI extends javax.swing.JFrame {
    int mode = 1;
    int difficulty = 1;
    
    TicTacToe ttt;
    ReverseTicTacToe r;
    Quixo q;
    
    char[][] board;
    
    /**
     * Creates new form GUI
     */
    
    void enableButton(int dim)
    {
        if(dim == 5)
        {
            jButton1.setEnabled(true);
            jButton2.setEnabled(true);
            jButton3.setEnabled(true);
            jButton4.setEnabled(true);
            jButton5.setEnabled(true);
            jButton6.setEnabled(true);
            
            jButton10.setEnabled(true);
            jButton11.setEnabled(true);
            
            jButton15.setEnabled(true);
            jButton16.setEnabled(true);
            
            jButton20.setEnabled(true);
            
            jButton21.setEnabled(true);
            jButton22.setEnabled(true);
            jButton23.setEnabled(true);
            jButton24.setEnabled(true);
            jButton25.setEnabled(true);
        }
        
        jButton7.setEnabled(true);
        jButton8.setEnabled(true);
        jButton9.setEnabled(true);
        
        jButton12.setEnabled(true);
        jButton13.setEnabled(true);
        jButton14.setEnabled(true);
        
        jButton17.setEnabled(true);
        jButton18.setEnabled(true);
        jButton19.setEnabled(true);
    }
    
    void disableButton()
    {
        jButton26.setText("Start");
        jButton1.setEnabled(false);
        jButton2.setEnabled(false);
        jButton3.setEnabled(false);
        jButton4.setEnabled(false);
        jButton5.setEnabled(false);
        jButton6.setEnabled(false);
            
        jButton10.setEnabled(false);
        jButton11.setEnabled(false);

        jButton15.setEnabled(false);
        jButton16.setEnabled(false);

        jButton20.setEnabled(false);

        jButton21.setEnabled(false);
        jButton22.setEnabled(false);
        jButton23.setEnabled(false);
        jButton24.setEnabled(false);
        jButton25.setEnabled(false);
        
        jButton7.setEnabled(false);
        jButton8.setEnabled(false);
        jButton9.setEnabled(false);
        
        jButton12.setEnabled(false);
        jButton13.setEnabled(false);
        jButton14.setEnabled(false);
        
        jButton17.setEnabled(false);
        jButton18.setEnabled(false);
        jButton19.setEnabled(false);
        
    }
    
    void disableButton(int dim) throws IOException
    {
        if(mode == 1)
        {
            if(r.checkWin('O'))
            {
                saveScore("1");
            }
            else if(r.checkWin('X'))
            {
                saveScore("3");
            }
            else
            {
                saveScore("2");
            }
//            if(ttt.checkWin(board, 'X'))
//            {
//                saveScore("1");
//            }
//            else if(ttt.checkWin(board, 'O'))
//            {
//                saveScore("3");
//            }
//            else
//            {
//                saveScore("2");
//            }
        }
        else if(mode == 2)
        {
            board = ttt.getBoard();
            if(ttt.checkWin(board, 'X'))
            {
                saveScore("1");
            }
            else if(ttt.checkWin(board, 'O'))
            {
                saveScore("3");
            }
            else
            {
                saveScore("2");
            }
        }
        else
        {
            board = q.getBoard();
            if(q.checkWin(board, 'X'))
            {
                saveScore("1");
            }
            else if(q.checkWin(board, 'O'))
            {
                saveScore("3");
            }
            else
            {
                saveScore("2");
            }
        }
        jButton26.setText("Start");
        if(dim == 5)
        {
            jButton1.setEnabled(false);
            jButton2.setEnabled(false);
            jButton3.setEnabled(false);
            jButton4.setEnabled(false);
            jButton5.setEnabled(false);
            jButton6.setEnabled(false);
            
            jButton10.setEnabled(false);
            jButton11.setEnabled(false);
            
            jButton15.setEnabled(false);
            jButton16.setEnabled(false);
            
            jButton20.setEnabled(false);
            
            jButton21.setEnabled(false);
            jButton22.setEnabled(false);
            jButton23.setEnabled(false);
            jButton24.setEnabled(false);
            jButton25.setEnabled(false);
        }
        
        jButton7.setEnabled(false);
        jButton8.setEnabled(false);
        jButton9.setEnabled(false);
        
        jButton12.setEnabled(false);
        jButton13.setEnabled(false);
        jButton14.setEnabled(false);
        
        jButton17.setEnabled(false);
        jButton18.setEnabled(false);
        jButton19.setEnabled(false);
        
    }
    
    void updateBoard()
    {
        if(mode == 1)
        {
            
        }
        else if(mode == 2)
        {
            board = ttt.getBoard();
        }
        else
        {
            board = q.getBoard();
        }
        
        if(mode != 1)
        {
            char c = board[0][0];
            if(c != ' ')
            {
                jButton1.setText(String.valueOf(c));
                if(c == 'X')
                    jButton1.setBackground(Color.blue);
                else
                    jButton1.setBackground(Color.red);
            }
            else
            {
                jButton1.setText(String.valueOf(c));
                jButton1.setBackground(null);
            }

            c = board[0][1];
            if(c != ' ')
            {
                jButton2.setText(String.valueOf(c));
                if(c == 'X')
                    jButton2.setBackground(Color.blue);
                else
                    jButton2.setBackground(Color.red);
            }
            else
            {
                jButton2.setText(String.valueOf(c));
                jButton2.setBackground(null);
            }

            c = board[0][2];
            if(c != ' ')
            {
                jButton3.setText(String.valueOf(c));
                if(c == 'X')
                    jButton3.setBackground(Color.blue);
                else
                    jButton3.setBackground(Color.red);
            }
            else
            {
                jButton3.setText(String.valueOf(c));
                jButton3.setBackground(null);
            }

            c = board[0][3];
            if(c != ' ')
            {
                jButton4.setText(String.valueOf(c));
                if(c == 'X')
                    jButton4.setBackground(Color.blue);
                else
                    jButton4.setBackground(Color.red);
            }
            else
            {
                jButton4.setText(String.valueOf(c));
                jButton4.setBackground(null);
            }

            c = board[0][4];
            if(c != ' ')
            {
                jButton5.setText(String.valueOf(c));
                if(c == 'X')
                    jButton5.setBackground(Color.blue);
                else
                    jButton5.setBackground(Color.red);
            }
            else
            {
                jButton5.setText(String.valueOf(c));
                jButton5.setBackground(null);
            }

            c = board[1][0];
            if(c != ' ')
            {
                jButton6.setText(String.valueOf(c));
                if(c == 'X')
                    jButton6.setBackground(Color.blue);
                else
                    jButton6.setBackground(Color.red);
            }
            else
            {
                jButton6.setText(String.valueOf(c));
                jButton6.setBackground(null);
            }

            c = board[1][1];
            if(c != ' ')
            {
                jButton7.setText(String.valueOf(c));
                if(c == 'X')
                    jButton7.setBackground(Color.blue);
                else
                    jButton7.setBackground(Color.red);
            }
            else
            {
                jButton7.setText(String.valueOf(c));
                jButton7.setBackground(null);
            }

            c = board[1][2];
            if(c != ' ')
            {
                jButton8.setText(String.valueOf(c));
                if(c == 'X')
                    jButton8.setBackground(Color.blue);
                else
                    jButton8.setBackground(Color.red);
            }
            else
            {
                jButton8.setText(String.valueOf(c));
                jButton8.setBackground(null);
            }

            c = board[1][3];
            if(c != ' ')
            {
                jButton9.setText(String.valueOf(c));
                if(c == 'X')
                    jButton9.setBackground(Color.blue);
                else
                    jButton9.setBackground(Color.red);
            }
            else
            {
                jButton9.setText(String.valueOf(c));
                jButton9.setBackground(null);
            }

            c = board[1][4];
            if(c != ' ')
            {
                jButton10.setText(String.valueOf(c));
                if(c == 'X')
                    jButton10.setBackground(Color.blue);
                else
                    jButton10.setBackground(Color.red);
            }
            else
            {
                jButton10.setText(String.valueOf(c));
                jButton10.setBackground(null);
            }

            c = board[2][0];
            if(c != ' ')
            {
                jButton11.setText(String.valueOf(c));
                if(c == 'X')
                    jButton11.setBackground(Color.blue);
                else
                    jButton11.setBackground(Color.red);
            }
            else
            {
                jButton11.setText(String.valueOf(c));
                jButton11.setBackground(null);
            }

            c = board[2][1];
            if(c != ' ')
            {
                jButton12.setText(String.valueOf(c));
                if(c == 'X')
                    jButton12.setBackground(Color.blue);
                else
                    jButton12.setBackground(Color.red);
            }
            else
            {
                jButton12.setText(String.valueOf(c));
                jButton12.setBackground(null);
            }

            c = board[2][2];
            if(c != ' ')
            {
                jButton13.setText(String.valueOf(c));
                if(c == 'X')
                    jButton13.setBackground(Color.blue);
                else
                    jButton13.setBackground(Color.red);
            }
            else
            {
                jButton13.setText(String.valueOf(c));
                jButton13.setBackground(null);
            }

            c = board[2][3];
            if(c != ' ')
            {
                jButton14.setText(String.valueOf(c));
                if(c == 'X')
                    jButton14.setBackground(Color.blue);
                else
                    jButton14.setBackground(Color.red);
            }
            else
            {
                jButton14.setText(String.valueOf(c));
                jButton14.setBackground(null);
            }

            c = board[2][4];
            if(c != ' ')
            {
                jButton15.setText(String.valueOf(c));
                if(c == 'X')
                    jButton15.setBackground(Color.blue);
                else
                    jButton15.setBackground(Color.red);
            }
            else
            {
                jButton15.setText(String.valueOf(c));
                jButton15.setBackground(null);
            }

            c = board[3][0];
            if(c != ' ')
            {
                jButton16.setText(String.valueOf(c));
                if(c == 'X')
                    jButton16.setBackground(Color.blue);
                else
                    jButton16.setBackground(Color.red);
            }
            else
            {
                jButton16.setText(String.valueOf(c));
                jButton16.setBackground(null);
            }

            c = board[3][1];
            if(c != ' ')
            {
                jButton17.setText(String.valueOf(c));
                if(c == 'X')
                    jButton17.setBackground(Color.blue);
                else
                    jButton17.setBackground(Color.red);
            }
            else
            {
                jButton17.setText(String.valueOf(c));
                jButton17.setBackground(null);
            }

            c = board[3][2];
            if(c != ' ')
            {
                jButton18.setText(String.valueOf(c));
                if(c == 'X')
                    jButton18.setBackground(Color.blue);
                else
                    jButton18.setBackground(Color.red);
            }
            else
            {
                jButton18.setText(String.valueOf(c));
                jButton18.setBackground(null);
            }

            c = board[3][3];
            if(c != ' ')
            {
                jButton19.setText(String.valueOf(c));
                if(c == 'X')
                    jButton19.setBackground(Color.blue);
                else
                    jButton19.setBackground(Color.red);
            }
            else
            {
                jButton19.setText(String.valueOf(c));
                jButton19.setBackground(null);
            }

            c = board[3][4];
            if(c != ' ')
            {
                jButton20.setText(String.valueOf(c));
                if(c == 'X')
                    jButton20.setBackground(Color.blue);
                else
                    jButton20.setBackground(Color.red);
            }
            else
            {
                jButton20.setText(String.valueOf(c));
                jButton20.setBackground(null);
            }

            c = board[4][0];
            if(c != ' ')
            {
                jButton21.setText(String.valueOf(c));
                if(c == 'X')
                    jButton21.setBackground(Color.blue);
                else
                    jButton21.setBackground(Color.red);
            }
            else
            {
                jButton21.setText(String.valueOf(c));
                jButton21.setBackground(null);
            }

            c = board[4][1];
            if(c != ' ')
            {
                jButton22.setText(String.valueOf(c));
                if(c == 'X')
                    jButton22.setBackground(Color.blue);
                else
                    jButton22.setBackground(Color.red);
            }
            else
            {
                jButton22.setText(String.valueOf(c));
                jButton22.setBackground(null);
            }

            c = board[4][2];
            if(c != ' ')
            {
                jButton23.setText(String.valueOf(c));
                if(c == 'X')
                    jButton23.setBackground(Color.blue);
                else
                    jButton23.setBackground(Color.red);
            }
            else
            {
                jButton23.setText(String.valueOf(c));
                jButton23.setBackground(null);
            }

            c = board[4][3];
            if(c != ' ')
            {
                jButton24.setText(String.valueOf(c));
                if(c == 'X')
                    jButton24.setBackground(Color.blue);
                else
                    jButton24.setBackground(Color.red);
            }
            else
            {
                jButton24.setText(String.valueOf(c));
                jButton24.setBackground(null);
            }

            c = board[4][4];
            if(c != ' ')
            {
                jButton25.setText(String.valueOf(c));
                if(c == 'X')
                    jButton25.setBackground(Color.blue);
                else
                    jButton25.setBackground(Color.red);
            }
            else
            {
                jButton25.setText(String.valueOf(c));
                jButton25.setBackground(null);
            }
        }
        else
        {
            char rboard[] = r.getBoard();
            char c = rboard[0];
            if(c != ' ')
            {
                jButton7.setText(String.valueOf(c));
                if(c == 'X')
                    jButton7.setBackground(Color.blue);
                else
                    jButton7.setBackground(Color.red);
            }
            else
            {
                jButton7.setText(String.valueOf(c));
                jButton7.setBackground(null);
            }

            c = rboard[1];
            if(c != ' ')
            {
                jButton8.setText(String.valueOf(c));
                if(c == 'X')
                    jButton8.setBackground(Color.blue);
                else
                    jButton8.setBackground(Color.red);
            }
            else
            {
                jButton8.setText(String.valueOf(c));
                jButton8.setBackground(null);
            }

            c = rboard[2];
            if(c != ' ')
            {
                jButton9.setText(String.valueOf(c));
                if(c == 'X')
                    jButton9.setBackground(Color.blue);
                else
                    jButton9.setBackground(Color.red);
            }
            else
            {
                jButton9.setText(String.valueOf(c));
                jButton9.setBackground(null);
            }
            
            c = rboard[3];
            if(c != ' ')
            {
                jButton12.setText(String.valueOf(c));
                if(c == 'X')
                    jButton12.setBackground(Color.blue);
                else
                    jButton12.setBackground(Color.red);
            }
            else
            {
                jButton12.setText(String.valueOf(c));
                jButton12.setBackground(null);
            }

            c = rboard[4];
            if(c != ' ')
            {
                jButton13.setText(String.valueOf(c));
                if(c == 'X')
                    jButton13.setBackground(Color.blue);
                else
                    jButton13.setBackground(Color.red);
            }
            else
            {
                jButton13.setText(String.valueOf(c));
                jButton13.setBackground(null);
            }

            c = rboard[5];
            if(c != ' ')
            {
                jButton14.setText(String.valueOf(c));
                if(c == 'X')
                    jButton14.setBackground(Color.blue);
                else
                    jButton14.setBackground(Color.red);
            }
            else
            {
                jButton14.setText(String.valueOf(c));
                jButton14.setBackground(null);
            }

            c = rboard[6];
            if(c != ' ')
            {
                jButton17.setText(String.valueOf(c));
                if(c == 'X')
                    jButton17.setBackground(Color.blue);
                else
                    jButton17.setBackground(Color.red);
            }
            else
            {
                jButton17.setText(String.valueOf(c));
                jButton17.setBackground(null);
            }

            c = rboard[7];
            if(c != ' ')
            {
                jButton18.setText(String.valueOf(c));
                if(c == 'X')
                    jButton18.setBackground(Color.blue);
                else
                    jButton18.setBackground(Color.red);
            }
            else
            {
                jButton18.setText(String.valueOf(c));
                jButton18.setBackground(null);
            }

            c = rboard[8];
            if(c != ' ')
            {
                jButton19.setText(String.valueOf(c));
                if(c == 'X')
                    jButton19.setBackground(Color.blue);
                else
                    jButton19.setBackground(Color.red);
            }
            else
            {
                jButton19.setText(String.valueOf(c));
                jButton19.setBackground(null);
            }
        }
    }
    
    boolean move(int pos){
        
        switch (mode) {
            case 1:
                if(pos < 10)
                    pos -= 6;
                else if(pos < 15)
                    pos -= 8;
                else
                    pos -= 10;
                if(r.playerMove(pos))
                {
                    r.printBoard();
                    updateBoard();
                    if(!r.checkWin('X'))
                    {
                        r.engineMove();
                        r.printBoard();
                        updateBoard();
                        
                        if(r.checkWin('O')){
                            JOptionPane.showMessageDialog(this, "You win!");
                            JOptionPane.showMessageDialog(this, "GAME OVER!");
                            
                            try {
                                disableButton(5);
                            } catch (IOException ex) {
                                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(this, "You lose!");
                        JOptionPane.showMessageDialog(this, "GAME OVER!");
                        try {
                            disableButton(5);
                        } catch (IOException ex) {
                            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    return true;
                }
                break;
            case 2:
                board = ttt.getBoard();
                if(ttt.playersTurn(board, pos))
                {
                    ttt.printBoard(board);
                    updateBoard();
                    if(!ttt.gameOver(board))
                    {
                        ttt.computersTurn(board, difficulty);
                        ttt.printBoard(board);
                        updateBoard();
                        
                        if(ttt.gameOver(board))
                        {
                            JOptionPane.showMessageDialog(this, "GAME OVER!");
                            try {
                                disableButton(5);
                            } catch (IOException ex) {
                                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(this, "GAME OVER!");
                        try {
                            disableButton(5);
                        } catch (IOException ex) {
                            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    return true;
                }
                break;
            default:
                board = q.getBoard();
                if(q.playersTurn(board, pos))
                {
                    q.printBoard(board);
                    updateBoard();
                    if(!q.gameOver(board))
                    {
                        q.computersTurn(board, difficulty);
                        q.printBoard(board);
                        updateBoard();
                        
                        if(q.gameOver(board))
                        {
                            JOptionPane.showMessageDialog(this, "GAME OVER!");
                            try {
                                disableButton(5);
                            } catch (IOException ex) {
                                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(this, "GAME OVER!");
                        try {
                            disableButton(5);
                        } catch (IOException ex) {
                            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    return true;
                }
                break;
        }
        
        return false;
    }
    
    public GUI() {
        initComponents();
        this.setLocationRelativeTo(null);
        Random random = new Random();
        
        try {
            loadScore();
        } catch (IOException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        // Generate a random number in the range of 1-3
        int tttSelection = random.nextInt(3) + 1;
//        int tttSelection = 1;
        
        
        switch (tttSelection) {
            case 1 ->                 {
                    r = new ReverseTicTacToe();
                    jTextField2.setText("ReverseTicTacToe");
                    this.setTitle("Reverse TicTacToe");
                    mode = 1;
//                    enableButton(3);
//                    game.start();
//                    GUI g = new GUI();
//                    g.setVisible(true);
                }
            case 2 ->                 {
                    ttt = new TicTacToe(); // Create an instance of the TicTacToe class
                    jTextField2.setText("TicTacToe");
                    this.setTitle("TicTacToe");
                    mode = 2;
//                    enableButton(5);
//                    String[] gameArgs = {}; // Optional command-line arguments for the TicTacToe main method
//                    game.main(gameArgs);
//                    new GUI().setVisible(true);
                }
            case 3 ->                 {
                    q = new Quixo(); // Create an instance of the TicTacToe class
                    jTextField2.setText("Quixo");
                    this.setTitle("Quixo TicTacToe");
                    mode = 3;
//                    enableButton(5);
//                    String[] gameArgs = {}; // Optional command-line arguments for the TicTacToe main method
//                    game.main(gameArgs);
//                    new GUI().setVisible(true);
                }
            default -> {
            }
        }
    }

//    public GUI(ReverseTicTacToe game) {
//        initComponents();
//    }
//
//    public GUI(TicTacToe game) {
//        initComponents();
//    }
//
//    public GUI(Quixo game) {
//        initComponents();
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jButton22 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton26 = new javax.swing.JButton();
        jButton27 = new javax.swing.JButton();
        jButton28 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jButton29 = new javax.swing.JButton();
        jButton30 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Name");

        jTextField1.setNextFocusableComponent(jPasswordField1);
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("LEADERBOARD");

        jList1.setFont(new java.awt.Font("Monospaced", 1, 10)); // NOI18N
        jList1.setPreferredSize(new java.awt.Dimension(268, 442));
        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 268, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );

        jButton1.setEnabled(false);
        jButton1.setPreferredSize(new java.awt.Dimension(70, 70));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setEnabled(false);
        jButton2.setPreferredSize(new java.awt.Dimension(70, 70));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setEnabled(false);
        jButton3.setPreferredSize(new java.awt.Dimension(70, 70));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setEnabled(false);
        jButton4.setPreferredSize(new java.awt.Dimension(70, 70));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setEnabled(false);
        jButton5.setPreferredSize(new java.awt.Dimension(70, 70));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setEnabled(false);
        jButton6.setPreferredSize(new java.awt.Dimension(70, 70));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setEnabled(false);
        jButton7.setPreferredSize(new java.awt.Dimension(70, 70));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setEnabled(false);
        jButton8.setPreferredSize(new java.awt.Dimension(70, 70));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setEnabled(false);
        jButton9.setPreferredSize(new java.awt.Dimension(70, 70));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setEnabled(false);
        jButton10.setPreferredSize(new java.awt.Dimension(70, 70));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jButton11.setEnabled(false);
        jButton11.setPreferredSize(new java.awt.Dimension(70, 70));
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jButton12.setEnabled(false);
        jButton12.setPreferredSize(new java.awt.Dimension(70, 70));
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jButton13.setEnabled(false);
        jButton13.setPreferredSize(new java.awt.Dimension(70, 70));
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jButton14.setEnabled(false);
        jButton14.setPreferredSize(new java.awt.Dimension(70, 70));
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jButton15.setEnabled(false);
        jButton15.setPreferredSize(new java.awt.Dimension(70, 70));
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jButton16.setEnabled(false);
        jButton16.setPreferredSize(new java.awt.Dimension(70, 70));
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jButton17.setEnabled(false);
        jButton17.setPreferredSize(new java.awt.Dimension(70, 70));
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jButton18.setEnabled(false);
        jButton18.setPreferredSize(new java.awt.Dimension(70, 70));
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });

        jButton19.setEnabled(false);
        jButton19.setPreferredSize(new java.awt.Dimension(70, 70));
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });

        jButton20.setEnabled(false);
        jButton20.setPreferredSize(new java.awt.Dimension(70, 70));
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });

        jButton21.setEnabled(false);
        jButton21.setPreferredSize(new java.awt.Dimension(70, 70));
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });

        jButton22.setEnabled(false);
        jButton22.setPreferredSize(new java.awt.Dimension(70, 70));
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });

        jButton23.setEnabled(false);
        jButton23.setPreferredSize(new java.awt.Dimension(70, 70));
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });

        jButton24.setEnabled(false);
        jButton24.setPreferredSize(new java.awt.Dimension(70, 70));
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });

        jButton25.setEnabled(false);
        jButton25.setPreferredSize(new java.awt.Dimension(70, 70));
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton21, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                    .addComponent(jButton16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE)
                    .addComponent(jButton11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addGap(4, 4, 4)
                            .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(10, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton22, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton23, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton24, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton25, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel3.setText("Game");

        jTextField2.setEditable(false);
        jTextField2.setEnabled(false);

        jLabel4.setText("Mode");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Easy", "Medium", "Hard" }));
        jComboBox1.setEnabled(false);
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButton26.setText("Start");
        jButton26.setEnabled(false);
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });

        jButton27.setText("Save");
        jButton27.setEnabled(false);
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });

        jButton28.setText("Load");
        jButton28.setEnabled(false);
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });

        jLabel5.setText("Pass");

        jButton29.setText("Register");
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });

        jButton30.setText("Login");
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton27, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton28, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton29))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(jButton30))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton27)
                            .addComponent(jButton28))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton26))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        // TODO add your handling code here:
        if(jButton26.getText().equals("Start"))
        {
            jButton26.setText("Restart");
        }
        if(jTextField1.getText().trim().isEmpty())
        {
            JOptionPane.showMessageDialog(rootPane, "Enter your name first!", "Error", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            jTextField1.setEditable(false);
            if(mode == 1)
            {
                enableButton(3);
                String[] args = {String.valueOf(difficulty)};
                r.start(String.valueOf(difficulty));
                r.printBoard();
                updateBoard();
                
            }
            else
            {
                enableButton(5);
                
                if(mode == 2)
                {
                    String[] args = {String.valueOf(difficulty)};
                    ttt.main(args);
                    ttt.resetBoard();
                    board = ttt.getBoard();
                    updateBoard();
                }
                else
                {
                    String[] args = {String.valueOf(difficulty)};
                    q.main(args);
                    q.resetBoard();
                    board = q.getBoard();
                    updateBoard();
                }
            }
        }
    }//GEN-LAST:event_jButton26ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        difficulty = jComboBox1.getSelectedIndex()+1;
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
//        if(move(1))
//        {
//            jButton1.setText("X");
//            jButton1.setBackground(Color.blue);
//        }
        move(1);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        move(2);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        move(3);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        move(4);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        move(5);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        move(6);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        move(7);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        move(8);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        move(9);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        move(10);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        move(11);
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        move(12);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        move(13);
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
        move(14);
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
        move(15);
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
        move(16);
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
        move(17);
    }//GEN-LAST:event_jButton17ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        // TODO add your handling code here:
        move(18);
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        // TODO add your handling code here:
        move(19);
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        // TODO add your handling code here:
        move(20);
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        // TODO add your handling code here:
        move(21);
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        // TODO add your handling code here:
        move(22);
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        // TODO add your handling code here:
        move(23);
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        // TODO add your handling code here:
        move(24);
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        // TODO add your handling code here:
        move(25);
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        try {
            // TODO add your handling code here:
            saveGame();
        } catch (IOException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton27ActionPerformed

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
        // TODO add your handling code here:
        loadGame();
    }//GEN-LAST:event_jButton28ActionPerformed

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
        // TODO add your handling code here:
        List<User> users = loadUser();
        if(jTextField1.getText().trim().isEmpty() || String.valueOf(jPasswordField1.getPassword()).trim().isBlank())
        {
            JOptionPane.showMessageDialog(rootPane, "Enter name and pass first!", "Empty inputs!", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
        
            if(users.isEmpty())
            {
                users.add(new User(jTextField1.getText().toUpperCase(), String.valueOf(jPasswordField1.getPassword())));
            }
            else
            {
                boolean found = false;
                for(User u : users)
                {
                    if(u.getName().equalsIgnoreCase(jTextField1.getText()))
                    {
                        JOptionPane.showMessageDialog(rootPane, "Account already registered, please login or register new account with new name!");
                        found = true;
                        break;
                    }
                }
                
                if(!found)
                {
                    users.add(new User(jTextField1.getText().toUpperCase(), String.valueOf(jPasswordField1.getPassword())));
                    JOptionPane.showMessageDialog(rootPane, "Account registered! Please click login to start playing the game!");
                }
            }
        }
        
        saveUsers(users);
    }//GEN-LAST:event_jButton29ActionPerformed

    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
        // TODO add your handling code here:
        
        List<User> users = loadUser();
        if(jTextField1.getText().trim().isEmpty() || String.valueOf(jPasswordField1.getPassword()).trim().isBlank())
        {
            JOptionPane.showMessageDialog(rootPane, "Enter name and pass first!", "Empty inputs!", JOptionPane.ERROR_MESSAGE);
        }
        else
        {
            if(jButton30.getText().equalsIgnoreCase("Login"))
            {
                boolean found = false;
                boolean pass = false;
                for(User u : users)
                {
                    if(u.getName().equalsIgnoreCase(jTextField1.getText()))
                        pass = true;
                    if(u.getName().equalsIgnoreCase(jTextField1.getText()) && u.getPass().equalsIgnoreCase(String.valueOf(jPasswordField1.getPassword())))
                    {
                        JOptionPane.showMessageDialog(rootPane, "Login successful! Welcome " + u.getName() + "!");
                        jButton26.setEnabled(true);
                        jButton27.setEnabled(true);
                        jButton28.setEnabled(true);
                        jTextField1.setEditable(false);
                        jTextField2.setEnabled(true);
                        jComboBox1.setEnabled(true);
                        jPasswordField1.setEditable(false);
                        jButton29.setEnabled(false);
                        found = true;
                        jButton30.setText("Logout");
                        break;
                    }
                }

                if(!found)
                {
                    if(pass)
                    {
                        JOptionPane.showMessageDialog(rootPane, "Wrong password! Try again or register new player!");
                    }
                    else
                    //users.add(new User(jTextField1.getText().toUpperCase(), String.valueOf(jPasswordField1.getPassword())));
                        JOptionPane.showMessageDialog(rootPane, "Account has not been registered yet, click register!");
                }
            }
            else
            {
//                mode = new Random().nextInt(3) + 1;
                
//                initComponents();
                if(mode == 1)
                {
                    r.resetBoard();
                }
                else if(mode == 2)
                {
                    ttt.resetBoard();
                }
                else
                    q.resetBoard();
                
                updateBoard();
                
                jButton30.setText("Login");
                jTextField1.setEditable(true);
                jTextField1.setText("");
                jPasswordField1.setText("");
                jPasswordField1.setEditable(true);
                disableButton();
                
                jComboBox1.setEnabled(false);
                jTextField2.setEnabled(false);
                jButton29.setEnabled(true);
                
                jButton26.setEnabled(false);
                jButton27.setEnabled(false);
                jButton28.setEnabled(false);
                
            }
        }
    }//GEN-LAST:event_jButton30ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables

    private void saveScore(String result) throws IOException {
        FileWriter fw = new FileWriter("score.txt", true);
        try (BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(jTextField1.getText().toUpperCase() + "," + result);
            bw.newLine();
        }
        
        loadScore();
    }
    
    private void loadScore() throws IOException {
        
        List<Score> scores = new ArrayList<>();
        
        FileReader fr = new FileReader("score.txt");
        try (BufferedReader br = new BufferedReader(fr)) {
            String line = br.readLine();
            
            while(line != null)  {
                String[] data = line.split(",");
                int sc = Integer.parseInt(data[1]);
                
//                JOptionPane.showMessageDialog(null, data[0]);
//                JOptionPane.showMessageDialog(null, sc);
                
                if(scores.isEmpty())  {
                    Score s = new Score(data[0], 0, 0, 0);
                    
                    if(sc == 1)
                    {
                        s.setWin(1);
                    }
                    else if(sc == 2)
                    {
                        s.setDraw(1);
                    }
                    else
                    {
                        s.setLose(1);
                    }
                    
                    scores.add(s);
                }
                else
                {
                    boolean exist = false;
                    
                    for(Score s : scores)
                    {
                        if(s.getName().equalsIgnoreCase(data[0]))
                        {
                            if(sc == 1)
                            {
                                s.setWin(s.getWin()+1);
                            }
                            else if(sc == 2)
                            {
                                s.setDraw(s.getDraw()+1);
                            }
                            else
                            {
                                s.setLose(s.getLose()+1);
                            }
                            
                            exist = true;
                            break;
                        }
                    }
                    
                    if(!exist)
                    {
                        Score s = new Score(data[0], 0, 0, 0);
                    
                        if(sc == 1)
                        {
                            s.setWin(1);
                        }
                        else if(sc == 2)
                        {
                            s.setDraw(1);
                        }
                        else
                        {
                            s.setLose(1);
                        }

                        scores.add(s);
                    }
                }
                
                line = br.readLine();
            }
        }
        
        DefaultListModel dlm = new DefaultListModel();
        
//        dlm.addAll(scores);
        int count = 1;
        
        String header = "| ## |  PLAYER   | WIN  | DRAW | LOSE |";
        
        dlm.addElement(header);
//        dlm.addElement(linebr);

//        CompareScore cs;

//        scores = scores.sort(new CompareScore());

        Collections.sort(scores, new CompareScore());
        
        for(Score s : scores)
        {
            String place = String.valueOf(count);
            if(count < 10)
            {
                place += " ";
            }
            String player = s.getName();
            int space = (9 - player.length()) / 2;
            
            while(space > 0)
            {
                player = " " + player + " ";
                space--;
            }
            
            while(player.length() < 9)
            {
                player += " ";
            }
            
            String win = String.valueOf(s.getWin());
            
            space = (4 - win.length()) / 2;
            
            while(space > 0)
            {
                win = " " + win + " ";
                space--;
            }
            
            while(win.length() < 4)
            {
                win += " ";
            }
            
            String draw = String.valueOf(s.getDraw());
            
            space = (4 - draw.length()) / 2;
            
            while(space > 0)
            {
                draw = " " + draw + " ";
                space--;
            }
            
            while(draw.length() < 4)
            {
                draw += " ";
            }
            
            String lose = String.valueOf(s.getLose());
            
            space = (4 - lose.length()) / 2;
            
            while(space > 0)
            {
                lose = " " + lose + " ";
                space--;
            }
            
            while(lose.length() < 4)
            {
                lose += " ";
            }
            
            dlm.addElement("| " + place + " | " + player + " | " + win + " | " + draw + " | " + lose + " | ");
            count++;
        }
        
        jList1.setModel(dlm);
        
//        for(Score s : scores)
//        {
//            dlm.
//        }
        
    }
    
    
    private void saveGame() throws IOException {
        String filename = JOptionPane.showInputDialog("Enter the filename you want to save as (wihtout .txt) : ");
        FileWriter fw = new FileWriter(filename + ".txt", false);
        try (BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(jTextField1.getText().toUpperCase() + "," + mode + "," + difficulty);
            bw.newLine();
            
            if(mode == 1)
            {
                char rboard[] = r.getBoard();
                
                for(int i = 0; i < 9; i++)
                {
                    bw.write(rboard[i]);
                }
            }
            else
            {
                if(mode == 2)
                    board = ttt.getBoard();
                else
                    board = q.getBoard();
                for(int i = 0; i < 5; i++)
                {
                    for(int j = 0; j < 5; j++)
                    {
                        bw.write(board[i][j]);
                    }
                }
                
                bw.newLine();
            }
        }
        
        JOptionPane.showMessageDialog(rootPane, "Game saved!");
    }
    
    private boolean loadGame() 
    {
        String filename = JOptionPane.showInputDialog("Enter the filename you want to load from (wihtout .txt) : ");
        
        try
        {
            FileReader fr = new FileReader(filename + ".txt");
            try (BufferedReader br = new BufferedReader(fr)) {
                String line = br.readLine();
                String[] data = line.split(",");
                if(!jTextField1.getText().equalsIgnoreCase(data[0]))
                {
                    JOptionPane.showMessageDialog(rootPane, "You are not allowed to load someone's game! Load your own games, or start saving a new one.", "No access!", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
//                jTextField1.setText(data[0]);
                jTextField1.setEditable(false);
                mode = Integer.parseInt(data[1]);
                difficulty = Integer.parseInt(data[2]);

                line = br.readLine();

                if(mode == 1)
                {
                    r.start(String.valueOf(difficulty));
                    char[] rboard = r.getBoard();

                    for(int i = 0; i < 9; i++)
                    {
                        rboard[i] = line.charAt(i);
                    }

                    r.setBoard(rboard);
                    enableButton(3);
                    updateBoard();
                }
                else if(mode == 2)
                {
                    String[] args = {String.valueOf(difficulty)};
                    ttt.main(args);
                    
                    int index = 0;
                    
                    for(int i = 0; i < 5; i++)
                    {
                        for(int j = 0; j < 5; j++)
                        {
                            board[i][j] = line.charAt(index);
                            index++;
                        }
                    }
                    enableButton(5);
                    updateBoard();
                }
                else
                {
                    String[] args = {String.valueOf(difficulty)};
                    q.main(args);
                    
                    int index = 0;
                    
                    for(int i = 0; i < 5; i++)
                    {
                        for(int j = 0; j < 5; j++)
                        {
                            board[i][j] = line.charAt(index);
                            index++;
                        }
                    }
                    enableButton(5);
                    updateBoard();
                }
                
                
        
                JOptionPane.showMessageDialog(rootPane, "Game loaded!");
                return true;
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(rootPane, "File not found!", "File error!", JOptionPane.ERROR_MESSAGE);
            }
        }
        catch(HeadlessException | FileNotFoundException e)
        {
                JOptionPane.showMessageDialog(rootPane, "File not found!", "File error!", JOptionPane.ERROR_MESSAGE);
        }
        return false;
    }

    private List<User> loadUser() {
        List<User> user = new ArrayList<>();
        try
        {
            FileReader fr = new FileReader("users.txt");
            try (BufferedReader br = new BufferedReader(fr)) {
                String line = br.readLine();
                
                while(line != null)
                {
                    String[] data = line.split(",");
                    
                    user.add(new User(data[0], data[1]));
                    
                    line = br.readLine();
                }

            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(rootPane, "File not found!", "File error!", JOptionPane.ERROR_MESSAGE);
            }
        }
        catch(HeadlessException | FileNotFoundException e)
        {
                JOptionPane.showMessageDialog(rootPane, "File not found!", "File error!", JOptionPane.ERROR_MESSAGE);
        }
        return user;
    }

    private void saveUsers(List<User> users) {
        FileWriter fw;
        try {
            fw = new FileWriter("users.txt", false);
            try (BufferedWriter bw = new BufferedWriter(fw)) {
                    for(User u : users)
                    {
                        bw.write(u.getName() + "," + u.getPass());
                        bw.newLine();
                    }
            } catch (IOException ex) {
                Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        } catch (IOException ex) {
            Logger.getLogger(GUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}



