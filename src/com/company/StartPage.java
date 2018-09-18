package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.MalformedURLException;
import java.util.*;

/**
 * Created by jobae on 1/3/2017.
 */
public class StartPage extends JFrame implements ActionListener {
    private JButton start;
    private JButton leaderBoard;

    private FileReader fr;
    private BufferedReader br;
    private FileWriter fw;
    private BufferedWriter bw;

    public StartPage() throws HeadlessException {
        super("Hungry Shark Reloaded!");
        this.setLayout(null);
        this.setSize(800,600);
        this.setContentPane(new JLabel(new ImageIcon(this.getClass().getResource("\\Images\\first.jpg"))));
        start = new JButton("Start");
        start.setForeground(Color.ORANGE);
        start.setBackground(Color.BLUE);
        start.setFont(new Font("Serif", Font.BOLD, 20));
        start.setBounds(10,500,150,30);
        start.addActionListener(this);
        this.add(start);

        leaderBoard = new JButton("Leaderboard");
        leaderBoard.setForeground(Color.ORANGE);
        leaderBoard.setBackground(Color.BLUE);
        leaderBoard.setFont(new Font("Serif", Font.BOLD, 20));
        leaderBoard.setBounds(180,500,150,30);
        leaderBoard.addActionListener(this);
        this.add(leaderBoard);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new StartPage().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == start)
        {
            try {
                new Frame().setVisible(true);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            } catch (MalformedURLException e1) {
                e1.printStackTrace();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
        if(e.getSource() == leaderBoard)
        {
            try {
                new LeaderBoard().setVisible(true);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}

