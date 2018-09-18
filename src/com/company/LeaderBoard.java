package com.company;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;

/**
 * Created by jobae on 1/3/2017.
 */
public class LeaderBoard extends JFrame {
    private FileReader fr;
    private BufferedReader br;
    private JLabel highScore;
    private JLabel playerInfo1;
    private JLabel playerInfo2;
    private JLabel playerInfo3;
    private FileWriter fw;
    private BufferedWriter bw;

    public static ArrayList<Scores> scoreList;

    public LeaderBoard() throws HeadlessException, IOException {
        super("Leaderboard");
        fr = new FileReader("scoreSheet.txt");
        br = new BufferedReader(fr);
        this.getContentPane().setBackground(Color.ORANGE);
        this.setLayout(null);
        this.setSize(400,300);

        highScore = new JLabel();
        highScore.setText("Leaderboard");
        highScore.setForeground(Color.RED);
        highScore.setFont(new Font("Segoe UI Black", Font.BOLD, 30));
        highScore.setBounds(70,20,220,40);

        playerInfo1 = new JLabel();
        playerInfo1.setForeground(Color.WHITE);
        playerInfo1.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
        playerInfo1.setBounds(40,100,300,30);

        playerInfo2 = new JLabel();
        playerInfo2.setForeground(Color.WHITE);
        playerInfo2.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
        playerInfo2.setBounds(40,140,300,30);

        playerInfo3 = new JLabel();
        playerInfo3.setForeground(Color.WHITE);
        playerInfo3.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
        playerInfo3.setBounds(40,180,300,30);

        scoreList = new ArrayList<>();

        int count = 0;
        String temp = "";

        //writeInFile();
        takeInputFromFile();

        Collections.sort(scoreList, new Comparator<Scores>() {
            @Override
            public int compare(Scores o1, Scores o2) {
                return o1.getScore()-o2.getScore();
            }
        });
        Collections.reverse(scoreList);
        fw = new FileWriter("ScoreSheet", true);
        bw = new BufferedWriter(fw);

        for(Scores tempScores : scoreList) {

            String str = tempScores.toString();
            count++;
            if(count == 1)
            {
                temp = count + ". " + str;
                playerInfo1.setText(temp);
            }
            if(count == 2)
            {
                temp = count + ". " + str;
                playerInfo2.setText(temp);
            }

            if (count == 3)
            {
                temp = count + ". " + str;
                playerInfo3.setText(temp);
            }
        }

        this.add(highScore);
        this.add(playerInfo1);
        this.add(playerInfo2);
        this.add(playerInfo3);
    }


    public static void takeInputFromFile(){
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("scoreSheet.txt"));
            String tempStr = reader.readLine();

            while(tempStr!=null){
                StringTokenizer tok = new StringTokenizer(tempStr);
                Scores newScores = new Scores();
                newScores.setScore(Integer.parseInt(tok.nextToken()));
                newScores.setName(tok.nextToken());
                scoreList.add(newScores);

                tempStr = reader.readLine();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void writeInFile(){
        BufferedWriter writer;

        try {
            writer = new BufferedWriter(new FileWriter("scoreSheet.txt"));
            for(Scores tempScores : scoreList){
                writer.write(tempScores.getScore() + " " + tempScores.getName() + "\n");
            }

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
