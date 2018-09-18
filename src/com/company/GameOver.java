package com.company;

import javax.swing.*;
import java.awt.*;
import java.io.*;

/**
 * Created by jobae on 1/3/2017.
 */
public class GameOver extends JFrame {
    private JLabel over;
    private JLabel scorer;

    private FileReader fr;
    private BufferedReader br;

    private FileWriter fw;
    private BufferedWriter bw;

    public GameOver(int score) throws HeadlessException, IOException {
        super("Game Over!");
        this.setLayout(null);
        this.setSize(400, 400);
        this.setContentPane(new JLabel(new ImageIcon(this.getClass().getResource("\\Images\\second.jpg"))));
        over = new JLabel("Game Over!");
        over.setForeground(Color.RED);
        over.setFont(new Font("IMPACT", Font.BOLD, 48));
        over.setBounds(70, 200, 300, 100);

        scorer = new JLabel();
        scorer.setText("Score : " + score);
        scorer.setForeground(Color.YELLOW);
        scorer.setFont(new Font("Monotype Corsiva", Font.BOLD, 30));
        scorer.setBounds(150, 180, 200, 30);

        this.add(scorer);
        this.add(over);
        fr = new FileReader("scoreSheet.txt");
        br = new BufferedReader(fr);
        fw = new FileWriter("scoreSheet.txt", true);
        bw = new BufferedWriter(fw);
        String name = JOptionPane.showInputDialog("Input your Name");

        if(br.readLine() == null)
        {
            bw.write(score + " " + name + "\n");
            bw.flush();
        }
        else
        {
            bw.write(score + " " + name + "\n");
            bw.flush();
        }

    }
}
